package com.ossjk.asset.device.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.ossjk.asset.device.entity.Device;

/**
 * <p>
 * 设备明细 服务类
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
public interface IDeviceService extends IService<Device> {

	public Page selectDeviceVo(Page page, Wrapper wrapper);

}
