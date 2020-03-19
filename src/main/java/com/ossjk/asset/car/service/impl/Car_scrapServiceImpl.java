package com.ossjk.asset.car.service.impl;

import com.ossjk.asset.car.entity.Car_scrap;
import com.ossjk.asset.car.mapper.Car_scrapMapper;
import com.ossjk.asset.car.service.ICar_scrapService;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车辆报废 服务实现类
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@Service
public class Car_scrapServiceImpl extends ServiceImpl<Car_scrapMapper, Car_scrap> implements ICar_scrapService {
	
	public Page selectCar_scrapVo(Page page, Wrapper wrapper) {
		SqlHelper.fillWrapper(page, wrapper);
		page.setRecords(baseMapper.selectCar_scrapVo(page, wrapper));
		return page;
	}
}
