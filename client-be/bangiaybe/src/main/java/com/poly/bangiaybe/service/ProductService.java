package com.poly.bangiaybe.service;

import com.poly.bangiaybe.dto.ResponseProductDto;
import com.poly.bangiaybe.dto.Resp.RespProductDto;
import com.poly.bangiaybe.entity.Product;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {
	
	Page<ResponseProductDto> getProducts(Boolean active, Pageable pageable);
	
    Page<ResponseProductDto> filterAllProducts(List<Long> category, List<Long> brand, Double min, Double max, Pageable pageable);
	
	Integer getToTalPage();
	
	Product getProductById(Long id);
	
	List<Product> findAll();
	
	ResponseProductDto getProductDetail(Long id);
	
    Page<ResponseProductDto> relateProduct(Long id, Long brand, Pageable pageable);
    
    List<RespProductDto> searchByKeyword(String keyword, Pageable pageable);
}
