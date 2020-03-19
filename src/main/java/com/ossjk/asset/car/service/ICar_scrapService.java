package com.ossjk.asset.car.service;

import com.ossjk.asset.car.entity.Car_scrap;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 车辆报废 服务类
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
public interface ICar_scrapService extends IService<Car_scrap> {
	
	public Page selectCar_scrapVo(Page page, Wrapper wrapper);
}
