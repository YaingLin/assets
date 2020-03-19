package com.ossjk.asset.car.vo;

import com.ossjk.asset.car.entity.Car_repair;

public class Car_repairVo extends Car_repair {

	private String id;
	private String damagerNAME;
	private String repairerNAME;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDamagerNAME() {
		return damagerNAME;
	}

	public void setDamagerNAME(String damagerNAME) {
		this.damagerNAME = damagerNAME;
	}

	public String getRepairerNAME() {
		return repairerNAME;
	}

	public void setRepairerNAME(String repairerNAME) {
		this.repairerNAME = repairerNAME;
	}

}
