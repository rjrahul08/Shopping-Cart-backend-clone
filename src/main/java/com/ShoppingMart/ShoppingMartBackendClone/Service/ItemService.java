package com.ShoppingMart.ShoppingMartBackendClone.Service;

import com.ShoppingMart.ShoppingMartBackendClone.Exception.ProductNotFoundException;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.ItemResponseDto;

public interface ItemService {
    ItemResponseDto viewItem(int productId) throws ProductNotFoundException;
}
