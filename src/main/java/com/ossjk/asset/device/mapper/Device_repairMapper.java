package com.ossjk.asset.device.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ossjk.asset.device.entity.Device_repair;
import com.ossjk.asset.device.vo.Device_repairVo;

/**
 * <p>
  * 设备维修表 Mapper 接口
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
public interface Device_repairMapper extends BaseMapper<Device_repair> {

	List<Device_repairVo> selectDevice_repairVo(Page page, @Param("ew") Wrapper wrapper);
}