package com.ossjk.asset.car.vo;

import com.ossjk.asset.car.entity.Car_scrap;

public class Car_scrapVo extends Car_scrap {

	private String id;
	private String scraperNAME;
	private String approverNAME;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getScraperNAME() {
		return scraperNAME;
	}

	public void setScraperNAME(String scraperNAME) {
		this.scraperNAME = scraperNAME;
	}

	public String getApproverNAME() {
		return approverNAME;
	}

	public void setApproverNAME(String approverNAME) {
		this.approverNAME = approverNAME;
	}

}
