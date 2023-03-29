package com.ShoppingMart.ShoppingMartBackendClone.Repository;

import com.ShoppingMart.ShoppingMartBackendClone.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}
