package com.poc.DemoCart.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.DemoCart.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
