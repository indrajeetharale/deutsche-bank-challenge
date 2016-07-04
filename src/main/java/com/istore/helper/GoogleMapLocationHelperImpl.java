package com.istore.helper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.istore.bean.Shop;
import com.istore.helper.exception.ShopLocationNotTracableException;

@Component
public class GoogleMapLocationHelperImpl implements LocationHelper {

	@Override
	public void setLocation(Shop shop) {
				RestTemplate template = new RestTemplate();
				 try {
										
					URL base =new URL("https://maps.googleapis.com/maps/api/geocode/json?address="+shop.getShopName()+","+shop.getShopAddress()+"&key=AIzaSyB8LI-R3tvmRE4Jge3JbVBU7ZtCtDMWRWg");
					ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
					String shopJSON = response.getBody();
					parseJackson(shopJSON, shop);
				} catch (MalformedURLException e) {
					throw  new ShopLocationNotTracableException(shop.getShopName());
				}
				

	}
	
	
	private void parseJackson(String shopJSON, Shop shop){
		try{
		//create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();

		//read JSON like DOM Parser
		JsonNode rootNode = objectMapper.readTree(shopJSON);
		
		Iterator<JsonNode> resultElements = rootNode.path("results").elements();
		if(resultElements.hasNext()){
			JsonNode node = resultElements.next();
			JsonNode geoNode = node.path("geometry");
			JsonNode locNode = geoNode.path("location");
			JsonNode latNode = locNode.path("lat");
			JsonNode lngNode = locNode.path("lng");
			shop.setShopLatitute(latNode.asText());
			shop.setShopLongitude(lngNode.asText());
		}
		}catch(Exception e){
			throw  new ShopLocationNotTracableException(shop.getShopName());
		}
		if(shop.getShopLatitute()==null && shop.getShopLongitude()==null){
			throw  new ShopLocationNotTracableException(shop.getShopName());
		}
	}
	
	/*public static void main(String arg[]){
		LocationHelper helper= new GoogleMapLocationHelperImpl();
		helper.setLocation(new Shop("apple store", "7021 S Memorial Dr, Tulsa, OK 74133, United States","12", "12"));
	}*/
	
}
