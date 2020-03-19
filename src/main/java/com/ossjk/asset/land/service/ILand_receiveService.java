package com.ossjk.asset.land.service;

import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.ossjk.asset.land.entity.Land_receive;
import com.ossjk.asset.land.vo.Land_receiveVo;

/**
 * <p>
 * 土地分配情况 服务类
 * </p>
 *
 * @author lym
 * @since 2020-01-12
 */
public interface ILand_receiveService extends IService<Land_receive> {
	
	public Page selectLand_receiveVo(Page page,Wrapper wrapper);
	
	public Land_receiveVo selectVoById(String id);
	
	public boolean insertVo(Land_receiveVo lrv);
	
	public boolean updateVoById(Land_receiveVo lrv,String olid);

	public boolean deleteBatchIdsAndReset(String[] id);
}
