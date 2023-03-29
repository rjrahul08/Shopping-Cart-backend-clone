package com.ShoppingMart.ShoppingMartBackendClone.ResponseDto;

import com.ShoppingMart.ShoppingMartBackendClone.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardDto {
    private String cardNo;
    private CardType cardType;
}
