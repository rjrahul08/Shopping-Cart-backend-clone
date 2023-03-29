package com.ShoppingMart.ShoppingMartBackendClone.Controller;

import com.ShoppingMart.ShoppingMartBackendClone.Model.Seller;
import com.ShoppingMart.ShoppingMartBackendClone.RequestDto.SellerRequestDto;
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
        try{
            sellerService.addSeller(sellerRequestDto);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage()+"User not added" , HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity("Congrats !! Now you can sell",HttpStatus.ACCEPTED);
    }

    @GetMapping("/get_sellers")
    public List<SellerReponseDto> findAll() {
        List<SellerReponseDto> sellerReponseDtoList = new ArrayList<>();
        return sellerService.findAll();
    }
}
