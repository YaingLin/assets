package com.ossjk.asset.device.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.ossjk.asset.device.entity.Device_repair;

/**
 * <p>
 * 设备维修表 服务类
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
public interface IDevice_repairService extends IService<Device_repair> {

	public Page selectDevice_repairVo(Page page, Wrapper wrapper);
}
