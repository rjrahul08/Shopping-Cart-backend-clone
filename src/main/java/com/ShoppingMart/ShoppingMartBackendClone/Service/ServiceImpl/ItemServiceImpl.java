package com.ShoppingMart.ShoppingMartBackendClone.Service.ServiceImpl;

import com.ShoppingMart.ShoppingMartBackendClone.Controller.ItemController;
import com.ShoppingMart.ShoppingMartBackendClone.Converter.ItemConverter;
import com.ShoppingMart.ShoppingMartBackendClone.Exception.ProductNotFoundException;
import com.ShoppingMart.ShoppingMartBackendClone.Model.Item;
import com.ShoppingMart.ShoppingMartBackendClone.Model.Product;
import com.ShoppingMart.ShoppingMartBackendClone.Repository.ProductRepository;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.ItemResponseDto;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.ProductResponseDto;
import com.ShoppingMart.ShoppingMartBackendClone.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ProductRepository productRepository;
    public ItemResponseDto viewItem(int productId) throws ProductNotFoundException {
        Product product;
        try {
            product = productRepository.findById(productId).get();
        }
        catch (Exception e){
            throw new ProductNotFoundException("Sorry !  Invalid product Id");
        }
        Item item = ItemConverter.productToItem(product);
        // Map item to product
        product.setItem(item);

        productRepository.save(product);
        ItemResponseDto itemResponseDto = ItemConverter.productToItemResponseDto(product);

        return itemResponseDto;
    }
}
