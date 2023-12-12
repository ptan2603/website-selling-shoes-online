package com.poly.bangiaybe.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "images")
public class Image {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
	
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "image_link", nullable = false, length = 255)
    private String imageLink;
    
    @Column(name = "create_date", nullable = false)
    private LocalDate createDate;
    
    @Column(name = "modify_date", nullable = false)
    private LocalDate modifyDate;
    
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    
    
	public String getName() {
		return name;
	}
    

	public void setName(String name) {
		this.name = name;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	@ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;
}
