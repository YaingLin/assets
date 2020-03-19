package com.ossjk.asset.system.service.impl;

import com.ossjk.asset.system.entity.User;
import com.ossjk.asset.system.mapper.UserMapper;
import com.ossjk.asset.system.service.IUserService;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author chair
 * @since 2018-07-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

	@Override
	public Page selectUserVo(Page page, Wrapper wrapper) {
		SqlHelper.fillWrapper(page, wrapper);
		page.setRecords(baseMapper.selectUserVo(page, wrapper));
		return page;
	}

}
