package com.ossjk.asset.book.entity;

import java.io.Serializable;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.ossjk.asset.base.entity.BaseEntity;

/**
 * <p>
 * 家具图书报废
 * </p>
 *
 * @author lxw
 * @since 2020-01-09
 */
@TableName("furniture_books_scrap")
public class Furniture_books_scrap extends BaseEntity<Furniture_books_scrap> {

    private static final long serialVersionUID = 1L;

	private String id;
    /**
     * 家具图书id
     */
	private String fbid;
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

	public String getFbid() {
		return fbid;
	}

	public void setFbid(String fbid) {
		this.fbid = fbid;
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
		return "Furniture_books_scrap{" +
			"id=" + id +
			", fbid=" + fbid +
			", scraper=" + scraper +
			", scraperdate=" + scraperdate +
			", scrapremarks=" + scrapremarks +
			", status=" + status +
			", approver=" + approver +
			", approvalremarks=" + approvalremarks +
			", approvaldate=" + approvaldate +
			", crtm=" + crtm +
			", mdtm=" + mdtm +
			"}";
	}
}
