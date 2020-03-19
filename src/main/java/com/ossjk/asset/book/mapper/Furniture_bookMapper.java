package com.ossjk.asset.book.mapper;

import com.ossjk.asset.book.entity.Furniture_book;
import com.ossjk.asset.book.vo.Furniture_bookVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
  * 家具图书明细 Mapper 接口
 * </p>
 *
 * @author lxw
 * @since 2020-01-09
 */
public interface Furniture_bookMapper extends BaseMapper<Furniture_book> {
	List<Furniture_bookVo> selectFurniture_bookVo(Page page, @Param("ew") Wrapper wrapper);
	List<Furniture_book> selectAll();
}