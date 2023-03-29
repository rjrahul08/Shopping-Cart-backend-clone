package com.ShoppingMart.ShoppingMartBackendClone.Converter;

import com.ShoppingMart.ShoppingMartBackendClone.Model.Item;
import com.ShoppingMart.ShoppingMartBackendClone.Model.Product;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.ItemResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ItemConverter {
    public static Item productToItem(Product product){
        return Item.builder()
                .requiredQuantity(0)
                .product(product)
                .build();
    }
    public static ItemResponseDto productToItemResponseDto(Product product){
        return ItemResponseDto.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .productCategory(product.getProductCategory())
                .productStatus(product.getProductStatus())
                .build();
    }
}
