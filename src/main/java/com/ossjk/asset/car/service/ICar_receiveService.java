package com.ossjk.asset.car.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.ossjk.asset.car.entity.Car_receive;
import com.ossjk.asset.car.vo.Car_receiveVo;

/**
 * <p>
 * 车辆领用表 服务类
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
public interface ICar_receiveService extends IService<Car_receive> {
	public Page selectCar_receiveVo(Page page, Wrapper wrapper);
}
