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
import com.ossjk.asset.car.entity.Car_receive;
import com.ossjk.asset.car.mapper.Car_receiveMapper;
import com.ossjk.asset.car.service.ICar_receiveService;
import com.ossjk.asset.system.entity.Code_rule;
import com.ossjk.asset.system.service.ICode_ruleService;

/**
 * <p>
 * 车辆领用表 服务实现类
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@Service
public class Car_receiveServiceImpl extends ServiceImpl<Car_receiveMapper, Car_receive> implements ICar_receiveService {

	@Autowired
	private ICode_ruleService iCode_ruleService;

	@Transactional
	@Override
	public boolean insert(Car_receive entity) {
		Wrapper wrapper = Condition.create().eq("name", "车辆单据");
		Code_rule one = iCode_ruleService.selectOne(wrapper);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
		String time = sdf.format(new Date());
		String year = time.substring(2, 4);
		String cur = (Integer.parseInt(one.getCurrent()) + 1) + "";
		for (int i = cur.length(); i < 4; i++) {
			cur = "0" + cur;
		}
		entity.setReceipt(one.getRule() + year + cur);
		one.setCurrent(cur);
		iCode_ruleService.updateById(one);

		return super.insert(entity);
	}

	public Page selectCar_receiveVo(Page page, Wrapper wrapper) {
		SqlHelper.fillWrapper(page, wrapper);
		page.setRecords(baseMapper.selectCar_receiveVo(page, wrapper));
		return page;
	}

	
}
