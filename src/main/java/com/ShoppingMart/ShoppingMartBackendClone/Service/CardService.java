package com.ShoppingMart.ShoppingMartBackendClone.Service;

import com.ShoppingMart.ShoppingMartBackendClone.Exception.CustomerNotFoundException;
import com.ShoppingMart.ShoppingMartBackendClone.RequestDto.CardRequestDto;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.CardResponseDto;

public interface CardService {
    CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException;
}
