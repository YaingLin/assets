package com.ossjk.asset.book.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ossjk.asset.base.controller.BaseController;
import com.ossjk.asset.book.entity.Furniture_books_receive;
import com.ossjk.asset.book.entity.Furniture_books_repair;
import com.ossjk.asset.book.service.IFurniture_bookService;
import com.ossjk.asset.book.service.IFurniture_books_receiveService;
import com.ossjk.asset.book.service.IFurniture_books_repairService;
import com.ossjk.asset.common.util.CommonUtil;
import com.ossjk.asset.common.vo.DwzPageBean;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

/**
 * <p>
 * 家具图书维修表 前端控制器
 * </p>
 *
 * @author lxw
 * @since 2020-01-09
 */
@Controller
@RequestMapping("/book/furniture_books_repair")
public class Furniture_books_repairController extends BaseController{
	@Autowired
	private IFurniture_books_repairService iFurniture_books_repairService;
	@Autowired
	private IFurniture_bookService furniture_bookService;
	@RequestMapping("/list")
	public String list(String damager, String code, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		dwzPageBean.getCountResultMap().put("damager", damager);
		
		Wrapper wrapper = Condition.create().isWhere(true).like("damager", damager);
		Page resultPage = iFurniture_books_repairService.selectFurniture_books_repairVo(dwzPageBean.toPage(), wrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "/book/furniture_books_repair/list";
	}

	@RequestMapping("/toInsert")
	public String toInsert(HttpServletRequest request, HttpServletResponse response,ModelMap map) {
		map.put("product_types", furniture_bookService.selectAll());
		return "/book/furniture_books_repair/edit";
	}

	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Furniture_books_repair furniture_books_repair , HttpServletRequest request, HttpServletResponse response) {
		
		if (iFurniture_books_repairService.insert(furniture_books_repair)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}

	}

	@RequestMapping("/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("product_types", furniture_bookService.selectAll());
		map.put("record", iFurniture_books_repairService.selectById(id));
		return "/book/furniture_books_repair/edit";
	}

	@RequestMapping("/update")
	@ResponseBody
	public Object update(Furniture_books_repair furniture_books_repair , HttpServletRequest request, HttpServletResponse response) {
		if (iFurniture_books_repairService.updateById(furniture_books_repair)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (iFurniture_books_repairService.deleteBatchIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
}
