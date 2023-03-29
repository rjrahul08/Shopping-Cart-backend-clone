package com.ShoppingMart.ShoppingMartBackendClone.Service;

import com.ShoppingMart.ShoppingMartBackendClone.RequestDto.SellerRequestDto;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.SellerReponseDto;

import java.util.List;

public interface SellerService {

     void addSeller(SellerRequestDto sellerRequestDto);

    List<SellerReponseDto> findAll();
}
