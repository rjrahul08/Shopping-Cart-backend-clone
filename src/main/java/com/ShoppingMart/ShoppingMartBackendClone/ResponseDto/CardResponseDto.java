package com.ShoppingMart.ShoppingMartBackendClone.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardResponseDto {

    private String name;

    List<CardDto> cardDtos;
}
