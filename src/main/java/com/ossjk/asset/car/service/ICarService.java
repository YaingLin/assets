package com.ossjk.asset.car.service;

import com.ossjk.asset.car.entity.Car;
import com.ossjk.asset.car.vo.CarVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 车辆明细 服务类
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
public interface ICarService extends IService<Car> {

	public Page selectCarVo(Page page, Wrapper wrapper);
	
}
