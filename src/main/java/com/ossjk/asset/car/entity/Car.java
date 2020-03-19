package com.ossjk.asset.car.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableName;
import com.ossjk.asset.base.entity.BaseEntity;

/**
 * <p>
 * 车辆明细
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@TableName("car")
public class Car extends BaseEntity<Car> {

    private static final long serialVersionUID = 1L;

	private String id;
    /**
     * 车辆类型id
     */
	private String ctid;
    /**
     * 车辆流水号
     */
	private String code;
    /**
     * 净残值率
     */
	private BigDecimal residualrate;
    /**
     * 使用年限
     */
	private BigDecimal useyear;
    /**
     * 净值
     */
	private BigDecimal residual;
    /**
     * 原值
     */
	private BigDecimal original;
    /**
     * 状态 1-入库、2-出库中、3-出库、4-领用、5-报修
     */
	private BigDecimal status;
    /**
     * 生产日期
     */
	private String proddate;
    /**
     * 登记人
     */
	private String creator;
    /**
     * 登记时间
     */
	private String createtime;
    /**
     * 购买人
     */
	private String buyer;
    /**
     * 购买日期
     */
	private String bugdate;
    /**
     * 序列号
     */
	private String sno;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCtid() {
		return ctid;
	}

	public void setCtid(String ctid) {
		this.ctid = ctid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getResidualrate() {
		return residualrate;
	}

	public void setResidualrate(BigDecimal residualrate) {
		this.residualrate = residualrate;
	}

	public BigDecimal getUseyear() {
		return useyear;
	}

	public void setUseyear(BigDecimal useyear) {
		this.useyear = useyear;
	}

	public BigDecimal getResidual() {
		return residual;
	}

	public void setResidual(BigDecimal residual) {
		this.residual = residual;
	}

	public BigDecimal getOriginal() {
		return original;
	}

	public void setOriginal(BigDecimal original) {
		this.original = original;
	}

	public BigDecimal getStatus() {
		return status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public String getProddate() {
		return proddate;
	}

	public void setProddate(String proddate) {
		this.proddate = proddate;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getBugdate() {
		return bugdate;
	}

	public void setBugdate(String bugdate) {
		this.bugdate = bugdate;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
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
		return "Car{" +
			"id=" + id +
			", ctid=" + ctid +
			", code=" + code +
			", residualrate=" + residualrate +
			", useyear=" + useyear +
			", residual=" + residual +
			", original=" + original +
			", status=" + status +
			", proddate=" + proddate +
			", creator=" + creator +
			", createtime=" + createtime +
			", buyer=" + buyer +
			", bugdate=" + bugdate +
			", sno=" + sno +
			", crtm=" + crtm +
			", mdtm=" + mdtm +
			"}";
	}
}
