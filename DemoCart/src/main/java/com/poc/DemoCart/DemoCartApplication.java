package com.poc.DemoCart;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.poc.DemoCart.service.ProductService;
import com.poc.DemoCart.service.UserService;




@SpringBootApplication
public class DemoCartApplication {

	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;
	public static void main(String[] args) {
		//SpringApplication.run(DemoCartApplication.class, args);
		
		DemoCartApplication app = SpringApplication.run(DemoCartApplication.class, args).getBean(DemoCartApplication.class);
		app.productService.saveInitialBatch();
		app.userService.saveInitialBatch();
	}

}
