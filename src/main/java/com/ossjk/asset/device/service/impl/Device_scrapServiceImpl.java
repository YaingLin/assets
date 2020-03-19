package com.ossjk.asset.device.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ossjk.asset.device.entity.Device_scrap;
import com.ossjk.asset.device.mapper.Device_scrapMapper;
import com.ossjk.asset.device.service.IDevice_scrapService;

/**
 * <p>
 * 设备报废 服务实现类
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@Service
public class Device_scrapServiceImpl extends ServiceImpl<Device_scrapMapper, Device_scrap>
		implements IDevice_scrapService {

	@Override
	public Page selectDevice_scrapVo(Page page, Wrapper wrapper) {
		SqlHelper.fillWrapper(page, wrapper);
		wrapper.getSqlSegment();
		page.setRecords(baseMapper.selectDevice_scrapVo(page, wrapper));
		return page;
	}

}
