package com.ossjk.asset.device.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ossjk.asset.device.entity.Device;
import com.ossjk.asset.device.vo.DeviceVo;

/**
 * <p>
  * 设备明细 Mapper 接口
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
public interface DeviceMapper extends BaseMapper<Device> {

	List<DeviceVo> selectDeviceVo(Page page, @Param("ew") Wrapper wrapper);
}