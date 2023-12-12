package com.poly.bangiaybe.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.poly.bangiaybe.constant.AccountConst;
import com.poly.bangiaybe.dto.AccountDto;
import com.poly.bangiaybe.dto.Req.ReqCreateAccountDto;
import com.poly.bangiaybe.dto.Req.ReqRegisterAccountDto;
import com.poly.bangiaybe.dto.Resp.RespAccountDto;
import com.poly.bangiaybe.entity.Account;
import com.poly.bangiaybe.entity.AccountDetail;
import com.poly.bangiaybe.entity.Role;
import com.poly.bangiaybe.exception.AppException;
import com.poly.bangiaybe.repository.AccountRepo;
import com.poly.bangiaybe.service.AccountDetailService;
import com.poly.bangiaybe.service.AccountService;
import com.poly.bangiaybe.service.RoleService;
import com.poly.bangiaybe.util.ConvertUtil;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Configuration
@Service
public class AccountSeImpl implements AccountService {
    @Autowired
    AccountRepo accountRepo;
    
    @Autowired
    AccountDetailService accountDetailService;
    
    @Autowired
    RoleService roleService;
   
   
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    public Account findById(Long id) {
        Optional<Account> optionalAccount = accountRepo.findById(id);
        if(!optionalAccount.isPresent()){
            throw new AppException(AccountConst.ACCOUNT_MSG_ERROR_NOT_EXIST);
        }
        return optionalAccount.get();
    }
    
	@Override
    public List<RespAccountDto> findAllSecond(Pageable pageable) {
        return this.accountRepo.findAllSecond(pageable);
    }

    @Override
    public RespAccountDto findByIdSecond(Long id) {
        return this.accountRepo.findByIdSecond(id);
    }

    @Override
    public RespAccountDto findByUsername(String username) {
        return this.accountRepo.findByUsername(username);
    }
    // Đăng ký 
    @Transactional
    @Modifying //thay đổi dữ liệu trong cơ sở dữ liệu.
    @Override
    public RespAccountDto register(ReqRegisterAccountDto reqRegisterAccountDto) {
    	
    	 BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
    	 
        if (this.accountRepo.findAccountByUsername(reqRegisterAccountDto.getUsername()) != null) {
            throw new AppException("Username đã tồn tại"); //Kiểm tra xem tên người dùng đã tồn tại trong cơ sở dữ liệu chưa
        }
        if (this.accountDetailService.findAccountDetailByEmail(reqRegisterAccountDto.getEmail()) != null){
            throw new AppException("Email đã tồn tại"); //Kiểm tra xem địa chỉ email đã tồn tại trong cơ sở dữ liệu chưa.
        }
        //Tạo một tài khoản người dùng (Account) từ dữ liệu đăng ký được truyền vào
        Account account = ConvertUtil.ReqCreateAccountDtoToAccount(reqRegisterAccountDto);
        account.setPassword(bcryptPasswordEncoder.encode(account.getPassword())); //mã hóa mật khẩu trước khi lưu vào cơ sở dữ liệu.
        Role role = roleService.findById(3L); //Gán một vai trò cho tài khoản người dùng và lưu vào cơ sở dữ liệu.
        account.setRole(role);
        account = this.accountRepo.save(account);//Lưu tài khoản
        
        //Tạo chi tiết tài khoản (AccountDetail) từ dữ liệu đăng ký và gán nó cho tài khoản người dùng.
        AccountDetail accountDetail = ConvertUtil.ReqAccountDtoToAccountDetail(reqRegisterAccountDto);
        accountDetail.setAccount(account);
        accountDetail = this.accountDetailService.save(accountDetail); // Lưu chi tiết tài khoản
        
        //chuyển tài khoản và chi tiết tài khoản thành một đối tượng RespAccountDto.
        RespAccountDto respAccountDto = ConvertUtil.accountToRespAccountDto(account, accountDetail);
        return respAccountDto;
    }
    
    
    @Override
    public Account findAccountByUsername(String username) {
        return this.accountRepo.findAccountByUsername(username);
    }
    
    
    @Override
    public void deleteOrRestore(Boolean isActive, Long id) {
        this.accountRepo.deleteOrRestore(isActive, id);
    }
    
    @Override
    public Integer getToTalPage() {
        return this.accountRepo.findAll(PageRequest.of(0, 9)).getTotalPages();
    }

    @Transactional
    @Modifying
    @Override
    public Account save(ReqCreateAccountDto reqCreateAccountDto) {
        if (this.accountRepo.findAccountByUsername(reqCreateAccountDto.getUsername()) != null) {
            throw new AppException("Username đã tồn tại");
        }
        if (this.accountDetailService.findAccountDetailByEmail(reqCreateAccountDto.getEmail()) != null){
            throw new AppException("Email đã tồn tại");
        }
        Account account = ConvertUtil.ReqCreateAccountDtoToAccount(reqCreateAccountDto);
        account.setId(this.accountRepo.save(account).getId());
        AccountDetail accountDetail = ConvertUtil.ReqAccountDtoToAccountDetail(reqCreateAccountDto);
        accountDetail.setAccount(account);
        this.accountDetailService.save(accountDetail);
        return account;
    }

	@Override
	public Boolean checkAccountByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(AccountDto accountDto) {
		// TODO Auto-generated method stub
		
	}
    
    
}
