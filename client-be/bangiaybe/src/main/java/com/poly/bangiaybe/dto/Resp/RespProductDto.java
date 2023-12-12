package com.poly.bangiaybe.dto.Resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RespProductDto {
    private Long id;
    private String code;
    private String description;
    private String name;
    private Long view;
    private Double price;
    private String image;
    private String brand;
    private Boolean isActive;
    
    public RespProductDto(Long id, String name, String code, String description, Long view, Double price, String image, String brand, Boolean isActive) {
        // Khởi tạo các trường của RespProductDto
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.view = view;
        this.price = price;
        this.image = image;
        this.brand = brand;
        this.isActive = isActive;
    }
    
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getView() {
		return view;
	}
	public void setView(Long view) {
		this.view = view;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

    
    
}
