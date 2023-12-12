package com.poly.bangiaybe.dto.Resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespAccountDto {
	//12 truong
    //account
    private Long id;
    private String username;
    private LocalDate createDate;
    private LocalDate modifyDate;
    private Boolean isActive;
    //role
    private String roleName;
    //account detail
    private String fullName;
    private String gender;
    private String phone;
    private String email;
    private String address;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate birthDate;
    
    public RespAccountDto(
    	    Long id,
    	    String username,
    	    LocalDate createDate,
    	    LocalDate modifyDate,
    	    Boolean isActive,
    	    String roleName,
    	    String fullName,
    	    String gender,
    	    String phone,
    	    String email,
    	    String address,
    	    LocalDate birthDate
    	) {
    	    this.id = id;
    	    this.username = username;
    	    this.createDate = createDate;
    	    this.modifyDate = modifyDate;
    	    this.isActive = isActive;
    	    this.roleName = roleName;
    	    this.fullName = fullName;
    	    this.gender = gender;
    	    this.phone = phone;
    	    this.email = email;
    	    this.address = address;
    	    this.birthDate = birthDate;
    	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(LocalDate modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
    
    
}
