package com.ossjk.asset.system.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ossjk.asset.system.entity.Permission;
import com.ossjk.asset.system.mapper.PermissionMapper;
import com.ossjk.asset.system.service.IPermissionService;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author lym
 * @since 2020-01-09
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

	@Override
	public boolean insert(Permission entity) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
		String format = sdf.format(new Date());
		entity.setCrtm(format);
		entity.setMdtm(format);
		System.out.println(entity);
		return super.insert(entity);
	}
	@Override
	public Page selectPermissionVo(Page page, Wrapper wrapper) {
		SqlHelper.fillWrapper(page, wrapper);
		page.setRecords(baseMapper.selectPermissionVo(page, wrapper));
		return page;
	}
	@Override
	public List<String> selectUserPermission(Wrapper wrapper) {
		return baseMapper.selectUserPermission(wrapper);
	}
	@Override
	public List<Permission> selectMenuPermission(Wrapper wrapper) {
		return baseMapper.selectMenuPermission(wrapper);
	}
	
}
