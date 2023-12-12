package com.poly.bangiaybe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.poly.bangiaybe.service.AttributeService;
import com.poly.bangiaybe.constant.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class AttributeControl {

	 @Autowired
	 AttributeService attributeService;
	 

	 
	 @GetMapping(AttributeConst.API_ATTRIBUTE_GET_BY_ID)
	    public ResponseEntity<?> getAttributeById(@PathVariable("id") Long id) {
	        return new ResponseEntity<>(attributeService.findById(id), HttpStatus.OK);
	    }
	 
	 @GetMapping(AttributeConst.API_ATTRIBUTE_GET_ALL)
	    public ResponseEntity<?> getAll() {
	        return new ResponseEntity<>(attributeService.findAll(), HttpStatus.OK);
	    }
	 
	 @GetMapping(AttributeConst.API_ATTRIBUTE_IS_VALID)
	    public ResponseEntity<?> isValid(@RequestParam("id") Long id, @RequestParam("quantity") Integer quantity) {
	        return new ResponseEntity<>(attributeService.isValidCart(id, quantity), HttpStatus.OK);
	    }
}
