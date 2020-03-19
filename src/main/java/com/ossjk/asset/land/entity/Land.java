package com.ossjk.asset.land.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;
import com.ossjk.asset.base.entity.BaseEntity;

/**
 * <p>
 * 土地明细
 * </p>
 *
 * @author lym
 * @since 2020-01-12
 */
@TableName("land")
public class Land extends BaseEntity<Land> {

	private static final long serialVersionUID = 1L;

	private String id;
	/**
	 * 土地性质
	 */
	private String property;
	/**
	 * 土地位置
	 * 
	 */
	private String address;
	/**
	 * 土地面积
	 * 
	 */
	private Double area;
	/**
	 * 使用期限
	 * 
	 */
	private String service_life;
	/**
	 * 备注信息
	 */
	private String remarks;
	/**
	 * 土地状态：0、闲置 1、已分配 2、其他
	 */
	private Integer status;
	/**
	 * 土地流水号
	 */
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public String getService_life() {
		return service_life;
	}

	public void setService_life(String service_life) {
		this.service_life = service_life;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
		return "Land [id=" + id + ", property=" + property + ", address=" + address + ", area=" + area
				+ ", service_life=" + service_life + ", remarks=" + remarks + ", status=" + status + ", code=" + code
				+ "]";
	}

}
