package com.ossjk.asset.system.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.ossjk.asset.system.entity.Organization;

/**
 * <p>
 * 组织机构vo
 * </p>
 *
 * @author lym
 * @since 2020-01-09
 */
public class OrganizationVo extends Organization {

	private static final long serialVersionUID = 1L;
	private String upName;

	public String getUpName() {
		return upName;
	}

	public void setUpName(String upName) {
		this.upName = upName;
	}

}
