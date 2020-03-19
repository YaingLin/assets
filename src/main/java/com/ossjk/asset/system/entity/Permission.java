package com.ossjk.asset.system.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableName;
import com.ossjk.asset.base.entity.BaseEntity;

/**
 * <p>
 * 权限
 * </p>
 *
 * @author lym
 * @since 2020-01-09
 */
@TableName("permission")
public class Permission extends BaseEntity<Permission> {

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
     * url
     */
	private String url;
    /**
     * 序号
     */
	private BigDecimal sort;
    /**
     * 备注
     */
	private String remarks;
    /**
     * 等级
     */
	private BigDecimal level;



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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public BigDecimal getSort() {
		return sort;
	}

	public void setSort(BigDecimal sort) {
		this.sort = sort;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
		return "Permission{" +
			"id=" + id +
			", pid=" + pid +
			", name=" + name +
			", url=" + url +
			", sort=" + sort +
			", remarks=" + remarks +
			", level=" + level +
			", crtm=" + crtm +
			", mdtm=" + mdtm +
			"}";
	}
}
