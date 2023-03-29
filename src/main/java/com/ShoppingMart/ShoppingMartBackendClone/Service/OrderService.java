package com.ShoppingMart.ShoppingMartBackendClone.Service;

import com.ShoppingMart.ShoppingMartBackendClone.RequestDto.OrderRequestDto;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.OrderResponseDto;

public interface OrderService {
    OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) throws Exception;
}
