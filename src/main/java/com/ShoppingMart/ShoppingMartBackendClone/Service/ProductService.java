package com.ShoppingMart.ShoppingMartBackendClone.Service;

import com.ShoppingMart.ShoppingMartBackendClone.Enum.ProductCategory;
import com.ShoppingMart.ShoppingMartBackendClone.Enum.ProductStatus;
import com.ShoppingMart.ShoppingMartBackendClone.Exception.SellerNotFoundException;
import com.ShoppingMart.ShoppingMartBackendClone.RequestDto.ProductRequestDto;
import com.ShoppingMart.ShoppingMartBackendClone.RequestDto.ProductSellerRequestDto;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.ProductResponseDto;

import java.util.List;

public interface ProductService {
    ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException;

     List<ProductResponseDto> getAllProductByCategory(ProductCategory productCategory);

    List<ProductResponseDto> getAllProductByStatus(ProductStatus productStatus);

    ProductResponseDto updateProductCategory(ProductRequestDto productRequestDto);
}
