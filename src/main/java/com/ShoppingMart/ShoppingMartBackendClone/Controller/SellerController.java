package com.ShoppingMart.ShoppingMartBackendClone.Controller;

import com.ShoppingMart.ShoppingMartBackendClone.Model.Seller;
import com.ShoppingMart.ShoppingMartBackendClone.RequestDto.SellerRequestDto;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.ProductResponseDto;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.SellerReponseDto;
import com.ShoppingMart.ShoppingMartBackendClone.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    SellerService sellerService;

    @PostMapping("/add")
    public ResponseEntity addSeller(@RequestBody SellerRequestDto sellerRequestDto){
        String response = "";
        try{
            response = sellerService.addSeller(sellerRequestDto);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(response,HttpStatus.ACCEPTED);
    }

    @GetMapping("/get_sellers")
    public List<SellerReponseDto> findAll() {
        List<SellerReponseDto> sellerReponseDtoList = new ArrayList<>();
        return sellerService.findAll();
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity getSellerById(@PathVariable("id") int id){
        SellerReponseDto sellerReponseDto ;
        try {
            sellerReponseDto = sellerService.getSellerById(id);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(sellerReponseDto,HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/productlist/{id}")
    public ResponseEntity findProductListBySeller(@PathVariable("id") int id){
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        try {
            productResponseDtos = sellerService.findProductListBySeller(id);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(productResponseDtos,HttpStatus.ACCEPTED);
    }
}
