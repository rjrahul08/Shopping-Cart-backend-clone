package com.ShoppingMart.ShoppingMartBackendClone.Controller;

import com.ShoppingMart.ShoppingMartBackendClone.Model.Item;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.ItemResponseDto;
import com.ShoppingMart.ShoppingMartBackendClone.Service.ItemService;
import org.aspectj.weaver.ResolvedPointcutDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("/view/{productId}")
    public ResponseEntity viewItem(@PathVariable int productId){
        ItemResponseDto itemResponseDto ;
        try {
            itemResponseDto = itemService.viewItem(productId);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(itemResponseDto,HttpStatus.CREATED);
    }
}
