package com.poly.bangiaybe.repository;

import com.poly.bangiaybe.entity.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepo extends JpaRepository<Attribute, Long> {
	
	Attribute findByProduct_IdAndSize(Long productId, Integer size);

}
