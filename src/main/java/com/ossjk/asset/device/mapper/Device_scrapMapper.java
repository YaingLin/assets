package com.ossjk.asset.device.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ossjk.asset.device.entity.Device_scrap;

/**
 * <p>
  * 设备报废 Mapper 接口
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
public interface Device_scrapMapper extends BaseMapper<Device_scrap> {

	List<Device_scrap> selectDevice_scrapVo(Page page, @Param("ew") Wrapper wrapper);
}