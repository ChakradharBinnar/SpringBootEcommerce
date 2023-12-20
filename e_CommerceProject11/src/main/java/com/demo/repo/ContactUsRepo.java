package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.ContactUsModel;

@Repository
public interface ContactUsRepo extends JpaRepository<ContactUsModel, Integer> {

}
