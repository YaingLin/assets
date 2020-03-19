package com.ossjk.asset.car.mapper;

import com.ossjk.asset.car.entity.Car_repair;
import com.ossjk.asset.car.vo.CarVo;
import com.ossjk.asset.car.vo.Car_repairVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
  * 车辆维修表 Mapper 接口
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
public interface Car_repairMapper extends BaseMapper<Car_repair> {

	List<Car_repairVo> selectCar_repairVo(Page page,@Param("ew") Wrapper wrapper);
}