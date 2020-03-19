package com.ossjk.asset.system.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.ossjk.asset.base.entity.BaseEntity;

/**
 * <p>
 * 数据字典
 * </p>
 *
 * @author lym
 * @since 2020-01-09
 */
@TableName("dictionary")
public class Dictionary extends BaseEntity<Dictionary> {

    private static final long serialVersionUID = 1L;

	private String id;
    /**
     * 键
     */
	private String dkey;
    /**
     * 值
     */
	private String dvalue;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDkey() {
		return dkey;
	}

	public void setDkey(String dkey) {
		this.dkey = dkey;
	}

	public String getDvalue() {
		return dvalue;
	}

	public void setDvalue(String dvalue) {
		this.dvalue = dvalue;
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
		return "Dictionary{" +
			"id=" + id +
			", dkey=" + dkey +
			", dvalue=" + dvalue +
			", crtm=" + crtm +
			", mdtm=" + mdtm +
			"}";
	}
}
