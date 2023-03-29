package com.ShoppingMart.ShoppingMartBackendClone.Service.ServiceImpl;

import com.ShoppingMart.ShoppingMartBackendClone.Enum.ProductStatus;
import com.ShoppingMart.ShoppingMartBackendClone.Exception.CustomerNotFoundException;
import com.ShoppingMart.ShoppingMartBackendClone.Exception.ProductNotFoundException;
import com.ShoppingMart.ShoppingMartBackendClone.Model.*;
import com.ShoppingMart.ShoppingMartBackendClone.Repository.CustomerRepository;
import com.ShoppingMart.ShoppingMartBackendClone.Repository.ProductRepository;
import com.ShoppingMart.ShoppingMartBackendClone.RequestDto.OrderRequestDto;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.OrderResponseDto;
import com.ShoppingMart.ShoppingMartBackendClone.Service.CartService;
import com.ShoppingMart.ShoppingMartBackendClone.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderService orderService;
    public String addToCart(OrderRequestDto orderRequestDto) throws Exception {
        Product product;
        try {
            product = productRepository.findById(orderRequestDto.getProductId()).get();
        }
        catch (Exception e){
            throw new ProductNotFoundException("Invalid product Id");
        }
        Customer customer;
        try {
            customer = customerRepository.findById(orderRequestDto.getCustomerId()).get();
        }
        catch (Exception e){
            throw   new CustomerNotFoundException("Invalid Customer Id");
        }
        if(product.getQuantity() < orderRequestDto.getRequiredQuantity()){
            throw new Exception("Sorry! Required quantity is not available");
        }
        Cart cart = customer.getCart();

        int newCost = cart.getCartTotal() + orderRequestDto.getRequiredQuantity() * product.getPrice();
        cart.setCartTotal(newCost);

        Item item = new Item();
        item.setRequiredQuantity(orderRequestDto.getRequiredQuantity());
        item.setCart(cart);
        item.setProduct(product);

        cart.getItems().add(item);

        customerRepository.save(customer);

        return "Item has been added to your Cart!!";
    }
    public List<OrderResponseDto> checkoutCart(int customerId) throws CustomerNotFoundException {
        Customer customer;
        try {
            customer = customerRepository.findById(customerId).get();
        }
        catch (Exception e){
            throw   new CustomerNotFoundException("Invalid Customer Id");
        }

        List<OrderResponseDto> orderResponseDtos = new ArrayList<>();
        int totalCost = customer.getCart().getCartTotal();
        Cart cart = customer.getCart();
        for(Item item: cart.getItems()){
            Ordered order = new Ordered();
            int deliveryCharge = 0;
            if(totalCost < 500) deliveryCharge = 50;
            order.setTotalCost(item.getRequiredQuantity()*item.getProduct().getPrice()+deliveryCharge);
            order.setDeliveryCharge(deliveryCharge);

            order.setCustomer(customer);
            order.getOrderedItems().add(item);

            Card card = customer.getCards().get(0);
            String cardNo = "";
            for(int i=0;i<card.getCardNo().length()- 4;i++){
                if(card.getCardNo().charAt(i) == '-'){
                    cardNo += "-";
                }
                else{
                    cardNo += "X";
                }
            }
            cardNo += card.getCardNo().substring(card.getCardNo().length()-4);
            order.setCardUsedForPayment(cardNo);

            int leftQuantity = item.getProduct().getQuantity()-item.getRequiredQuantity();
            if(leftQuantity<=0)
                item.getProduct().setProductStatus(ProductStatus.OUT_OF_STOCK);
            item.getProduct().setQuantity(leftQuantity);

            customer.getOrderList().add(order);

            // prepare response dto
            OrderResponseDto orderResponseDto = OrderResponseDto.builder()
                    .productName(item.getProduct().getProductName())
                    .orderDate(order.getOrderDate())
                    .quantityOrdered(item.getRequiredQuantity())
                    .cardUsedForPayment(cardNo)
                    .itemPrice(item.getProduct().getPrice())
                    .totalCost(order.getTotalCost())
                    .orderDate(order.getOrderDate())
                    .deliveryCharge(deliveryCharge)
                    .build();

            orderResponseDtos.add(orderResponseDto);
        }

        cart.setItems(new ArrayList<>());
        cart.setCartTotal(0);
        customerRepository.save(customer);


        return orderResponseDtos;
    }
}
