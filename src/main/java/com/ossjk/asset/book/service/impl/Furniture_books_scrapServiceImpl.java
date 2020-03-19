package com.ossjk.asset.book.service.impl;

import com.ossjk.asset.book.entity.Furniture_books_scrap;
import com.ossjk.asset.book.mapper.Furniture_books_scrapMapper;
import com.ossjk.asset.book.service.IFurniture_books_scrapService;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 家具图书报废 服务实现类
 * </p>
 *
 * @author lxw
 * @since 2020-01-09
 */
@Service
public class Furniture_books_scrapServiceImpl extends ServiceImpl<Furniture_books_scrapMapper, Furniture_books_scrap> implements IFurniture_books_scrapService {

	@Override
	public Page selectFurniture_books_scrapVo(Page page, Wrapper wrapper) {
		SqlHelper.fillWrapper(page, wrapper);

		System.out.println(wrapper.getSqlSelect());
		System.out.println(wrapper.getSqlSegment());

		page.setRecords(baseMapper.selectFurniture_books_scrapVo(page, wrapper));
		return page;
	}
	
}
