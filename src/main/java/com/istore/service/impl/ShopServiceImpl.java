package com.istore.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.istore.bean.Distance;
import com.istore.bean.Shop;
import com.istore.helper.LocationHelper;
import com.istore.helper.ShopAdmin;
import com.istore.helper.ShortestDistanceCalculator;
import com.istore.service.ShopService;
import com.istore.service.exception.ShopNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ShopServiceImpl implements ShopService{
	
	@Autowired
	ShopAdmin shopAdmin;
	
	@Autowired
	LocationHelper locationHelper;

	@Override
	public List<Shop> getAll() {
		
		return new ArrayList<Shop>(shopAdmin.getAll().values());
	}

	@Override
	public Shop getShop(String shopId ) throws ShopNotFoundException {
		Shop shop=shopAdmin.getShop(shopId);
		if(shop==null){
			throw new  ShopNotFoundException(shopId);
		}
		return shop;
		
	}

	@Override
	public boolean deleteShop(Shop shop) {
		return shopAdmin.deleteShop(shop);
	}

	@Override
	public Shop deleteShop(String shopId)throws ShopNotFoundException {
		Shop shop= shopAdmin.deleteShop(shopId);
		if(shop==null){
			throw new  ShopNotFoundException(shopId);
		}
		return shop;
	}

	@Override
	public Shop createShop(String shopName, String shopAddress,String shopNumber, String shopPostalCode) {
		
		Shop shop=new Shop(shopName,shopAddress,shopNumber,shopPostalCode);
		locationHelper.setLocation(shop);
		return shopAdmin.createShop(shop);
		
	}

	@Override
	public boolean updateShop(String shopId,String shopName,String shopAddress, String shopNumber, String shopPostalCode)throws ShopNotFoundException {
		
		
		Shop shop=new Shop(shopName,shopAddress,shopNumber,shopPostalCode);
		shop.setShopId(shopId);
		locationHelper.setLocation(shop);
		boolean updated= shopAdmin.updateShop(shop);
		if(updated==false){
			throw new  ShopNotFoundException(shopId);
		}
		return updated;
		
	}

	@Override
	public Distance getDistance(double startLat, double startLong) {
		return ShortestDistanceCalculator.getShortestDistance(startLat, startLong, shopAdmin.getAll());
	}

}
