package com.ShoppingMart.ShoppingMartBackendClone.RequestDto;

import com.ShoppingMart.ShoppingMartBackendClone.Enum.ProductCategory;
import com.ShoppingMart.ShoppingMartBackendClone.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {

    private String productName;

    private int price;

    private int quantity;

    private ProductCategory productCategory;

    private int sellerId;

}
