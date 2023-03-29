package com.ShoppingMart.ShoppingMartBackendClone.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequestDto {
    private String name;

    private int age;

    private String email;

    private String mobNo;
}
