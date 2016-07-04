package com.istore.bean;

public class Distance {
	public Distance(Shop shop, double distance) {
		super();
		this.shop = shop;
		this.distance = distance;
	}
	public Distance() {
		// TODO Auto-generated constructor stub
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	Shop shop;
	double distance;
	

}
