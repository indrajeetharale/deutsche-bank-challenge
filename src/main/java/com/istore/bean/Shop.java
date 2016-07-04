package com.istore.bean;

public class Shop {
	
	String shopId;
	String shopName;
	String shopNumber;
	String shopAddress;
	String shopPostalCode;
	String shopLatitute;
	String shopLongitude;
	
	
	public Shop(String shopName, String shopAddress,String shopNumber, String shopPostalCode) {
		super();
		this.shopName = shopName;
		this.shopNumber = shopNumber;
		this.shopPostalCode = shopPostalCode;
		this.shopAddress=shopAddress;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopNumber() {
		return shopNumber;
	}
	public void setShopNumber(String shopNumber) {
		this.shopNumber = shopNumber;
	}
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	public String getShopPostalCode() {
		return shopPostalCode;
	}
	public void setShopPostalCode(String shopPostalCode) {
		this.shopPostalCode = shopPostalCode;
	}
	public String getShopLatitute() {
		return shopLatitute;
	}
	public void setShopLatitute(String shopLatitute) {
		this.shopLatitute = shopLatitute;
	}
	public String getShopLongitude() {
		return shopLongitude;
	}
	public void setShopLongitude(String shopLongitude) {
		this.shopLongitude = shopLongitude;
	}
	

	@Override
	public String toString() {
		return "Shop [shopName=" + shopName + ", shopNumber=" + shopNumber + ", shopPostalCode=" + shopPostalCode
				+ ", shopLatitute=" + shopLatitute + ", shopLongitude=" + shopLongitude + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shopName == null) ? 0 : shopName.hashCode());
		result = prime * result + ((shopNumber == null) ? 0 : shopNumber.hashCode());
		result = prime * result + ((shopPostalCode == null) ? 0 : shopPostalCode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shop other = (Shop) obj;
		if (shopName == null) {
			if (other.shopName != null)
				return false;
		} else if (!shopName.equals(other.shopName))
			return false;
		if (shopNumber == null) {
			if (other.shopNumber != null)
				return false;
		} else if (!shopNumber.equals(other.shopNumber))
			return false;
		if (shopPostalCode == null) {
			if (other.shopPostalCode != null)
				return false;
		} else if (!shopPostalCode.equals(other.shopPostalCode))
			return false;
		return true;
	}

}
