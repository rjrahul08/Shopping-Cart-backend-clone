package com.ShoppingMart.ShoppingMartBackendClone.Repository;

import com.ShoppingMart.ShoppingMartBackendClone.Enum.ProductCategory;
import com.ShoppingMart.ShoppingMartBackendClone.Enum.ProductStatus;
import com.ShoppingMart.ShoppingMartBackendClone.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAllByProductCategory(ProductCategory productCategory);

    List<Product> findAllByProductStatus(ProductStatus productStatus);
}
