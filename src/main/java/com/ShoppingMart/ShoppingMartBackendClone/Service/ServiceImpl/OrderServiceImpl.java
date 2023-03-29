package com.ShoppingMart.ShoppingMartBackendClone.Service.ServiceImpl;

import com.ShoppingMart.ShoppingMartBackendClone.Enum.ProductStatus;
import com.ShoppingMart.ShoppingMartBackendClone.Exception.CustomerNotFoundException;
import com.ShoppingMart.ShoppingMartBackendClone.Exception.ProductNotFoundException;
import com.ShoppingMart.ShoppingMartBackendClone.Model.*;
import com.ShoppingMart.ShoppingMartBackendClone.Repository.CustomerRepository;
import com.ShoppingMart.ShoppingMartBackendClone.Repository.OrderRepository;
import com.ShoppingMart.ShoppingMartBackendClone.Repository.ProductRepository;
import com.ShoppingMart.ShoppingMartBackendClone.RequestDto.OrderRequestDto;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.OrderResponseDto;
import com.ShoppingMart.ShoppingMartBackendClone.Service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;
    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) throws Exception {
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
        Ordered order = new Ordered();
        int totalCost = orderRequestDto.getRequiredQuantity() * product.getPrice();
        int deliveryCharge = 0;
        if(totalCost < 500) deliveryCharge = 50;
        order.setTotalCost(deliveryCharge+totalCost);
        order.setDeliveryCharge(deliveryCharge);

        // prepare the card String
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
        cardNo += card.getCardNo().substring(card.getCardNo().length() - 4);
        order.setCardUsedForPayment(cardNo);

        Item item = new Item();
        item.setRequiredQuantity(orderRequestDto.getRequiredQuantity());
        item.setProduct(product);
        item.setOrdered(order);
        order.getOrderedItems().add(item);
        order.setCardUsedForPayment(cardNo);
        order.setCustomer(customer);


        // update quantity of product
        int leftQuantity = product.getQuantity() - orderRequestDto.getRequiredQuantity();
        if(leftQuantity <= 0)
            product.setProductStatus(ProductStatus.OUT_OF_STOCK);
        product.setQuantity(leftQuantity);

        customer.getOrderList().add(order);
        Customer  savedCustomer = customerRepository.save(customer);
        Ordered savedOrder = savedCustomer.getOrderList().get(savedCustomer.getOrderList().size() - 1);

        OrderResponseDto orderResponseDto = OrderResponseDto.builder()
                .quantityOrdered(orderRequestDto.getRequiredQuantity())
                .productName(product.getProductName())
                .orderDate(savedOrder.getOrderDate())
                .cardUsedForPayment(cardNo)
                .itemPrice(product.getPrice())
                .totalCost(totalCost+deliveryCharge)
                .deliveryCharge(deliveryCharge)
                .build();

        return orderResponseDto;

    }
}
