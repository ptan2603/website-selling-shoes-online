package com.poly.bangiaybe.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//danh sách mã trạng thái HTTP thông thường, như 200 OK, 404 Not Found,....
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;

import com.poly.bangiaybe.constant.ProductConst;
import com.poly.bangiaybe.dto.*;
import com.poly.bangiaybe.dto.Req.*;
import com.poly.bangiaybe.service.ProductService;
import com.poly.bangiaybe.util.ConvertUtil;

@CrossOrigin("*")
@RestController
public class ProductControl {
//cho phép Spring tự động chèn một đối tượng của ProductService  vào trường này.
	@Autowired
    ProductService productService ;
	
	 @GetMapping(ProductConst.API_PRODUCT_GET_BY_ID)
	    public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {
	        return new ResponseEntity<>(ConvertUtil.fromProductDetail(productService.getProductById(id)), HttpStatus.OK);
	    }

	@GetMapping(ProductConst.API_PRODUCT_GET_ALL)
  public ResponseEntity<?> getAllProductPagination(@RequestParam("page") Optional<Integer> page,
		  										   @RequestParam("size") Optional<Integer> size,
		  										   @RequestParam("active") Optional<Boolean> active){
		Sort sort = Sort.by(Sort.Direction.DESC, "modifyDate");
      Pageable pageable = PageRequest.of(page.orElse(1) - 1, size.orElse(8), sort);
      return new ResponseEntity<>(productService.getProducts(active.orElse(true), pageable), HttpStatus.OK);
  }
	
	@PostMapping(ProductConst.API_PRODUCT_FILTER)
    public ResponseEntity<?> filterProducts(@RequestBody ReqFilterProduct reqFilterProduct) {
        Sort sort = Sort.by(Sort.Direction.DESC, "modifyDate");
        Pageable pageable = PageRequest.of(reqFilterProduct.getPage() - 1, reqFilterProduct.getCount(), sort);
        return new ResponseEntity<>(productService.filterAllProducts(reqFilterProduct.getCategory(), reqFilterProduct.getBrand(), reqFilterProduct.getMin(), reqFilterProduct.getMax(), pageable), HttpStatus.OK);
    }

    @GetMapping(ProductConst.API_PRODUCT_TOTAL_PAGE)
    public ResponseEntity<?> getTotalPage() {
        return new ResponseEntity<>(productService.getToTalPage(), HttpStatus.OK);
    }
    
    @GetMapping(ProductConst.API_PRODUCT_RELATE)
    public ResponseEntity<?> relateProduct(@RequestParam("relate") Long brand, @RequestParam("id") Long id) {
        Pageable pageable = PageRequest.of(0, 3);
        return new ResponseEntity<>(productService.relateProduct(id, brand, pageable), HttpStatus.OK);
    }
    
    @GetMapping(ProductConst.API_PRODUCT_FIND_ALL)
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
    
    @GetMapping(ProductConst.API_PRODUCT_SEARCH)
    public ResponseEntity<?> searchByKeyword(@RequestParam("page") Optional<Integer> page,
                                             @RequestParam("size") Optional<Integer> size,
                                             @RequestParam("keyword") String keyword) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page.orElse(1) - 1, size.orElse(9), sort);
        return new ResponseEntity(productService.searchByKeyword("%" + keyword + "%", pageable), HttpStatus.OK);
    }
}
