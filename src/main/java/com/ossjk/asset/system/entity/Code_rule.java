package com.ossjk.asset.system.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableName;
import com.ossjk.asset.base.entity.BaseEntity;

/**
 * <p>
 * 流水号规则表
 * </p>
 *
 * @author lym
 * @since 2020-01-09
 */
@TableName("code_rule")
public class Code_rule extends BaseEntity<Code_rule> {

    private static final long serialVersionUID = 1L;

	private String id;
    /**
     * 名字
     */
	private String name;
    /**
     * 规则表达式
     */
	private String rule;
    /**
     * 当前流水号
     */
	private String current;
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

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		this.current = current;
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
		return "Code_rule{" +
			"id=" + id +
			", name=" + name +
			", rule=" + rule +
			", current=" + current +
			", remarks=" + remarks +
			", crtm=" + crtm +
			", mdtm=" + mdtm +
			"}";
	}
}
