package com.ossjk.asset.book.service;

import com.ossjk.asset.book.entity.Furniture_books_scrap;
import com.ossjk.asset.book.vo.Furniture_books_scrapVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 家具图书报废 服务类
 * </p>
 *
 * @author lxw
 * @since 2020-01-09
 */
public interface IFurniture_books_scrapService extends IService<Furniture_books_scrap> {
	Page selectFurniture_books_scrapVo(Page page,Wrapper wrapper);
}
