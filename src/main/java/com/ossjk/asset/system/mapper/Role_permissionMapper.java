package com.ossjk.asset.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.ossjk.asset.system.entity.Role_permission;

/**
 * <p>
 * 角色权限中间表 Mapper 接口
 * </p>
 *
 * @author lym
 * @since 2020-01-09
 */
public interface Role_permissionMapper extends BaseMapper<Role_permission> {
	
	List<String> SelectRole_permissionCid(@Param("ew") Wrapper wrapper);
}