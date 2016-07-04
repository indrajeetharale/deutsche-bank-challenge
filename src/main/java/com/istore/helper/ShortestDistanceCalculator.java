package com.istore.helper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.istore.bean.Distance;
import com.istore.bean.Shop;

@Component
public class ShortestDistanceCalculator {
	public static Distance getShortestDistance(double startLat, double startLong,Map<String,Shop> shopRepository){
	
		Distance dist= new Distance();
		double distance =50000.0;
		for (Map.Entry<String, Shop> entry : shopRepository.entrySet())
		{
			Shop shop= entry.getValue();
			double shopDistance = Haversine.distance(startLat, startLong,Double.valueOf(shop.getShopLatitute()), Double.valueOf(shop.getShopLongitude()));
			if(shopDistance<0){
				shopDistance=shopDistance*-1;
			}
		    if(shopDistance<distance){
		    	distance =shopDistance;
		    	dist= new Distance(shop,distance);
		    }
		}
		return dist;
	}

}
