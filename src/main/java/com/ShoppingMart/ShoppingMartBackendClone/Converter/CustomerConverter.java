package com.ShoppingMart.ShoppingMartBackendClone.Converter;

import com.ShoppingMart.ShoppingMartBackendClone.Model.Customer;
import com.ShoppingMart.ShoppingMartBackendClone.RequestDto.CustomerRequestDto;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.CustomerResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerConverter {
    public static Customer customerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){
        return Customer.builder()
                .name(customerRequestDto.getName())
                .age(customerRequestDto.getAge())
                .mobNo(customerRequestDto.getMobNo())
                .email(customerRequestDto.getEmail())
                .build();
    }
    public static CustomerResponseDto customerToCustomerResponseDto(Customer customer){
        return CustomerResponseDto.builder()
                .email(customer.getEmail())
                .name(customer.getName())
                .mobNo(customer.getMobNo())
                .build();
    }
}
