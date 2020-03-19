package com.ossjk.asset.device.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ossjk.asset.device.entity.Device;
import com.ossjk.asset.device.mapper.DeviceMapper;
import com.ossjk.asset.device.service.IDeviceService;

/**
 * <p>
 * 设备明细 服务实现类
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements IDeviceService {

	@Override
	public Page selectDeviceVo(Page page, Wrapper wrapper) {
        SqlHelper.fillWrapper(page, wrapper);
        wrapper.getSqlSegment();
        page.setRecords(baseMapper.selectDeviceVo(page, wrapper));
        return page;
    }

}
