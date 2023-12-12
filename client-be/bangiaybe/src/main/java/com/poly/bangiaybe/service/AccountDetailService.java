package com.poly.bangiaybe.service;

import com.poly.bangiaybe.dto.Req.ReqUpdateAccountDetailDto;
import com.poly.bangiaybe.entity.*;

public interface AccountDetailService {
	
	AccountDetail findAccountDetail(Long id);
	
    AccountDetail findAccountDetailByEmail(String email);
    
    AccountDetail save(AccountDetail accountDetail);	

}
