package com.ossjk.asset.system.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.ossjk.asset.system.entity.User;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author chair
 * @since 2018-07-09
 */
public interface IUserService extends IService<User> {

	public Page selectUserVo(Page page, Wrapper wrapper);
}
