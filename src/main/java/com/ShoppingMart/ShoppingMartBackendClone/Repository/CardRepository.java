package com.ShoppingMart.ShoppingMartBackendClone.Repository;

import com.ShoppingMart.ShoppingMartBackendClone.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {
}
