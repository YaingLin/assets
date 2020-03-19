package com.ossjk.asset.house.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.ossjk.asset.base.entity.BaseEntity;

/**
 * <p>
 * 房屋明细
 * </p>
 *
 * @author lym
 * @since 2020-01-12
 */
@TableName("house")
public class House extends BaseEntity<House> {

	private static final long serialVersionUID = 1L;

	private String id;
	/**
	 * 屋主
	 * 
	 */
	private String owner;
	/**
	 * 房屋性质
	 */
	private String property;
	/**
	 * 房屋位置
	 * 
	 */
	private String address;
	/**
	 * 房屋面积
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
	 * 房屋状态：0、闲置 1、已分配 2、其他
	 */
	private Integer status;
	/**
	 * 房屋流水号
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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "House [id=" + id + ", owner=" + owner + ", property=" + property + ", address=" + address + ", area="
				+ area + ", service_life=" + service_life + ", remarks=" + remarks + ", status=" + status + ", code="
				+ code + "]";
	}

}
