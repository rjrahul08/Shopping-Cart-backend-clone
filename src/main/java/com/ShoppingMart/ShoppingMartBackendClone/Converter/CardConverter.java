package com.ShoppingMart.ShoppingMartBackendClone.Converter;

import com.ShoppingMart.ShoppingMartBackendClone.Model.Card;
import com.ShoppingMart.ShoppingMartBackendClone.RequestDto.CardRequestDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CardConverter {
    public static Card cardRequestDtoToCard(CardRequestDto cardRequestDto){
        return Card.builder()
                .cardNo(cardRequestDto.getCardNo())
                .cardType(cardRequestDto.getCardType())
                .cvv(cardRequestDto.getCvv())
                .build();
    }
}
