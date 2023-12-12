package com.poly.bangiaybe.constant;

public class ProductConst {
	 /* Api Url */
    public static final String API_PRODUCT_GET_ALL = "/api/product/get-all";
    public static final String API_PRODUCT_GET_BY_ID = "/api/product/detail/{id}";
    public static final String API_PRODUCT_FIND_ALL = "/api/product/find-all";
    public static final String API_PRODUCT_FILTER = "/api/product/filter";
    public static final String API_PRODUCT_TOTAL_PAGE = "/api/product/total-page";
    public static final String API_PRODUCT_RELATE = "/api/product/relate";
    public static final String API_PRODUCT_SEARCH = "/api/products/search";
    
    /* Product Constant */
    public static final Integer PRODUCT_AVG_SIZE = 39;
    public static final String PRODUCT_MAIN_IMAGE = "main";
    public static final String PRODUCT_OTHER_IMAGE = "other";
    public static final String PRODUCT_MSG_ERROR_NOT_EXIST = "Mã sản phẩm không tồn tại!";
    public static final String PRODUCT_MSG_CODE_EXIST = "Code đã tồn tại!";
}
