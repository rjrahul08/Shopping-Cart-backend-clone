package com.ShoppingMart.ShoppingMartBackendClone.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequestDto {

    private int productId;

    private int customerId;

    private int requiredQuantity;
}
