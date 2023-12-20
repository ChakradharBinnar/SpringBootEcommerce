package com.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.entity.ProductModel;

@Repository
public interface ProductRepo extends JpaRepository<ProductModel, Integer> {

	@Query("select u FROM ProductModel u where productId=1")
	public List<ProductModel> getUserByIdK();
	
	@Query("select u FROM ProductModel u where productId=2")
	public List<ProductModel> getUserByIdM();
	
	@Query("select u FROM ProductModel u where productId=3")
	public List<ProductModel> getUserByIdF();
	
	@Query("select u FROM ProductModel u where productId=4")
	public List<ProductModel> getUserByIdG();
	
	@Query("select u FROM ProductModel u where productId=5")
	public List<ProductModel> getUserByIdH();
	
}
