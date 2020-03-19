package com.ossjk.asset.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ossjk.asset.system.entity.Permission;
import com.ossjk.asset.system.vo.PermissionVo;

/**
 * <p>
  * 权限 Mapper 接口
 * </p>
 *
 * @author lym
 * @since 2020-01-09
 */
public interface PermissionMapper extends BaseMapper<Permission> {
	
	List<PermissionVo> selectPermissionVo(Page page,@Param("ew") Wrapper wrapper);
	
	List<String> selectUserPermission(@Param("ew") Wrapper wrapper);
	
	List<Permission> selectMenuPermission(@Param("ew") Wrapper wrapper);
}