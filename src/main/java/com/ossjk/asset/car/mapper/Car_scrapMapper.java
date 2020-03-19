package com.ossjk.asset.car.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ossjk.asset.car.entity.Car_scrap;
import com.ossjk.asset.car.vo.Car_scrapVo;

/**
 * <p>
  * 车辆报废 Mapper 接口
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
public interface Car_scrapMapper extends BaseMapper<Car_scrap> {

	List<Car_scrapVo> selectCar_scrapVo(Page page,@Param("ew") Wrapper wrapper);
}