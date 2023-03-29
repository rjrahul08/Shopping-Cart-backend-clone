package com.ShoppingMart.ShoppingMartBackendClone.Controller;

import com.ShoppingMart.ShoppingMartBackendClone.Enum.ProductCategory;
import com.ShoppingMart.ShoppingMartBackendClone.Enum.ProductStatus;
import com.ShoppingMart.ShoppingMartBackendClone.RequestDto.ProductRequestDto;
import com.ShoppingMart.ShoppingMartBackendClone.RequestDto.ProductSellerRequestDto;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.ProductResponseDto;
import com.ShoppingMart.ShoppingMartBackendClone.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductRequestDto productRequestDto)throws Exception{
        ProductResponseDto productResponseDto;
        try{
            productResponseDto = productService.addProduct(productRequestDto);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(productResponseDto,HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/productCategory/{productCategory}")
    public List<ProductResponseDto> getAllProductByCategory(@PathVariable("productCategory")ProductCategory productCategory){
        List<ProductResponseDto> productResponseDtos =  productService.getAllProductByCategory(productCategory);
        return productResponseDtos;
    }
    @GetMapping("/get/productStatus/{productStatus}")
    public List<ProductResponseDto> getAllProductByStatus(@PathVariable("productStatus") ProductStatus productStatus){
        List<ProductResponseDto> productResponseDtos = productResponseDtos = productService.getAllProductByStatus(productStatus);
        return productResponseDtos;
    }
}
