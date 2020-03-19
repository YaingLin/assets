package com.ossjk.asset.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ossjk.asset.system.entity.Role_permission;
import com.ossjk.asset.system.mapper.Role_permissionMapper;
import com.ossjk.asset.system.service.IRoleService;
import com.ossjk.asset.system.service.IRole_permissionService;

/**
 * <p>
 * 角色权限中间表 服务实现类
 * </p>
 *
 * @author lym
 * @since 2020-01-09
 */
@Service
public class Role_permissionServiceImpl extends ServiceImpl<Role_permissionMapper, Role_permission>
		implements IRole_permissionService {
	@Autowired
	private IRole_permissionService irps;
	@Autowired
	private IRoleService irs;

	@Override
	public List<String> SelectRole_permissionCid(Wrapper wrapper) {
		return baseMapper.SelectRole_permissionCid(wrapper);
	}

	@Override
	public boolean insertBatchAuthorize(String[] pid, String rid) {
		// 接收到所有的参数就要保存数据
		// 先删除掉rid中的所有的权限数据
		Wrapper wrapper = Condition.create().like("rid", rid);
		irps.delete(wrapper);
		// 再保存新的数据
		List entityList = new ArrayList();
		for (String string : pid) {
			Role_permission permission = new Role_permission();
			permission.setPid(string);
			permission.setRid(rid);
			entityList.add(permission);
		}
		return irs.insertBatch(entityList);
	}
}
