package com.ossjk.asset.house.service;

import com.ossjk.asset.house.entity.House_receive;
import com.ossjk.asset.house.vo.House_receiveVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 房屋分配情况 服务类
 * </p>
 *
 * @author lym
 * @since 2020-01-12
 */
public interface IHouse_receiveService extends IService<House_receive> {
	
	Page selectHouse_receiveVo(Page page, Wrapper wrapper);

	House_receiveVo selectVoById(String id);
	
	public boolean insertVo(House_receiveVo hrv);
	
	public boolean updateVoById(House_receiveVo hrv,String ohid);
	
	public boolean deleteBatchIdsAndReset(String[] id);
}
