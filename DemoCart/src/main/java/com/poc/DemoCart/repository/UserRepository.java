package com.poc.DemoCart.repository;


import org.springframework.data.repository.CrudRepository;

import com.poc.DemoCart.model.User;


public interface UserRepository extends CrudRepository<User, Long> {
}
