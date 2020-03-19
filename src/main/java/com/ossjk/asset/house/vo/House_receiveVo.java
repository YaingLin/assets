package com.ossjk.asset.house.vo;

import com.ossjk.asset.house.entity.House_receive;

public class House_receiveVo extends House_receive {
	private String address;
	private String oName;
	private String uName;
	private String service_life;
	private Integer status;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getoName() {
		return oName;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getService_life() {
		return service_life;
	}

	public void setService_life(String service_life) {
		this.service_life = service_life;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
