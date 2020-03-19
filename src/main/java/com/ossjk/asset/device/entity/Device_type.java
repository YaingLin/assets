package com.ossjk.asset.device.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.ossjk.asset.base.entity.BaseEntity;

/**
 * <p>
 * 设备类型
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@TableName("device_type")
public class Device_type extends BaseEntity<Device_type> {

    private static final long serialVersionUID = 1L;

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
     * 备注
     */
	private String remarks;


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
		return "Device_type{" +
			"name=" + name +
			", brand=" + brand +
			", intlcode=" + intlcode +
			", model=" + model +
			", remarks=" + remarks +
			"}";
	}
}
