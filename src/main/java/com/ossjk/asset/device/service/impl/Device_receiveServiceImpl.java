package com.ossjk.asset.device.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ossjk.asset.device.entity.Device_receive;
import com.ossjk.asset.device.mapper.Device_receiveMapper;
import com.ossjk.asset.device.service.IDevice_receiveService;

/**
 * <p>
 * 设备领用表 服务实现类
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@Service
public class Device_receiveServiceImpl extends ServiceImpl<Device_receiveMapper, Device_receive>
		implements IDevice_receiveService {
	@Override
	public Page selectDevice_receiveVo(Page page, Wrapper wrapper) {
		SqlHelper.fillWrapper(page, wrapper);
		wrapper.getSqlSegment();
		page.setRecords(baseMapper.selectDevice_receiveVo(page, wrapper));
		return page;
	}
}
