package com.ossjk.asset.device.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.ossjk.asset.device.entity.Device_scrap;

/**
 * <p>
 * 设备报废 服务类
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
public interface IDevice_scrapService extends IService<Device_scrap> {

	public Page selectDevice_scrapVo(Page page, Wrapper wrapper);

}
