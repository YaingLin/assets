package com.ossjk.asset.car.vo;

import com.ossjk.asset.car.entity.Car;

public class CarVo extends Car {

	private String name;
	private String buyerName;
	private String creatorName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

}
