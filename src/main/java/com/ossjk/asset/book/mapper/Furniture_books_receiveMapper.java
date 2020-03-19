package com.ossjk.asset.book.mapper;

import com.ossjk.asset.book.entity.Furniture_books_receive;
import com.ossjk.asset.book.vo.Furniture_books_receiveVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
  * 家具图书领用表 Mapper 接口
 * </p>
 *
 * @author lxw
 * @since 2020-01-09
 */
public interface Furniture_books_receiveMapper extends BaseMapper<Furniture_books_receive> {
	List<Furniture_books_receiveVo> selectFurniture_books_receiveVo(Page page, @Param("ew") Wrapper wrapper);
}