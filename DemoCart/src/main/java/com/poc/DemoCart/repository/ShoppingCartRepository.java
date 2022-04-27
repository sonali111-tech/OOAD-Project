package com.poc.DemoCart.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.DemoCart.model.ShoppingCart;

import java.util.List;


public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    List<ShoppingCart> findByStatus(String status);
}
