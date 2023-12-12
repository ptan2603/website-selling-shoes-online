package com.poly.bangiaybe.service;

import java.util.List;

import com.poly.bangiaybe.entity.Attribute;


public interface AttributeService {
	
	Attribute findById(Long id);
	
	Attribute save(Attribute attribute);

    Attribute getByProductIdAndSize(Long productId, Integer size);
	
    List<Attribute> cacheAttribute(Long id);
    
    List<Attribute> findAll();
    
    List<Attribute> backAttribute(Long id);

    Boolean isValidCart(Long id, Integer quantity);
}
