package com.ossjk.asset.house.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.ossjk.asset.house.entity.House;

/**
 * <p>
 * 房屋明细 服务类
 * </p>
 *
 * @author lym
 * @since 2020-01-12
 */
public interface IHouseService extends IService<House> {
	
	public Page selectHouseVo(Page page, Wrapper wrapper);
}
