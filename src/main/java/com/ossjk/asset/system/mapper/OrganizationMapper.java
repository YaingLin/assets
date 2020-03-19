package com.ossjk.asset.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ossjk.asset.system.entity.Organization;
import com.ossjk.asset.system.vo.OrganizationVo;

/**
 * <p>
  * 组织机构 Mapper 接口
 * </p>
 *
 * @author lym
 * @since 2020-01-09
 */
public interface OrganizationMapper extends BaseMapper<Organization> {

	List<OrganizationVo> selectOrg(Page page, @Param("ew") Wrapper wrapper);
}