package com.ossjk.asset.device.vo;

import javax.swing.Spring;

import com.ossjk.asset.device.entity.Device;

public class DeviceVo extends Device{
	//设备名称
	private String tname;
	//登记人
	private String uname;
	//购买人
	private String ename;

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}


}
