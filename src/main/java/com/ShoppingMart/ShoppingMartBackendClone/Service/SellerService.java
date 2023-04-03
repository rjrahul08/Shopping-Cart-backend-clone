package com.ShoppingMart.ShoppingMartBackendClone.Service;

import com.ShoppingMart.ShoppingMartBackendClone.Exception.SellerNotFoundException;
import com.ShoppingMart.ShoppingMartBackendClone.RequestDto.SellerRequestDto;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.ProductResponseDto;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.SellerReponseDto;

import java.util.List;

public interface SellerService {

     String addSeller(SellerRequestDto sellerRequestDto) throws Exception;

    List<SellerReponseDto> findAll();

    SellerReponseDto getSellerById(int id) throws SellerNotFoundException;

    List<ProductResponseDto> findProductListBySeller(int id) throws SellerNotFoundException;
}
