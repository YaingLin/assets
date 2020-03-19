package com.ossjk.asset.device.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ossjk.asset.device.entity.Device_receive;
import com.ossjk.asset.device.vo.Device_receiveVo;

/**
 * <p>
  * 设备领用表 Mapper 接口
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
public interface Device_receiveMapper extends BaseMapper<Device_receive> {

	List<Device_receiveVo> selectDevice_receiveVo(Page page, @Param("ew") Wrapper wrapper);
}