package com.ossjk.asset.book.service.impl;

import com.ossjk.asset.book.entity.Furniture_book;
import com.ossjk.asset.book.mapper.Furniture_bookMapper;
import com.ossjk.asset.book.service.IFurniture_bookService;
import com.ossjk.asset.book.vo.Furniture_bookVo;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 家具图书明细 服务实现类
 * </p>
 *
 * @author lxw
 * @since 2020-01-09
 */
@Service
public class Furniture_bookServiceImpl extends ServiceImpl<Furniture_bookMapper, Furniture_book> implements IFurniture_bookService {
	@Autowired
	private Furniture_bookMapper bookMapper;
	@Override
	public Page selectFurniture_bookVo(Page page, Wrapper wrapper) {
		SqlHelper.fillWrapper(page, wrapper);

		System.out.println(wrapper.getSqlSelect());
		System.out.println(wrapper.getSqlSegment());

		page.setRecords(baseMapper.selectFurniture_bookVo(page, wrapper));
		return page;
	}

	@Override
	public List<Furniture_book> selectAll() {
		// TODO Auto-generated method stub
		return bookMapper.selectAll();
	}
	
}
