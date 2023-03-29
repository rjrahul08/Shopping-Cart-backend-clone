package com.ShoppingMart.ShoppingMartBackendClone.Repository;

import com.ShoppingMart.ShoppingMartBackendClone.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByEmail(String email);
}
