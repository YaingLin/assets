package com.ossjk.asset.house.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ossjk.asset.house.entity.House_receive;
import com.ossjk.asset.house.vo.House_receiveVo;

/**
 * <p>
 * 房屋分配情况 Mapper 接口
 * </p>
 *
 * @author lym
 * @since 2020-01-12
 */
public interface House_receiveMapper extends BaseMapper<House_receive> {
	
	List<House_receiveVo> selectHouse_receiveVo(Page page, @Param("ew") Wrapper wrapper);

	House_receiveVo selectHouse_receiveVoById(String id);

}