package com.poly.bangiaybe.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.poly.bangiaybe.entity.Product;
import com.poly.bangiaybe.repository.ProductRepo;
import com.poly.bangiaybe.service.*;
import com.poly.bangiaybe.constant.ProductConst;
import com.poly.bangiaybe.dto.*;
import com.poly.bangiaybe.dto.Req.*;
import com.poly.bangiaybe.dto.Resp.RespProductDto;

import java.util.List;
import java.util.Optional;

@Service
public class ProductSeImpl implements ProductService{
	@Autowired
	ProductRepo productRepo;
	
	@Override
	public Product getProductById(Long id){
		Optional<Product> optionalProduct = productRepo.findById(id);
		if(!optionalProduct.isPresent()) {
			//////////////////
		}
		System.out.println("Id" + optionalProduct.get().id);
		return optionalProduct.get();
	}
	
	@Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }
	
	@Override
    public  Page<ResponseProductDto> getProducts(Boolean active, Pageable pageable) {
        return productRepo.getAllProducts(ProductConst.PRODUCT_AVG_SIZE, ProductConst.PRODUCT_MAIN_IMAGE, active, pageable);
    }
	
    @Override
    public Page<ResponseProductDto> filterAllProducts(List<Long> category, List<Long> brand, Double min, Double max, Pageable pageable) {
        return productRepo.filterAllProducts(ProductConst.PRODUCT_AVG_SIZE, ProductConst.PRODUCT_MAIN_IMAGE, Boolean.TRUE, category, brand, min, max, pageable);
    }
    
    @Override
    public Integer getToTalPage() {
        return productRepo.findAll(PageRequest.of(0, 9)).getTotalPages();
    }
    
    @Override
    public Page<ResponseProductDto> relateProduct(Long id, Long brand, Pageable pageable) {
        return productRepo.relateProduct(ProductConst.PRODUCT_AVG_SIZE, ProductConst.PRODUCT_MAIN_IMAGE, Boolean.TRUE, brand, id, pageable);
    }
    
    @Override
    public ResponseProductDto getProductDetail(Long id) {
        return productRepo.getProductDetail(ProductConst.PRODUCT_AVG_SIZE, ProductConst.PRODUCT_MAIN_IMAGE, id);
    }
    
    @Override
    public List<RespProductDto> searchByKeyword(String keyword, Pageable pageable) {
        return productRepo.searchAllByKeyword(ProductConst.PRODUCT_AVG_SIZE, ProductConst.PRODUCT_MAIN_IMAGE, keyword, pageable);
    }
	
}


