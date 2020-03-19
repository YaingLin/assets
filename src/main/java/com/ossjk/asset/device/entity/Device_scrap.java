package com.ossjk.asset.device.entity;

import java.io.Serializable;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.ossjk.asset.base.entity.BaseEntity;

/**
 * <p>
 * 设备报废
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@TableName("device_scrap")
public class Device_scrap extends BaseEntity<Device_scrap> {

    private static final long serialVersionUID = 1L;

    /**
     * 设备id
     */
	private String did;
    /**
     * 报废人
     */
	private String scraper;
    /**
     * 报废日期
     */
	private String scraperdate;
    /**
     * 报废备注
     */
	private String scrapremarks;
    /**
     * 状态 1-申请、2-准许、3-拒绝
     */
	private BigDecimal status;
    /**
     * 审批人
     */
	private String approver;
    /**
     * 审批意见
     */
	private String approvalremarks;
    /**
     * 申请日期
     */
	private String approvaldate;


	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getScraper() {
		return scraper;
	}

	public void setScraper(String scraper) {
		this.scraper = scraper;
	}

	public String getScraperdate() {
		return scraperdate;
	}

	public void setScraperdate(String scraperdate) {
		this.scraperdate = scraperdate;
	}

	public String getScrapremarks() {
		return scrapremarks;
	}

	public void setScrapremarks(String scrapremarks) {
		this.scrapremarks = scrapremarks;
	}

	public BigDecimal getStatus() {
		return status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getApprovalremarks() {
		return approvalremarks;
	}

	public void setApprovalremarks(String approvalremarks) {
		this.approvalremarks = approvalremarks;
	}

	public String getApprovaldate() {
		return approvaldate;
	}

	public void setApprovaldate(String approvaldate) {
		this.approvaldate = approvaldate;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Device_scrap{" +
			"did=" + did +
			", scraper=" + scraper +
			", scraperdate=" + scraperdate +
			", scrapremarks=" + scrapremarks +
			", status=" + status +
			", approver=" + approver +
			", approvalremarks=" + approvalremarks +
			", approvaldate=" + approvaldate +
			"}";
	}
}
