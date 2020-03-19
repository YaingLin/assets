package com.ossjk.asset.system.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.ossjk.asset.base.entity.BaseEntity;

/**
 * <p>
 * 角色权限中间表
 * </p>
 *
 * @author lym
 * @since 2020-01-09
 */
@TableName("role_permission")
public class Role_permission extends BaseEntity<Role_permission>{

    private static final long serialVersionUID = 1L;

	private String id;
    /**
     * 角色id
     */
	private String rid;
    /**
     * 权限id
     */
	private String pid;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Role_permission{" +
			"id=" + id +
			", rid=" + rid +
			", pid=" + pid +
			"}";
	}
}
