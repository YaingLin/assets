package com.ossjk.asset.land.service.impl;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ossjk.asset.common.util.CommonUtil;
import com.ossjk.asset.land.entity.Land;
import com.ossjk.asset.land.entity.Land_receive;
import com.ossjk.asset.land.mapper.Land_receiveMapper;
import com.ossjk.asset.land.service.ILandService;
import com.ossjk.asset.land.service.ILand_receiveService;
import com.ossjk.asset.land.vo.Land_receiveVo;
import com.ossjk.asset.system.entity.Code_rule;
import com.ossjk.asset.system.service.ICode_ruleService;

/**
 * <p>
 * 土地分配情况 服务实现类
 * </p>
 *
 * @author lym
 * @since 2020-01-12
 */
@Service
public class Land_receiveServiceImpl extends ServiceImpl<Land_receiveMapper, Land_receive>
		implements ILand_receiveService {

	@Autowired
	private ILandService ils;
	@Autowired
	private ILand_receiveService ilrs;
	@Autowired
	private ICode_ruleService icrs;

	@Transactional
	@Override
	public boolean insert(Land_receive entity) {
		Wrapper wrapper = Condition.create().eq("name", "土地单据");
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
	public Page selectLand_receiveVo(Page page, Wrapper wrapper) {
		SqlHelper.fillWrapper(page, wrapper);
		page.setRecords(baseMapper.selectLand_receiveVo(page, wrapper));
		return page;
	}

	@Override
	public Land_receiveVo selectVoById(String id) {
		return baseMapper.selectVoById(id);
	}

	@Transactional
	@Override
	public boolean insertVo(Land_receiveVo lrv) {
		try {
			lrv.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
			String format = sdf.format(new Date());
			lrv.setMdtm(format);
			lrv.setCrtm(format);
			if (!ilrs.insert(lrv)) {
				new Exception();
			}
			Land l = new Land();
			l.setId(lrv.getLid());
			l.setStatus(1);
			l.setService_life(lrv.getService_life());
			if (!ils.updateById(l)) {
				new Exception();
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional
	@Override
	public boolean updateVoById(Land_receiveVo lrv, String olid) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
			lrv.setMdtm(sdf.format(new Date()));
			if (!ilrs.updateById(lrv)) {
				new Exception();
			}
			Land l = new Land();
			if (!olid.equals(lrv.getLid())) {
				Land selectById = ils.selectById(olid);
				selectById.setStatus(0);
				if (!ils.updateById(selectById)) {
					new Exception();
				}
			}
			l.setStatus(1);
			l.setId(lrv.getLid());
			l.setService_life(lrv.getService_life());
			if (!ils.updateById(l)) {
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
			for (String string : id) {
				Land selectById = ils.selectById(ilrs.selectById(string).getLid());
				selectById.setStatus(0);
				if (!ils.updateById(selectById)) {
					new Exception();
				}
			}
			if (!ilrs.deleteBatchIds(Arrays.asList(id))) {
				new Exception();
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
