package com.ossjk.asset.system.vo;

import com.ossjk.asset.system.entity.Role_permission;

public class Role_permissionVo extends Role_permission {
	private String rName;
	private String pName;

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

}
