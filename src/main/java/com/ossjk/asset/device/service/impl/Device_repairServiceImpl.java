package com.ossjk.asset.device.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ossjk.asset.device.entity.Device_repair;
import com.ossjk.asset.device.mapper.Device_repairMapper;
import com.ossjk.asset.device.service.IDevice_repairService;

/**
 * <p>
 * 设备维修表 服务实现类
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@Service
public class Device_repairServiceImpl extends ServiceImpl<Device_repairMapper, Device_repair>
		implements IDevice_repairService {

	@Override
	public Page selectDevice_repairVo(Page page, Wrapper wrapper) {
		SqlHelper.fillWrapper(page, wrapper);
		wrapper.getSqlSegment();
		page.setRecords(baseMapper.selectDevice_repairVo(page, wrapper));
		return page;
	}

}
