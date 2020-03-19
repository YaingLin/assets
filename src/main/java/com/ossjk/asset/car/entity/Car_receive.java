package com.ossjk.asset.car.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableName;
import com.ossjk.asset.base.entity.BaseEntity;

/**
 * <p>
 * 车辆领用表
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@TableName("car_receive")
public class Car_receive extends BaseEntity<Car_receive> {

    private static final long serialVersionUID = 1L;

	private String id;
    /**
     * 车辆id
     */
	private String cid;
    /**
     * 单据号
     */
	private String receipt;
    /**
     * 领用人
     */
	private String recipients;
    /**
     * 领取时间
     */
	private String receivedate;
    /**
     * 归还日期
     */
	private String returndate;
    /**
     * 状态 1-领用、2-归还
     */
	private BigDecimal status;
    /**
     * 领用备注
     */
	private String receiveremarks;
    /**
     * 归还备注
     */
	private String returnremarks;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getRecipients() {
		return recipients;
	}

	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}

	public String getReceivedate() {
		return receivedate;
	}

	public void setReceivedate(String receivedate) {
		this.receivedate = receivedate;
	}

	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}

	public BigDecimal getStatus() {
		return status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public String getReceiveremarks() {
		return receiveremarks;
	}

	public void setReceiveremarks(String receiveremarks) {
		this.receiveremarks = receiveremarks;
	}

	public String getReturnremarks() {
		return returnremarks;
	}

	public void setReturnremarks(String returnremarks) {
		this.returnremarks = returnremarks;
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
		return "Car_receive{" +
			"id=" + id +
			", cid=" + cid +
			", receipt=" + receipt +
			", recipients=" + recipients +
			", receivedate=" + receivedate +
			", returndate=" + returndate +
			", status=" + status +
			", receiveremarks=" + receiveremarks +
			", returnremarks=" + returnremarks +
			", crtm=" + crtm +
			", mdtm=" + mdtm +
			"}";
	}
}
