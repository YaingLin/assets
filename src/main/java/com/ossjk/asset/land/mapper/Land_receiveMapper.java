package com.ossjk.asset.land.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ossjk.asset.land.entity.Land_receive;
import com.ossjk.asset.land.vo.Land_receiveVo;

/**
 * <p>
  * 土地分配情况 Mapper 接口
 * </p>
 *
 * @author lym
 * @since 2020-01-12
 */
public interface Land_receiveMapper extends BaseMapper<Land_receive> {
	
	List<Land_receiveVo> selectLand_receiveVo(Page page,@Param("ew") Wrapper wrapper);
	
	Land_receiveVo selectVoById(String id);
	
	int insertVo(Land_receiveVo lrv);
	
	int updateVoById(Land_receiveVo lrv);
}