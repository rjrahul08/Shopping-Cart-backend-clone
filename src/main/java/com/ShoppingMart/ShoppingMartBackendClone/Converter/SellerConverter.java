package com.ShoppingMart.ShoppingMartBackendClone.Converter;

import com.ShoppingMart.ShoppingMartBackendClone.Model.Seller;
import com.ShoppingMart.ShoppingMartBackendClone.RequestDto.SellerRequestDto;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.SellerReponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SellerConverter {
    public static Seller SellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){
        return Seller.builder()
                .name(sellerRequestDto.getName())
                .email(sellerRequestDto.getEmail())
                .mobNo(sellerRequestDto.getMobNo())
                .panNo(sellerRequestDto.getPanNo())
                .build();
    }
    public static SellerReponseDto sellerToSellerResponseDto(Seller seller){
        return SellerReponseDto.builder()
                .name(seller.getName())
                .email(seller.getEmail())
                .mobNo(seller.getMobNo())
                .panNo(seller.getPanNo())
                .build();
    }
}
