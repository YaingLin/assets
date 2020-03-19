package com.ossjk.asset.book.service.impl;

import com.ossjk.asset.book.entity.Furniture_books_type;
import com.ossjk.asset.book.mapper.Furniture_bookMapper;
import com.ossjk.asset.book.mapper.Furniture_books_scrapMapper;
import com.ossjk.asset.book.mapper.Furniture_books_typeMapper;
import com.ossjk.asset.book.service.IFurniture_books_typeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 家具图书类型 服务实现类
 * </p>
 *
 * @author lxw
 * @since 2020-01-09
 */
@Service
public class Furniture_books_typeServiceImpl extends ServiceImpl<Furniture_books_typeMapper, Furniture_books_type> implements IFurniture_books_typeService {
	@Autowired
	private Furniture_books_typeMapper books_typeMapper;
	@Override
	public List<Furniture_books_type> selectAll() {
		
		return books_typeMapper.selectAll();
	}
	
}
