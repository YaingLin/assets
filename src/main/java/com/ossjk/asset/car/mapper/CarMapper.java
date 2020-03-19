package com.ossjk.asset.car.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ossjk.asset.car.entity.Car;
import com.ossjk.asset.car.vo.CarVo;

/**
 * <p>
 * 车辆明细 Mapper 接口
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
public interface CarMapper extends BaseMapper<Car> {

	List<CarVo> selectCarVo(Page page,@Param("ew") Wrapper wrapper);
}