package com.poly.bangiaybe.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "account_detail")
public class AccountDetail {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id", nullable = false)
	    private Long id;
	 
	    @Column(name = "fullname", nullable = false, length = 50)
	    private String fullname;
	    
	    @Column(name = "gender", nullable = false, length = 10)
	    private String gender;
	    
	    @Column(name = "phone", nullable = false, length = 11)
	    private String phone;
	    
	    @Column(name = "email", nullable = false, length = 50)
	    private String email;
	    
	    @Column(name = "address", nullable = false, length = 265)
	    private String address;
	    
	    @Column(name = "birthdate", nullable = false)
	    private LocalDate birthDate;
	    
	    @OneToOne
	    @JoinColumn(name = "account_id", unique = true)
	    private Account account;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFullname() {
			return fullname;
		}

		public void setFullname(String fullname) {
			this.fullname = fullname;
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

		public Account getAccount() {
			return account;
		}

		public void setAccount(Account account) {
			this.account = account;
		}
	    
	    
}
