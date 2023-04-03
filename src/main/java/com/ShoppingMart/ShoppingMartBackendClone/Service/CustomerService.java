package com.ShoppingMart.ShoppingMartBackendClone.Service;

import com.ShoppingMart.ShoppingMartBackendClone.RequestDto.CustomerRequestDto;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.CustomerResponseDto;

public interface CustomerService {
    CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto);

    CustomerResponseDto getCustomerById(int id);

    CustomerResponseDto findByEmail(String email);

    CustomerResponseDto findByMobNo(String mobNo);
}
