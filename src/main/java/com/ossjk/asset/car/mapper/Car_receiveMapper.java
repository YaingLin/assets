package com.ossjk.asset.car.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ossjk.asset.car.entity.Car_receive;
import com.ossjk.asset.car.vo.Car_receiveVo;

/**
 * <p>
  * 车辆领用表 Mapper 接口
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
public interface Car_receiveMapper extends BaseMapper<Car_receive> {
	
	List<Car_receiveVo> selectCar_receiveVo(Page page,@Param("ew") Wrapper wrapper);
}