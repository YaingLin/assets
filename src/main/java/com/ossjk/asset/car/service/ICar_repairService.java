package com.ossjk.asset.car.service;

import com.ossjk.asset.car.entity.Car_repair;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 车辆维修表 服务类
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
public interface ICar_repairService extends IService<Car_repair> {
	
	public Page selectCar_repairVo(Page page, Wrapper wrapper);
}
