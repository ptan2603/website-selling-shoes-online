package com.poly.bangiaybe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.bangiaybe.service.CartItemService;
import com.poly.bangiaybe.util.ConvertUtil;
import com.poly.bangiaybe.constant.AttributeConst;
import com.poly.bangiaybe.constant.CartItemConst;
import com.poly.bangiaybe.constant.Const;
import com.poly.bangiaybe.dto.Req.ReqCartItemDto;
import com.poly.bangiaybe.dto.Resp.RespCartItemDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class CartItemControl {
    @Autowired
    CartItemService cartItemService;
    


	@GetMapping(CartItemConst.API_CART_ITEM_IS_ENOUGH)
    public ResponseEntity<?> isEnoughStockCartItem(@RequestParam("id")Long id, @RequestParam("quantity") Integer quantity){
        return new ResponseEntity<>(cartItemService.isEnoughStock(id, quantity), HttpStatus.OK);
    }
	
}
