package com.ossjk.asset.book.service;

import com.ossjk.asset.book.entity.Furniture_book;
import com.ossjk.asset.book.vo.Furniture_bookVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 家具图书明细 服务类
 * </p>
 *
 * @author lxw
 * @since 2020-01-09
 */
@Service
public interface IFurniture_bookService extends IService<Furniture_book> {
	Page selectFurniture_bookVo(Page page,Wrapper wrapper);
	List<Furniture_book> selectAll();
}
