package com.ossjk.asset.book.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.ossjk.asset.base.entity.BaseEntity;

/**
 * <p>
 * 家具图书类型
 * </p>
 *
 * @author lxw
 * @since 2020-01-09
 */
@TableName("furniture_books_type")
public class Furniture_books_type extends BaseEntity<Furniture_books_type> {

    private static final long serialVersionUID = 1L;

	private String id;
    /**
     * 类型：1、家具   2、图书
     */
	private Integer type;
    /**
     * 名字
     */
	private String name;
    /**
     * 品牌/出版社
     */
	private String brand;
    /**
     * 国际编号
     */
	private String intlcode;
    /**
     * 备注
     */
	private String remarks;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getIntlcode() {
		return intlcode;
	}

	public void setIntlcode(String intlcode) {
		this.intlcode = intlcode;
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
		return "Furniture_books_type{" +
			"id=" + id +
			", type=" + type +
			", name=" + name +
			", brand=" + brand +
			", intlcode=" + intlcode +
			", remarks=" + remarks +
			", crtm=" + crtm +
			", mdtm=" + mdtm +
			"}";
	}
}
