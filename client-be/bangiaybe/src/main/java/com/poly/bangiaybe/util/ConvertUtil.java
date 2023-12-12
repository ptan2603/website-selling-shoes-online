package com.poly.bangiaybe.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.poly.bangiaybe.constant.*;
import com.poly.bangiaybe.dto.*;
import com.poly.bangiaybe.dto.Req.ReqCreateAccountDto;
import com.poly.bangiaybe.dto.Req.ReqOrderDto;
import com.poly.bangiaybe.dto.Req.ReqRegisterAccountDto;
import com.poly.bangiaybe.dto.Resp.RespAccountDto;
import com.poly.bangiaybe.dto.Resp.RespCartItemDto;
import com.poly.bangiaybe.dto.Resp.RespProductDetailDto;
import com.poly.bangiaybe.dto.Resp.RespProductDto;
import com.poly.bangiaybe.entity.*;

public class ConvertUtil {
	
    public static RespAccountDto accountToRespAccountDto(Object[] objects){
        RespAccountDto respAccountDto = new RespAccountDto(null, null, null, null, null, null, null, null, null, null, null, null);
        respAccountDto.setId((Long) objects[0]);
        respAccountDto.setUsername((String) objects[1]);
        respAccountDto.setCreateDate((LocalDate) objects[2]);
        respAccountDto.setModifyDate((LocalDate) objects[3]);
        respAccountDto.setIsActive((Boolean) objects[4]);
        respAccountDto.setRoleName((String) objects[5]);
        respAccountDto.setFullName((String) objects[6]);
        respAccountDto.setGender((String) objects[7]);
        respAccountDto.setPhone((String) objects[8]);
        respAccountDto.setEmail((String) objects[9]);
        respAccountDto.setAddress((String) objects[10]);
        respAccountDto.setBirthDate((LocalDate) objects[11]);
        return  respAccountDto;
    }
    
    public static RespAccountDto accountToRespAccountDto(Account account, AccountDetail accountDetail){
        RespAccountDto respAccountDto = new RespAccountDto(null, null, null, null, null, null, null, null, null, null, null, null);
        respAccountDto.setId(account.getId());
        respAccountDto.setUsername(account.getUsername());
        respAccountDto.setCreateDate(account.getCreateDate());
        respAccountDto.setModifyDate(account.getModifyDate());
        respAccountDto.setRoleName("CUSTOMER");
        respAccountDto.setIsActive(account.getIsActive());
        respAccountDto.setFullName(accountDetail.getFullname());
        respAccountDto.setGender(accountDetail.getGender());
        respAccountDto.setPhone(accountDetail.getPhone());
        respAccountDto.setEmail(accountDetail.getEmail());
        respAccountDto.setAddress(accountDetail.getAddress());
        respAccountDto.setBirthDate(LocalDate.now());
        return  respAccountDto;
    }
    
    public static Account ReqCreateAccountDtoToAccount(ReqCreateAccountDto reqAccountDto){
      PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
      Account account = new Account();
      account.setUsername(reqAccountDto.getUsername());
      account.setPassword(passwordEncoder.encode(reqAccountDto.getPassword()));
      account.setPassword(reqAccountDto.getPassword());
      account.setCreateDate(LocalDate.now());
      account.setModifyDate(LocalDate.now());
      account.setIsActive(true);
      Role role = new Role();
      role.setId(reqAccountDto.getRoleId());
      account.setRole(role);
      return account;
  }

  public static Account ReqCreateAccountDtoToAccount(ReqRegisterAccountDto reqAccountDto){
      Account account = new Account();
      account.setUsername(reqAccountDto.getUsername());
      account.setPassword(reqAccountDto.getPassword());
      account.setCreateDate(LocalDate.now());
      account.setModifyDate(LocalDate.now());
      account.setIsActive(true);
      return account;
  }

  public static AccountDetail ReqAccountDtoToAccountDetail(ReqCreateAccountDto reqCreateAccountDto){
      AccountDetail accountDetail = new AccountDetail();
      Account account = new Account();
      accountDetail.setAccount(account);
      accountDetail.setFullname(reqCreateAccountDto.getFullName());
      accountDetail.setGender(reqCreateAccountDto.getGender());
      accountDetail.setPhone(reqCreateAccountDto.getPhone());
      accountDetail.setEmail(reqCreateAccountDto.getEmail());
      accountDetail.setAddress(reqCreateAccountDto.getAddress());
      accountDetail.setBirthDate(LocalDate.now());
      return accountDetail;
  }

  public static AccountDetail ReqAccountDtoToAccountDetail(ReqRegisterAccountDto ReqRegisterAccountDto){
      AccountDetail accountDetail = new AccountDetail();
      accountDetail.setFullname(ReqRegisterAccountDto.getFullName());
      accountDetail.setGender(ReqRegisterAccountDto.getGender());
      accountDetail.setPhone(ReqRegisterAccountDto.getPhone());
      accountDetail.setEmail(ReqRegisterAccountDto.getEmail());
      accountDetail.setAddress(ReqRegisterAccountDto.getAddress());
      accountDetail.setBirthDate(LocalDate.now());
      return accountDetail;
  }
	
	public static RespProductDto fromProduct(Object[] objects){
        RespProductDto respProductDto = new RespProductDto(null, null, null, null, null, null, null, null, null);
        respProductDto.setId((Long) objects[0]);
        respProductDto.setName((String) objects[1]);
        respProductDto.setCode((String) objects[2]);
        respProductDto.setDescription((String) objects[3]);
        respProductDto.setView((Long) objects[4]);
        respProductDto.setPrice((Double) objects[5]);
        respProductDto.setImage((String) objects[6]);
        respProductDto.setIsActive((Boolean) objects[7]);
        return respProductDto;
    }
	
	public static RespProductDetailDto fromProductDetail(Product product){
        RespProductDetailDto respProductDetailDto = new RespProductDetailDto();
        respProductDetailDto.setId(product.getId());
        respProductDetailDto.setName(product.getName());
        respProductDetailDto.setCode(product.getCode());
        respProductDetailDto.setDescription(product.getDescription());
        String main = product.getImages().stream().filter(item -> item.getName().equals("main")).findFirst().get().getImageLink();
        respProductDetailDto.setMain(main);
        List<String> images = product.getImages().stream().map(item -> item.getImageLink()).collect(Collectors.toList());
        respProductDetailDto.setImages(images);
        respProductDetailDto.setAttributes((List<Attribute>) product.getAttributes());
        for(Attribute a: product.getAttributes()){
            if(a.getSize().equals(ProductConst.PRODUCT_AVG_SIZE)){
                respProductDetailDto.setPrice(a.getPrice());
                break;
            }
        }
        List<Long> longs = product.getProductCategories().stream().map((item) -> item.getCategory().getId()).collect(Collectors.toList());
        respProductDetailDto.setCategory(longs);
        respProductDetailDto.setView(product.getView());
        return respProductDetailDto;
    }
	
//	public static RespCartItemDto fromCartItem(RespCartItemDto item){
//        RespCartItemDto respCartItemDto = new RespCartItemDto();
//        respCartItemDto.setId((Long) item[0]);
//        respCartItemDto.setImage((String) item[1]);
//        respCartItemDto.setName((String) item[2]);
//        respCartItemDto.setSize((Integer) item[3]);
//        respCartItemDto.setPrice((Double) item[4]);
//        respCartItemDto.setQuantity((Integer) item[5]);
//        respCartItemDto.setStock((Integer) item[6]);
//        respCartItemDto.setLastPrice((Double) item[7]);
//        return respCartItemDto;
//    }
	




}
