package com.ossjk.asset.land.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.ossjk.asset.base.entity.BaseEntity;

/**
 * <p>
 * 土地分配情况
 * </p>
 *
 * @author lym
 * @since 2020-01-13
 */
@TableName("land_receive")
public class Land_receive extends BaseEntity<Land_receive> {

	private static final long serialVersionUID = 1L;

	private String id;
	/**
	 * 土地编号
	 * 
	 */
	private String lid;
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
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	protected String crtm;
	/**
	 * 修改时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	protected String mdtm;
	/**
	 * 土地单据号
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

	public String getLid() {
		return lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
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
		return "Land_receive [id=" + id + ", lid=" + lid + ", oid=" + oid + ", creator=" + creator + ", remarks="
				+ remarks + ", crtm=" + crtm + ", mdtm=" + mdtm + ", receipt=" + receipt + "]";
	}

}
