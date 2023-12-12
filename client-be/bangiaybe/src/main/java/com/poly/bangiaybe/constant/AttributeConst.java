package com.poly.bangiaybe.constant;

public class AttributeConst {
	/* Url Api */
    public static final String API_ATTRIBUTE_GET_BY_ID = "/api/attribute/get-by-id/{id}";
    public static final String API_ATTRIBUTE_GET_ALL = "/api/attribute/get-all";
    public static final String API_ATTRIBUTE_GET_BY_PRODUCT_ID = "/api/attribute/get-by-product";
    public static final String API_ATTRIBUTE_IS_VALID = "/api/attribute/valid";
    
    /* Attribute constant */
    public static final String ATTRIBUTE_MSG_ERROR_NOT_EXIST = "Mã sản phẩm không tồn tại!";
    public static final String ATTRIBUTE_MSG_ERROR_NOT_ENOUGH_STOCK = "Số lượng sản phẩm không đủ!";
    public static final Integer ATTRIBUTE_CACHE_INIT = 0;
}
