package com.ShoppingMart.ShoppingMartBackendClone.Model;


import com.ShoppingMart.ShoppingMartBackendClone.Enum.ProductCategory;
import com.ShoppingMart.ShoppingMartBackendClone.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String productName;

    private int price;

    private int quantity;

    @Enumerated(EnumType.STRING)
    ProductStatus productStatus;

    @Enumerated(EnumType.STRING)
    ProductCategory productCategory;


    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
    Item item;

    @ManyToOne
    @JoinColumn
    Seller seller;

}
