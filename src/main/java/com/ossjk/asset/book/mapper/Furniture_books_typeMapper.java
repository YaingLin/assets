package com.ossjk.asset.book.mapper;

import com.ossjk.asset.book.entity.Furniture_books_type;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 家具图书类型 Mapper 接口
 * </p>
 *
 * @author lxw
 * @since 2020-01-09
 */
public interface Furniture_books_typeMapper extends BaseMapper<Furniture_books_type> {
	List<Furniture_books_type> selectAll();
}