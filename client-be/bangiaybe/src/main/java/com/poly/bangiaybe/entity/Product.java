package com.poly.bangiaybe.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

import javax.management.Notification;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "product")
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long id;
	
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    
    @Column(name = "code", nullable = false, unique = true, length = 20)
    private String code;
    
    @Column(name = "description", nullable = false, length = 1000)
    private String description;
    
    @Column(name = "create_date", nullable = false)
    private LocalDate createDate;
    
    @Column(name = "modify_date", nullable = false)
    private LocalDate modifyDate;
    
    @Column(name = "view", nullable = false)
    private Long view;
    
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Collection<ProductCategory> productCategories;
    
    @OneToMany(mappedBy = "product")
    private Collection<Image> images;
    
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private Collection<Attribute> attributes;
    
    
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Collection<ProductCategory> getProductCategories() {
		return productCategories;
	}

	public void setProductCategories(Collection<ProductCategory> productCategories) {
		this.productCategories = productCategories;
	}

	public Collection<Image> getImages() {
		return images;
	}

	public void setImages(Collection<Image> images) {
		this.images = images;
	}

	public Collection<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(Collection<Attribute> attributes) {
		this.attributes = attributes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Long getView() {
		return view;
	}

	public void setView(Long view) {
		this.view = view;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}
    
}
