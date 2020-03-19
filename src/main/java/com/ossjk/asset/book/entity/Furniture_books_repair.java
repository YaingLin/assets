package com.ossjk.asset.book.entity;

import java.io.Serializable;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.ossjk.asset.base.entity.BaseEntity;

/**
 * <p>
 * 家具图书维修表
 * </p>
 *
 * @author lxw
 * @since 2020-01-09
 */
@TableName("furniture_books_repair")
public class Furniture_books_repair extends BaseEntity<Furniture_books_repair> {

    private static final long serialVersionUID = 1L;

	private String id;
    /**
     * 家具图书id
     */
	private String fbid;
    /**
     * 报修人
     */
	private String damager;
    /**
     * 报修时间
     */
	private String damagedate;
    /**
     * 报修备注
     */
	private String damageremarks;
    /**
     * 维修时间
     */
	private String repairdate;
    /**
     * 维修人
     */
	private String repairer;
    /**
     * 维修备注
     */
	private String repairremarks;
    /**
     * 状态 1-报修、2-维修
     */
	private BigDecimal status;
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

	public String getDamager() {
		return damager;
	}

	public void setDamager(String damager) {
		this.damager = damager;
	}

	public String getDamagedate() {
		return damagedate;
	}

	public void setDamagedate(String damagedate) {
		this.damagedate = damagedate;
	}

	public String getDamageremarks() {
		return damageremarks;
	}

	public void setDamageremarks(String damageremarks) {
		this.damageremarks = damageremarks;
	}

	public String getRepairdate() {
		return repairdate;
	}

	public void setRepairdate(String repairdate) {
		this.repairdate = repairdate;
	}

	public String getRepairer() {
		return repairer;
	}

	public void setRepairer(String repairer) {
		this.repairer = repairer;
	}

	public String getRepairremarks() {
		return repairremarks;
	}

	public void setRepairremarks(String repairremarks) {
		this.repairremarks = repairremarks;
	}

	public BigDecimal getStatus() {
		return status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
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
		return "Furniture_books_repair{" +
			"id=" + id +
			", fbid=" + fbid +
			", damager=" + damager +
			", damagedate=" + damagedate +
			", damageremarks=" + damageremarks +
			", repairdate=" + repairdate +
			", repairer=" + repairer +
			", repairremarks=" + repairremarks +
			", status=" + status +
			", crtm=" + crtm +
			", mdtm=" + mdtm +
			"}";
	}
}
