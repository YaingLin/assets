package com.ossjk.asset.car.vo;

import com.ossjk.asset.car.entity.Car_receive;

public class Car_receiveVo extends Car_receive {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String recipientsNAME;

	public String getRecipientsNAME() {
		return recipientsNAME;
	}

	public void setRecipientsNAME(String recipientsNAME) {
		this.recipientsNAME = recipientsNAME;
	}

}
