package com.poly.bangiaybe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseProductDto {
	private long id;
    private String code;
    private String description;
    private String name;
    private long view;
    private double price;
    private String image;
    private String brand;
    private boolean isActive;
    
    public ResponseProductDto(
    	    long id,
    	    String code,
    	    String description,
    	    String name,
    	    long view,
    	    double price,
    	    String image,
    	    String brand,
    	    boolean isActive
    	) {
    	    this.id = id;
    	    this.code = code;
    	    this.description = description;
    	    this.name = name;
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
	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getView() {
        return view;
    }

    public void setView(long view) {
        this.view = view;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
