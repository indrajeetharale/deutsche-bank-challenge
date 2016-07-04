package com.istore.service;

import java.util.List;

import com.istore.bean.Distance;
import com.istore.bean.Shop;
import com.istore.service.exception.ShopNotFoundException;

public interface ShopService {
	
	public List<Shop> getAll();
	public Shop getShop(String id) throws ShopNotFoundException;
	public boolean deleteShop(Shop shop);
	public Shop deleteShop(String shopId) throws ShopNotFoundException;
	public Shop createShop(String shopName, String shopAddress,String shopNumber, String shopPostalCode);
	public boolean updateShop(String shopId,String shopName, String shopAddress,String shopNumber, String shopPostalCode)throws ShopNotFoundException;
	public Distance getDistance(double startLat, double startLong);

}
