package com.poly.bangiaybe.dto.Req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReqFilterProduct {
	private Integer page;
    private Integer count;
    private List<Long> category;
    private List<Long> brand;
    private Double min;
    private Double max;
    
    
	public List<Long> getBrand() {
		return brand;
	}
	public void setBrand(List<Long> brand) {
		this.brand = brand;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<Long> getCategory() {
		return category;
	}
	public void setCategory(List<Long> category) {
		this.category = category;
	}
	public Double getMin() {
		return min;
	}
	public void setMin(Double min) {
		this.min = min;
	}
	public Double getMax() {
		return max;
	}
	public void setMax(Double max) {
		this.max = max;
	}
    
    
}
