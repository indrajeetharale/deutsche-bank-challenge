package com.istore.helper;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;

import com.istore.bean.Shop;


@Component
public class ShopAdmin {
	int nextShopId;
	Map<String,Shop> shopRepository;
	
	private static ShopAdmin instance;
    
	private static final Logger logger = LoggerFactory.getLogger(ShopAdmin.class);
    //private constructor to avoid client applications to use constructor
    private ShopAdmin(){
    	if(shopRepository==null){
    		shopRepository= new HashMap<>();
    		
    	}
    }

    public static   ShopAdmin getInstance(){
    	if(instance == null){
            synchronized (ShopAdmin.class) {
                if(instance == null){
                    instance = new ShopAdmin();
                }
            }
        }
        return instance;
    }
    
    
    public Map<String,Shop> getAll(){
    	logger.debug("Getting all the list of shops from repository");
    	return shopRepository;
    	
    }
	public Shop createShop(Shop shop){
		shop.setShopId(Integer.toString(++nextShopId));
		shopRepository.put(shop.getShopId(),shop);
		return shop;
		
	}
	public Shop getShop(String shopId){
		logger.debug("Return shop details of shop id"+ shopId);
		return shopRepository.get(shopId);
		
	}
	public boolean updateShop(Shop shop){
		shop=shopRepository.put(shop.getShopId(), shop);
		if(shop==null)
			return false;
		return true;
	}
	
	public boolean deleteShop(Shop shop){
		shopRepository.remove(shop.getShopId());
		return true;
	}
	public Shop deleteShop(String ShopId){
		return shopRepository.remove(ShopId);
	}
	

}
