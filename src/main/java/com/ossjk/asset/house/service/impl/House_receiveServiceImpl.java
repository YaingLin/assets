package com.ossjk.asset.house.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ossjk.asset.house.entity.House;
import com.ossjk.asset.house.entity.House_receive;
import com.ossjk.asset.house.mapper.House_receiveMapper;
import com.ossjk.asset.house.service.IHouseService;
import com.ossjk.asset.house.service.IHouse_receiveService;
import com.ossjk.asset.house.vo.House_receiveVo;
import com.ossjk.asset.land.entity.Land_receive;
import com.ossjk.asset.system.entity.Code_rule;
import com.ossjk.asset.system.service.ICode_ruleService;

/**
 * <p>
 * 房屋分配情况 服务实现类
 * </p>
 *
 * @author lym
 * @since 2020-01-12
 */
@Service
public class House_receiveServiceImpl extends ServiceImpl<House_receiveMapper, House_receive>
		implements IHouse_receiveService {

	@Autowired
	private IHouse_receiveService ihrs;
	@Autowired
	private IHouseService ihs;
	@Autowired
	private ICode_ruleService icrs;

	@Transactional
	@Override
	public boolean insert(House_receive entity) {
		Wrapper wrapper = Condition.create().eq("name", "房屋单据");
		Code_rule one = icrs.selectOne(wrapper);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String year = sdf.format(new Date()).substring(2);
		String cur = (Integer.parseInt(one.getCurrent()) + 1) + "";
		for (int i = cur.length(); i < 4; i++) {
			cur = "0" + cur;
		}
		entity.setReceipt(one.getRule() + year + cur);
		one.setCurrent(cur);
		icrs.updateById(one);
		return super.insert(entity);
	}
	@Override
	public Page selectHouse_receiveVo(Page page, Wrapper wrapper) {
		SqlHelper.fillWrapper(page, wrapper);
		page.setRecords(baseMapper.selectHouse_receiveVo(page, wrapper));
		return page;
	}

	@Override
	public House_receiveVo selectVoById(String id) {
		return baseMapper.selectHouse_receiveVoById(id);
	}

	@Override
	public boolean insertVo(House_receiveVo hrv) {
		try {
			hrv.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
			String format = dateFormat.format(new Date());
			hrv.setCrtm(format);
			hrv.setMdtm(format);
			if(!ihrs.insert(hrv)) {
				new Exception();
			}
			House h = new House();
			h.setId(hrv.getHid());
			h.setStatus(1);
			h.setService_life(hrv.getService_life());
			if(!ihs.updateById(h)) {
				new Exception();
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updateVoById(House_receiveVo hrv ,String ohid) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
			hrv.setMdtm(dateFormat.format(new Date()));
			if(!ihrs.updateById(hrv)) {
				new Exception();
			}
			if(!ohid.equals(hrv.getHid())) {
				House selectById = ihs.selectById(ohid);
				selectById.setStatus(0);
				if(!ihs.updateById(selectById)) {
					new Exception();
				}
			}
			House h = new House();
			h.setStatus(1);
			h.setId(hrv.getHid());
			h.setService_life(hrv.getService_life());
			if(!ihs.updateById(h)) {
				new Exception();
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteBatchIdsAndReset(String[] id) {
		try {
			List<House_receive> selectBatchIds = ihrs.selectBatchIds(Arrays.asList(id));
			List<String> hid=new ArrayList();
			for (House_receive house_receive : selectBatchIds) {
				hid.add(house_receive.getHid());
			}
			List<House> selectBatchIds2 = ihs.selectBatchIds(hid);
			for (House house : selectBatchIds2) {
				house.setStatus(0);
			}
			if(!ihs.updateBatchById(selectBatchIds2))
			{
				new Exception();
			}
//			for (String string : id) {
//				House selectById = ihs.selectById(ihrs.selectById(string).getHid());
//				selectById.setStatus(0);
//				if (!ihs.updateById(selectById)) {
//					new Exception();
//				}
//			}
			if (!ihrs.deleteBatchIds(Arrays.asList(id))) {
				new Exception();
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
