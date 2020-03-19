package com.ossjk.asset.book.service.impl;

import com.ossjk.asset.book.entity.Furniture_books_repair;
import com.ossjk.asset.book.mapper.Furniture_books_repairMapper;
import com.ossjk.asset.book.service.IFurniture_books_repairService;
import com.ossjk.asset.book.vo.Furniture_books_repairVo;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 家具图书维修表 服务实现类
 * </p>
 *
 * @author lxw
 * @since 2020-01-09
 */
@Service
public class Furniture_books_repairServiceImpl extends ServiceImpl<Furniture_books_repairMapper, Furniture_books_repair> implements IFurniture_books_repairService {

	@Override
	public Page selectFurniture_books_repairVo(Page page, Wrapper wrapper) {
		SqlHelper.fillWrapper(page, wrapper);

		System.out.println(wrapper.getSqlSelect());
		System.out.println(wrapper.getSqlSegment());

		page.setRecords(baseMapper.selectFurniture_books_repairVo(page, wrapper));
		return page;
	}
	
}
