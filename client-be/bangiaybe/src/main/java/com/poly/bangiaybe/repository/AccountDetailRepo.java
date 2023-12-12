package com.poly.bangiaybe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.poly.bangiaybe.entity.AccountDetail;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;

public interface AccountDetailRepo extends JpaRepository<AccountDetail, Long> {
	//dùng để tìm AccountDetail dựa trên id của Account.
    AccountDetail findAccountDetailByAccount_Id(Long id);
    
    AccountDetail findAccountDetailByEmail(String email);
}
