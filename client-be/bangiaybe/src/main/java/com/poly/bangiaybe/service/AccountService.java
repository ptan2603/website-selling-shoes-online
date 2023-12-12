package com.poly.bangiaybe.service;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.poly.bangiaybe.dto.AccountDto;
import com.poly.bangiaybe.dto.Req.ReqCreateAccountDto;
import com.poly.bangiaybe.dto.Req.ReqRegisterAccountDto;
import com.poly.bangiaybe.dto.Resp.RespAccountDto;
import com.poly.bangiaybe.entity.Account;

import javax.transaction.Transactional;
import java.util.List;

public interface AccountService {
	
	  Account findById(Long id);
	  
	  Account findAccountByUsername(String username);
	  
	  Boolean checkAccountByUsername(String username);
	  
	  List<RespAccountDto> findAllSecond(Pageable pageable);
	  
	  RespAccountDto findByIdSecond(Long id);
	  
	  RespAccountDto findByUsername(String username);
	  
	  RespAccountDto register(ReqRegisterAccountDto reqRegisterAccountDto);
	  
	  Integer getToTalPage();

	  void deleteOrRestore(Boolean isActive, Long id);

	  Account save(ReqCreateAccountDto reqCreateAccountDto);

	  void save(AccountDto accountDto);
}
