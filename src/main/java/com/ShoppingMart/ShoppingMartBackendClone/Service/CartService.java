package com.ShoppingMart.ShoppingMartBackendClone.Service;

import com.ShoppingMart.ShoppingMartBackendClone.Exception.CustomerNotFoundException;
import com.ShoppingMart.ShoppingMartBackendClone.Exception.ProductNotFoundException;
import com.ShoppingMart.ShoppingMartBackendClone.RequestDto.OrderRequestDto;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.OrderResponseDto;

import java.util.List;

public interface CartService {
    String addToCart(OrderRequestDto orderRequestDto) throws Exception;

    List<OrderResponseDto> checkoutCart(int customerId) throws CustomerNotFoundException;
}
