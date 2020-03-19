package com.ossjk.asset.system.service;

import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.ossjk.asset.system.entity.Organization;

/**
 * <p>
 * 组织机构 服务类
 * </p>
 *
 * @author lym
 * @since 2020-01-09
 */
public interface IOrganizationService extends IService<Organization> {

	public Page selectOrg(Page page, Wrapper wrapper);
}
