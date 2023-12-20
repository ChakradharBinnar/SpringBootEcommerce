package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.AddToCartModel;


@Repository
public interface AddToCartRepo extends JpaRepository<AddToCartModel, Integer> {

}
