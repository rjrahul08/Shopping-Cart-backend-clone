package com.ShoppingMart.ShoppingMartBackendClone.Service.ServiceImpl;

import com.ShoppingMart.ShoppingMartBackendClone.Converter.CustomerConverter;
import com.ShoppingMart.ShoppingMartBackendClone.Model.Cart;
import com.ShoppingMart.ShoppingMartBackendClone.Model.Customer;
import com.ShoppingMart.ShoppingMartBackendClone.Repository.CustomerRepository;
import com.ShoppingMart.ShoppingMartBackendClone.RequestDto.CustomerRequestDto;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.CustomerResponseDto;
import com.ShoppingMart.ShoppingMartBackendClone.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto){
        Customer customer = CustomerConverter.customerRequestDtoToCustomer(customerRequestDto);
        // allocate a cart to customer
        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);

        // set cart in customer
        customer.setCart(cart);

        customerRepository.save(customer);

        CustomerResponseDto customerResponseDto = CustomerConverter.customerToCustomerResponseDto(customer);
        return customerResponseDto;

    }

    @Override
    public CustomerResponseDto getCustomerById(int id){
        Customer customer = customerRepository.findById(id).get();
        CustomerResponseDto customerResponseDto = CustomerConverter.customerToCustomerResponseDto(customer);
        return customerResponseDto;
    }

    @Override
    public CustomerResponseDto findByEmail(String email){
        Customer customer = customerRepository.findByEmail(email);
        CustomerResponseDto customerResponseDto = CustomerConverter.customerToCustomerResponseDto(customer);
        return customerResponseDto;
    }

    public CustomerResponseDto findByMobNo(String mobNo){
        Customer customer = customerRepository.findByMobNo(mobNo);
        CustomerResponseDto customerResponseDto = CustomerConverter.customerToCustomerResponseDto(customer);
        return customerResponseDto;
    }
}
