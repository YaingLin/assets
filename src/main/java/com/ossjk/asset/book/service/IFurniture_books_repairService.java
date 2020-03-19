package com.ossjk.asset.book.service;

import com.ossjk.asset.book.entity.Furniture_books_repair;
import com.ossjk.asset.book.vo.Furniture_books_repairVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 家具图书维修表 服务类
 * </p>
 *
 * @author lxw
 * @since 2020-01-09
 */
public interface IFurniture_books_repairService extends IService<Furniture_books_repair> {
	Page selectFurniture_books_repairVo(Page page,Wrapper wrapper);
}
