package com.ossjk.asset.system.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.ossjk.asset.base.entity.BaseEntity;

/**
 * <p>
 * 组织机构
 * </p>
 *
 * @author lym
 * @since 2020-01-09
 */
@TableName("organization")
public class Organization extends BaseEntity<Organization> {

	private static final long serialVersionUID = 1L;

	private String id;
	/**
	 * 父级id
	 */
	private String pid;
	/**
	 * 名字
	 */
	private String name;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 排序
	 */
	private BigDecimal sort;
	/**
	 * 等级
	 */
	private BigDecimal level;
	/**
	 * 创建时间
	 */
	private String crtm;
	/**
	 * 修改时间
	 */
	private String mdtm;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
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

	public BigDecimal getSort() {
		return sort;
	}

	public void setSort(BigDecimal sort) {
		this.sort = sort;
	}

	public BigDecimal getLevel() {
		return level;
	}

	public void setLevel(BigDecimal level) {
		this.level = level;
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
		return "Organization{" + "id=" + id + ", pid=" + pid + ", name=" + name + ", remarks=" + remarks + ", sort="
				+ sort + ", level=" + level + ", crtm=" + crtm + ", mdtm=" + mdtm + "}";
	}
}
