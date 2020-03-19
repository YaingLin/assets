package com.ossjk.asset.land.vo;

import com.ossjk.asset.land.entity.Land_receive;

public class Land_receiveVo extends Land_receive {
	private String address;
	private String oName;
	private String uName;
	private String service_life;
	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getService_life() {
		return service_life;
	}

	public void setService_life(String service_life) {
		this.service_life = service_life;
	}

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

	@Override
	public String toString() {
		return super.toString()+"Land_receiveVo [address=" + address + ", oName=" + oName + ", uName=" + uName + ", service_life="
				+ service_life + ", status=" + status + "]";
	}

}
