package com.ShoppingMart.ShoppingMartBackendClone.RequestDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSellerRequestDto {
    private int sellerId;
    private int productId;
}
