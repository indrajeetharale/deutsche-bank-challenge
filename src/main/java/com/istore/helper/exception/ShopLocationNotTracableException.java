package com.istore.helper.exception;

public class ShopLocationNotTracableException extends RuntimeException {
	  /**
	 * 
	 */
	private static final long serialVersionUID = -5527861106079411592L;
	/**
	 * 
	 */
	private String shopAddress;
	  public ShopLocationNotTracableException(String shopAddress) {
	    this.shopAddress = shopAddress;
	  }
	  public String getShopId() {
	    return shopAddress;
	  }
}
