package com.poly.bangiaybe.service;

import com.poly.bangiaybe.dto.*;
import com.poly.bangiaybe.dto.Req.ReqCartItemDto;
import com.poly.bangiaybe.dto.Resp.RespCartItemDto;
import com.poly.bangiaybe.entity.*;

import java.util.Collection;
import java.util.List;

public interface CartItemService {
	

	
	List<CartItem> findAll();
	
	Boolean isEnoughStock(Long id, Integer quantity);
	
    CartItem saveCartItem(CartItem cartItem);
    


}
