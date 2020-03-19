package com.ossjk.asset.book.service;

import com.ossjk.asset.book.entity.Furniture_books_type;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 家具图书类型 服务类
 * </p>
 *
 * @author lxw
 * @since 2020-01-09
 */
public interface IFurniture_books_typeService extends IService<Furniture_books_type> {
	List<Furniture_books_type> selectAll();
}
