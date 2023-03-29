package com.ShoppingMart.ShoppingMartBackendClone.Service.ServiceImpl;

import com.ShoppingMart.ShoppingMartBackendClone.Converter.CardConverter;
import com.ShoppingMart.ShoppingMartBackendClone.Exception.CustomerNotFoundException;
import com.ShoppingMart.ShoppingMartBackendClone.Model.Card;
import com.ShoppingMart.ShoppingMartBackendClone.Model.Customer;
import com.ShoppingMart.ShoppingMartBackendClone.Repository.CardRepository;
import com.ShoppingMart.ShoppingMartBackendClone.Repository.CustomerRepository;
import com.ShoppingMart.ShoppingMartBackendClone.RequestDto.CardRequestDto;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.CardDto;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.CardResponseDto;
import com.ShoppingMart.ShoppingMartBackendClone.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CustomerRepository customerRepository1;

    @Autowired
    CardRepository cardRepository;


    @Override
    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException {
        Customer customer;
        try {
            customer = customerRepository1.findById(cardRequestDto.getCustomerId()).get();
        }
        catch (Exception e){
            throw new CustomerNotFoundException("Customer Not Found!!");
        }
        Card card = CardConverter.cardRequestDtoToCard(cardRequestDto);
        card.setCustomer(customer);
        customer.getCards().add(card);

        customerRepository1.save(customer);

        // prepare Response Dto
        CardResponseDto cardResponseDto = new CardResponseDto();
        cardResponseDto.setName(customer.getName());

        // convert every card to cardDto
        List<CardDto> cardDtoList = new ArrayList<>();
        for(Card card1: customer.getCards()){
            CardDto cardDto = new CardDto();
            cardDto.setCardNo(card1.getCardNo());
            cardDto.setCardType(card1.getCardType());

            cardDtoList.add(cardDto);
        }

        cardResponseDto.setCardDtos(cardDtoList);
        return cardResponseDto;
    }


}
