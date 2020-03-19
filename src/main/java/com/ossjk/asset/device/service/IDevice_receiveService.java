package com.ossjk.asset.device.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.ossjk.asset.device.entity.Device_receive;

/**
 * <p>
 * 设备领用表 服务类
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
public interface IDevice_receiveService extends IService<Device_receive> {

	public Page selectDevice_receiveVo(Page page, Wrapper wrapper);

}
