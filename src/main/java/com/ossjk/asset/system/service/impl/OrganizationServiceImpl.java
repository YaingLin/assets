package com.ossjk.asset.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ossjk.asset.system.entity.Organization;
import com.ossjk.asset.system.mapper.OrganizationMapper;
import com.ossjk.asset.system.service.IOrganizationService;

/**
 * <p>
 * 组织机构 服务实现类
 * </p>
 *
 * @author lym
 * @since 2020-01-09
 */
@Service
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization>
		implements IOrganizationService {
	
	public Page selectOrg(Page page, Wrapper wrapper) {
		SqlHelper.fillWrapper(page, wrapper);
		page.setRecords(baseMapper.selectOrg(page, wrapper));
		return page;
	}
}
