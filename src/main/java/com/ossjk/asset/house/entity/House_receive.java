package com.ossjk.asset.house.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.ossjk.asset.base.entity.BaseEntity;

/**
 * <p>
 * 房屋分配情况
 * </p>
 *
 * @author lym
 * @since 2020-01-12
 */
@TableName("house_receive")
public class House_receive extends BaseEntity<House_receive> {

	private static final long serialVersionUID = 1L;

	private String id;
	/**
	 * 房屋id
	 * 
	 */
	private String hid;
	/**
	 * 分配单位
	 * 
	 */
	private String oid;
	/**
	 * 登记用户
	 */
	private String creator;
	/**
	 * 备注
	 * 
	 */
	private String remarks;
	/**
	 * 单据号
	 */
	private String receipt;

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "House_receive [id=" + id + ", hid=" + hid + ", oid=" + oid + ", creator=" + creator + ", remarks="
				+ remarks + ", receipt=" + receipt + "]";
	}

}
