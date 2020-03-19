package com.ossjk.asset.car.service.impl;

import com.ossjk.asset.car.entity.Car_repair;
import com.ossjk.asset.car.mapper.Car_repairMapper;
import com.ossjk.asset.car.service.ICar_repairService;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车辆维修表 服务实现类
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@Service
public class Car_repairServiceImpl extends ServiceImpl<Car_repairMapper, Car_repair> implements ICar_repairService {

	public Page selectCar_repairVo(Page page, Wrapper wrapper) {
		SqlHelper.fillWrapper(page, wrapper);
		page.setRecords(baseMapper.selectCar_repairVo(page, wrapper));
		return page;
	}
}
