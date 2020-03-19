package com.ossjk.asset.car.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ossjk.asset.car.entity.Car;
import com.ossjk.asset.car.mapper.CarMapper;
import com.ossjk.asset.car.service.ICarService;
import com.ossjk.asset.land.entity.Land;
import com.ossjk.asset.system.entity.Code_rule;
import com.ossjk.asset.system.service.ICode_ruleService;

/**
 * <p>
 * 车辆明细 服务实现类
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements ICarService {

	@Autowired
	private ICode_ruleService iCode_ruleService;

	@Transactional
	@Override
	public boolean insert(Car entity) {
		Wrapper wrapper = Condition.create().eq("name", "车辆流水");
		Code_rule one = iCode_ruleService.selectOne(wrapper);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
		String time = sdf.format(new Date());
		String year = time.substring(2, 4);
		String cur = (Integer.parseInt(one.getCurrent()) + 1) + "";
		for (int i = cur.length(); i < 4; i++) {
			cur = "0" + cur;
		}
		entity.setCode(one.getRule() + year + cur);
		one.setCurrent(cur);
		iCode_ruleService.updateById(one);
		entity.setCreatetime(time);
		
		return super.insert(entity);
	}

	public Page selectCarVo(Page page, Wrapper wrapper) {
		SqlHelper.fillWrapper(page, wrapper);
		page.setRecords(baseMapper.selectCarVo(page, wrapper));
		return page;
	}
}
