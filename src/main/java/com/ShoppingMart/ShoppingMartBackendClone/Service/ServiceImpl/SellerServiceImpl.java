package com.ShoppingMart.ShoppingMartBackendClone.Service.ServiceImpl;

import com.ShoppingMart.ShoppingMartBackendClone.Converter.ProductConverter;
import com.ShoppingMart.ShoppingMartBackendClone.Converter.SellerConverter;
import com.ShoppingMart.ShoppingMartBackendClone.Exception.SellerNotFoundException;
import com.ShoppingMart.ShoppingMartBackendClone.Model.Product;
import com.ShoppingMart.ShoppingMartBackendClone.Model.Seller;
import com.ShoppingMart.ShoppingMartBackendClone.Repository.SellerRepository;
import com.ShoppingMart.ShoppingMartBackendClone.RequestDto.SellerRequestDto;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.ProductResponseDto;
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
    public String addSeller(SellerRequestDto sellerRequestDto) throws Exception {
        Seller seller ;
        try {
            seller = SellerConverter.SellerRequestDtoToSeller(sellerRequestDto);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
        sellerRepository.save(seller);
        return "Congrats !! Now you can sell";
    }

    @Override
    public SellerReponseDto getSellerById(int id) throws SellerNotFoundException {
        Seller seller ;
        try {
            seller = sellerRepository.findById(id).get();
        }
        catch (Exception e){
            throw new SellerNotFoundException("Invalid seller id");
        }
        SellerReponseDto sellerReponseDto = SellerConverter.sellerToSellerResponseDto(seller);
        return  sellerReponseDto;
    }

    @Override
    public List<ProductResponseDto> findProductListBySeller(int id) throws SellerNotFoundException {
        Seller seller ;
        try {
            seller = sellerRepository.findById(id).get();
        }
        catch (Exception e){
            throw new SellerNotFoundException("Invalid seller id");
        }
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        List<Product> products = seller.getProducts();
        for(Product product : products){
            ProductResponseDto productResponseDto = ProductConverter.productToProductResponseDto(product);
            productResponseDtos.add(productResponseDto);
        }
        return productResponseDtos;
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
