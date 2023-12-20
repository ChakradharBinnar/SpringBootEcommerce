package com.demo.contro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.entity.AddToCartModel;
import com.demo.entity.ProductModel;
import com.demo.repo.AddToCartRepo;
import com.demo.repo.ProductRepo;


public class AddToCartController {
	
	@Autowired
	private AddToCartRepo repo;
	
	@Autowired
	private ProductRepo pRepo;
	
	@GetMapping("/getAddToCart")
	public String dltMapping(@PathVariable int id) {
		repo.findById(id);
		return "home";
	}
	
	@PostMapping("/addToCart")
	public String addToCart(AddToCartModel m) {
		
		repo.save(m);
		return "redirect:/getAddToCart";
	}

}
