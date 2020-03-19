package com.ossjk.asset.device.entity;

import java.io.Serializable;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.ossjk.asset.base.entity.BaseEntity;

/**
 * <p>
 * 设备领用表
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@TableName("device_receive")
public class Device_receive extends BaseEntity<Device_receive> {

    private static final long serialVersionUID = 1L;

    /**
     * 设备id
     */
	private String did;
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


	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Device_receive{" +
			"did=" + did +
			", receipt=" + receipt +
			", recipients=" + recipients +
			", receivedate=" + receivedate +
			", returndate=" + returndate +
			", status=" + status +
			", receiveremarks=" + receiveremarks +
			", returnremarks=" + returnremarks +
			"}";
	}
}
