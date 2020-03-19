package com.ossjk.asset.car.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableName;
import com.ossjk.asset.base.entity.BaseEntity;

/**
 * <p>
 * 车辆类型
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@TableName("car_type")
public class Car_type extends BaseEntity<Car_type> {

    private static final long serialVersionUID = 1L;

	private String id;
    /**
     * 名字
     */
	private String name;
    /**
     * 品牌
     */
	private String brand;
    /**
     * 国际编号
     */
	private String intlcode;
    /**
     * 型号
     */
	private String model;
    /**
     * 规格
     */
	private String specifications;
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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
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
		return "Car_type{" +
			"id=" + id +
			", name=" + name +
			", brand=" + brand +
			", intlcode=" + intlcode +
			", model=" + model +
			", specifications=" + specifications +
			", remarks=" + remarks +
			", crtm=" + crtm +
			", mdtm=" + mdtm +
			"}";
	}
}
