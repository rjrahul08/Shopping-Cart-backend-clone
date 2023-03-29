package com.ShoppingMart.ShoppingMartBackendClone.Service.ServiceImpl;

import com.ShoppingMart.ShoppingMartBackendClone.Converter.SellerConverter;
import com.ShoppingMart.ShoppingMartBackendClone.Model.Seller;
import com.ShoppingMart.ShoppingMartBackendClone.Repository.SellerRepository;
import com.ShoppingMart.ShoppingMartBackendClone.RequestDto.SellerRequestDto;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.SellerReponseDto;
import com.ShoppingMart.ShoppingMartBackendClone.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    SellerRepository sellerRepository;

    @Override
    public void addSeller(SellerRequestDto sellerRequestDto) {
        Seller seller = SellerConverter.SellerRequestDtoToSeller(sellerRequestDto);
        sellerRepository.save(seller);
    }

    @Override
    public List<SellerReponseDto> findAll(){
        List<Seller> sellers = sellerRepository.findAll();
        List<SellerReponseDto> sellerReponseDtos =new ArrayList<>();
        for(Seller seller: sellers){
            SellerReponseDto sellerReponseDto = SellerConverter.sellerToSellerResponseDto(seller);
            sellerReponseDtos.add(sellerReponseDto);
        }
        return sellerReponseDtos;
    }
}
