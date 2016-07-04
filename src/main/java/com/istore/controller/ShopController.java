package com.istore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.istore.bean.Distance;
import com.istore.bean.Shop;
import com.istore.helper.exception.ShopLocationNotTracableException;
import com.istore.service.ShopService;
import com.istore.service.exception.ApplicationError;
import com.istore.service.exception.ShopNotFoundException;

/**
 * Shop Controller for Restful demo application.
 *
 * @author Indrajeet Harale
 */

@RestController
@RequestMapping("/shops")
public class ShopController {
	
	@Autowired
	ShopService shopService;
	
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	   @RequestMapping(value="/shops",method=RequestMethod.GET)
	    public List<Shop> getAll() {
		  logger.debug("ShopController:Getting all the list of shops from repository");  
		  return  shopService.getAll();
		 
	    }
	   
	   @RequestMapping(value="/shop",method=RequestMethod.GET)
	   @ResponseStatus(HttpStatus.OK)
	   public Shop getShop(@RequestParam("shopId") String shopId){
		   logger.debug("ShopController:Return shop details of shop id"+ shopId);
		   return shopService.getShop(shopId);
	   }
	   
	   @RequestMapping(value="/shop",method=RequestMethod.POST)
	   @ResponseStatus(HttpStatus.CREATED)
	   public Shop createShop(@RequestParam("shopName") String shopName,@RequestParam("shopAddress") String shopAddress,@RequestParam("shopNumber") String shopNumber,@RequestParam("shopPostalCode") String shopPostalCode) {
		   logger.debug("ShopController:Creating new shop");
		   return shopService.createShop(shopName,shopAddress,shopNumber,shopPostalCode);   
	   }
	   
	   @RequestMapping(value="/shop",method=RequestMethod.PUT)
	   @ResponseStatus(HttpStatus.OK)
	   public boolean updateShop(@RequestParam("shopId") String shopId,@RequestParam("shopName") String shopName,@RequestParam("shopAddress") String shopAddress,@RequestParam("shopNumber") String shopNumber,@RequestParam("shopPostalCode") String shopPostalCode) {
		   logger.debug("ShopController:Update shop details of shop id"+ shopId);
		   return shopService.updateShop(shopId,shopName,shopAddress,shopNumber,shopPostalCode);   
	   }
	   
	   @RequestMapping(value="/shop",method=RequestMethod.DELETE)
	   @ResponseStatus(HttpStatus.OK)
	   public Shop deleteShop(@RequestParam("shopId")  String shopId) {
		   logger.debug("ShopController:Delete shop details of shop id"+ shopId);
		   return shopService.deleteShop(shopId);   
	   }
	   
	   @RequestMapping(value="/distance",method=RequestMethod.GET)
	   @ResponseStatus(HttpStatus.OK)
	   public Distance getShop(@RequestParam("latitude") String latitude,@RequestParam("longitude") String longitude){
		   logger.debug("ShopController:Return nearest shop from latitude" + latitude +" and longitude : " + longitude );
		   return shopService.getDistance(Double.valueOf(latitude),Double.valueOf(longitude) );
	   }
	   @ExceptionHandler(ShopNotFoundException.class)
	   @ResponseStatus(HttpStatus.NOT_FOUND)
	   public ApplicationError shopNotFound(ShopNotFoundException e) {
	     String shopId = e.getShopId();
	     return new ApplicationError(4, "Shop [" + shopId + "] not found");
	   }
	   
	   @ExceptionHandler(ShopLocationNotTracableException.class)
	   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	   public ApplicationError shopNotFound(ShopLocationNotTracableException e) {
	     String shopId = e.getShopId();
	     return new ApplicationError(2, "Shop not created or updated");
	   }
}
