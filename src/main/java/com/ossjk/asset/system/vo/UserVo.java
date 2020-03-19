package com.ossjk.asset.system.vo;

import com.ossjk.asset.system.entity.User;

public class UserVo extends User {
	private String rName;
	private String oName;
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getoName() {
		return oName;
	}
	public void setoName(String oName) {
		this.oName = oName;
	}
	
}
