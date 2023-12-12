package com.poly.bangiaybe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.bangiaybe.service.AccountDetailService;
import com.poly.bangiaybe.constant.AccountConst;
import com.poly.bangiaybe.dto.Req.ReqUpdateAccountDetailDto;

@RestController
@CrossOrigin("*")
public class AccountDetailControl {
	 @Autowired
	 	AccountDetailService accountDetailService;
	 
	 @GetMapping(AccountConst.API_ACCOUNT_DETAIL_GET_BY_ACCOUNT_ID)
	    public ResponseEntity<?> getAccountDetailByAccountId(@RequestParam("id") Long id){
	        return new ResponseEntity<>(accountDetailService.findAccountDetail(id), HttpStatus.OK);
	    }
	 
}
