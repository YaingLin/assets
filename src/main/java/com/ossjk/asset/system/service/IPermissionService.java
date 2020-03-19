package com.ossjk.asset.system.service;

import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.ossjk.asset.system.entity.Permission;

/**
 * <p>
 * 权限 服务类
 * </p>
 *
 * @author lym
 * @since 2020-01-09
 */
public interface IPermissionService extends IService<Permission> {

	public Page selectPermissionVo(Page page, Wrapper wrapper);

	public List<String> selectUserPermission(Wrapper wrapper);

	public List<Permission> selectMenuPermission(Wrapper wrapper);

}
