package com.poc.DemoCart.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poc.DemoCart.dao.ShoppingCartDTO;
import com.poc.DemoCart.model.Product;
import com.poc.DemoCart.model.ShoppingCart;
import com.poc.DemoCart.repository.ProductRepository;
import com.poc.DemoCart.repository.ShoppingCartRepository;
import com.poc.DemoCart.repository.UserRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by sahan on 4/9/2016.
 */
@Service
@Transactional
public class ShoppingCartService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCart saveProducts(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = new ShoppingCart();
        
        Product product = productRepository.findById(shoppingCartDTO.getProductId()).get();
        shoppingCart.setProduct(product);
        
        
        //shoppingCart.setUser(userRepository.findById(1L).get());
        
        shoppingCart.setStatus(shoppingCartDTO.getStatus());
        shoppingCart.setDate(new Date());
        shoppingCart.setStock(shoppingCartDTO.getStock());
        shoppingCart.setAmount(product.getUnitPrice() * shoppingCartDTO.getStock());

        return shoppingCartRepository.save(shoppingCart);
    }


    public List<ShoppingCart> findAll() {
//        return shoppingCartRepository.findAll();
        return shoppingCartRepository.findByStatus("NOT_PURCHASED");
    }

    public ShoppingCart updateProduct(ShoppingCartDTO shoppingCartDTO, Long id) {
        ShoppingCart updateItem = shoppingCartRepository.findById(id).get();
        updateItem.setStock(shoppingCartDTO.getStock());
        updateItem.setAmount(updateItem.getProduct().getUnitPrice() * shoppingCartDTO.getStock());
        return shoppingCartRepository.save(updateItem);
    }

    public void deleteProduct(Long id) {
        shoppingCartRepository.deleteById(id);
    }

    public void clearShoppingCart(Object object) {
    	
        //shoppingCartRepository.delete(findAll());
        shoppingCartRepository.deleteAll();
    }


    public List<ShoppingCart> findByPurchased() {
        return shoppingCartRepository.findByStatus("PURCHASED");
    }


    public void purchaseProducts(Long id) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(id).get();
        shoppingCart.setStatus("PURCHASED");
        shoppingCartRepository.save(shoppingCart);
    }
}
