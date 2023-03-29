package com.ShoppingMart.ShoppingMartBackendClone.Repository;

import com.ShoppingMart.ShoppingMartBackendClone.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
