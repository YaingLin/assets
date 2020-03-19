package com.ossjk.asset.car.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableName;
import com.ossjk.asset.base.entity.BaseEntity;

/**
 * <p>
 * 车辆维修表
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@TableName("car_repair")
public class Car_repair extends BaseEntity<Car_repair> {

    private static final long serialVersionUID = 1L;

	private String id;
    /**
     * 车辆id
     */
	private String cid;
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
		return "Car_repair{" +
			"id=" + id +
			", cid=" + cid +
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
