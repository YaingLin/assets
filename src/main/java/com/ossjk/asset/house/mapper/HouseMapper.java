package com.ossjk.asset.house.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ossjk.asset.house.entity.House;
import com.ossjk.asset.house.vo.HouseVo;

/**
 * <p>
  * 房屋明细 Mapper 接口
 * </p>
 *
 * @author lym
 * @since 2020-01-12
 */
public interface HouseMapper extends BaseMapper<House> {
	
	List<HouseVo> selectHouseVo(Page page,@Param("ew") Wrapper wrapper);
}