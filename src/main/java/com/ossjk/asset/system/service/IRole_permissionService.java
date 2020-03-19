package com.ossjk.asset.system.service;

import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.ossjk.asset.system.entity.Role_permission;

/**
 * <p>
 * 角色权限中间表 服务类
 * </p>
 *
 * @author lym
 * @since 2020-01-09
 */
public interface IRole_permissionService extends IService<Role_permission> {

	public List<String> SelectRole_permissionCid(Wrapper wrapper);

	public boolean insertBatchAuthorize(String[] pid, String rid);

}
