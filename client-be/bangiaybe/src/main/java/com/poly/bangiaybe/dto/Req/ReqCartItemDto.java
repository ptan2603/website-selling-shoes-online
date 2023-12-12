package com.poly.bangiaybe.dto.Req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReqCartItemDto {
		private Long id;
//	 	private Long accountId;
	    private Long attributeId;
	    private Integer quantity;
	    private Double lastPrice;
	    
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		//		public Long getAccountId() {
//			return accountId;
//		}
//		public void setAccountId(Long accountId) {
//			this.accountId = accountId;
//		}
		public Long getAttributeId() {
			return attributeId;
		}
		public void setAttributeId(Long attributeId) {
			this.attributeId = attributeId;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public Double getLastPrice() {
			return lastPrice;
		}
		public void setLastPrice(Double lastPrice) {
			this.lastPrice = lastPrice;
		}

}
