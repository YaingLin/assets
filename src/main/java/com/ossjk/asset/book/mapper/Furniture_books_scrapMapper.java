package com.ossjk.asset.book.mapper;

import com.ossjk.asset.book.entity.Furniture_books_scrap;
import com.ossjk.asset.book.vo.Furniture_books_scrapVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
  * 家具图书报废 Mapper 接口
 * </p>
 *
 * @author lxw
 * @since 2020-01-09
 */
public interface Furniture_books_scrapMapper extends BaseMapper<Furniture_books_scrap> {
	List<Furniture_books_scrapVo> selectFurniture_books_scrapVo(Page page, @Param("ew") Wrapper wrapper);
}