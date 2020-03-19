package com.ossjk.asset.house.service.impl;

import com.ossjk.asset.house.entity.House;
import com.ossjk.asset.house.mapper.HouseMapper;
import com.ossjk.asset.house.service.IHouseService;
import com.ossjk.asset.land.entity.Land;
import com.ossjk.asset.system.entity.Code_rule;
import com.ossjk.asset.system.service.ICode_ruleService;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 房屋明细 服务实现类
 * </p>
 *
 * @author lym
 * @since 2020-01-12
 */
@Service
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House> implements IHouseService {
	@Autowired
	private ICode_ruleService icrs;

	@Transactional
	@Override
	public boolean insert(House entity) {
		Wrapper wrapper = Condition.create().eq("name", "房屋流水");
		Code_rule one = icrs.selectOne(wrapper);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String year = sdf.format(new Date()).substring(2);
		String cur = (Integer.parseInt(one.getCurrent()) + 1) + "";
		for (int i = cur.length(); i < 4; i++) {
			cur = "0" + cur;
		}
		entity.setCode(one.getRule() + year + cur);
		one.setCurrent(cur);
		icrs.updateById(one);
		return super.insert(entity);
	}

	@Override
	public Page selectHouseVo(Page page, Wrapper wrapper) {
		SqlHelper.fillWrapper(page, wrapper);
		page.setRecords(baseMapper.selectHouseVo(page, wrapper));
		return page;
	}
}
