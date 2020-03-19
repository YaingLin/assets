package com.ossjk.asset.system.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableName;
import com.ossjk.asset.base.entity.BaseEntity;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author lym
 * @since 2020-01-09
 */
@TableName("role")
public class Role extends BaseEntity<Role> {

    private static final long serialVersionUID = 1L;

	private String id;
    /**
     * 名字
     */
	private String name;
    /**
     * 备注
     */
	private String remarks;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCrtm() {
		return crtm;
	}

	public void setCrtm(String crtm) {
		this.crtm = crtm;
	}

	public String getMdtm() {
		return mdtm;
	}

	public void setMdtm(String mdtm) {
		this.mdtm = mdtm;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Role{" +
			"id=" + id +
			", name=" + name +
			", remarks=" + remarks +
			", crtm=" + crtm +
			", mdtm=" + mdtm +
			"}";
	}
}
