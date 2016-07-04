package com.istore.service.exception;

public class ShopNotFoundException extends RuntimeException {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 5325337667901007467L;
	private String shopId;
	  public ShopNotFoundException(String shopId) {
	    this.shopId = shopId;
	  }
	  public String getShopId() {
	    return shopId;
	  }
}
