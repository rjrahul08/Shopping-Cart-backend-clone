package com.ShoppingMart.ShoppingMartBackendClone.Service.ServiceImpl;

import com.ShoppingMart.ShoppingMartBackendClone.Converter.ProductConverter;
import com.ShoppingMart.ShoppingMartBackendClone.Enum.ProductCategory;
import com.ShoppingMart.ShoppingMartBackendClone.Enum.ProductStatus;
import com.ShoppingMart.ShoppingMartBackendClone.Exception.SellerNotFoundException;
import com.ShoppingMart.ShoppingMartBackendClone.Model.Product;
import com.ShoppingMart.ShoppingMartBackendClone.Model.Seller;
import com.ShoppingMart.ShoppingMartBackendClone.Repository.ProductRepository;
import com.ShoppingMart.ShoppingMartBackendClone.Repository.SellerRepository;
import com.ShoppingMart.ShoppingMartBackendClone.RequestDto.ProductRequestDto;
import com.ShoppingMart.ShoppingMartBackendClone.ResponseDto.ProductResponseDto;
import com.ShoppingMart.ShoppingMartBackendClone.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SellerRepository sellerRepository;

    @Override
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException {
        Seller seller ;
        try {
            seller = sellerRepository.findById(productRequestDto.getSellerId()).get();
        }
        catch (Exception e){
            throw new SellerNotFoundException(" not found !!!");
        }
        Product product = ProductConverter.productRequestDtoToProduct(productRequestDto);
        product.setSeller(seller);

        seller.getProducts().add(product);

        sellerRepository.save(seller);

        ProductResponseDto productResponseDto = ProductConverter.productToProductResponseDto(product);
        return productResponseDto;
    }

    @Override
    public List<ProductResponseDto> getAllProductByCategory(ProductCategory productCategory){
        List<Product> products = productRepository.findAllByProductCategory(productCategory);

        List<ProductResponseDto> productResponseDtos = new ArrayList<>();

        for (Product product : products){
            ProductResponseDto productResponseDto = ProductConverter.productToProductResponseDto(product);
            productResponseDtos.add(productResponseDto);
        }
        return productResponseDtos;
    }

    @Override
    public List<ProductResponseDto> getAllProductByStatus(ProductStatus productStatus){
        List<Product> products = productRepository.findAllByProductStatus(productStatus);
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();

        for (Product product : products){
            ProductResponseDto productResponseDto = ProductConverter.productToProductResponseDto(product);
            productResponseDtos.add(productResponseDto);
        }
        return productResponseDtos;
    }


    @Override
    public ProductResponseDto updateProductCategory(ProductRequestDto productRequestDto){
        Product product = ProductConverter.productRequestDtoToProduct(productRequestDto);
        product.setProductCategory(productRequestDto.getProductCategory());
        productRepository.save(product);
        ProductResponseDto productResponseDto = ProductConverter.productToProductResponseDto(product);
        return productResponseDto;
    }
}
