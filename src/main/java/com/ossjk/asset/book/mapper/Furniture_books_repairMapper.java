package com.ossjk.asset.book.mapper;

import com.ossjk.asset.book.entity.Furniture_books_repair;
import com.ossjk.asset.book.vo.Furniture_books_repairVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
  * 家具图书维修表 Mapper 接口
 * </p>
 *
 * @author lxw
 * @since 2020-01-09
 */
public interface Furniture_books_repairMapper extends BaseMapper<Furniture_books_repair> {
	List<Furniture_books_repairVo> selectFurniture_books_repairVo(Page page, @Param("ew") Wrapper wrapper);
}