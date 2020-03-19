package com.ossjk.asset.book.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ossjk.asset.base.controller.BaseController;
import com.ossjk.asset.book.entity.Furniture_books_scrap;
import com.ossjk.asset.book.entity.Furniture_books_type;
import com.ossjk.asset.book.service.IFurniture_books_scrapService;
import com.ossjk.asset.book.service.IFurniture_books_typeService;
import com.ossjk.asset.common.vo.DwzPageBean;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

/**
 * <p>
 * 家具图书类型 前端控制器
 * </p>
 *
 * @author lxw
 * @since 2020-01-09
 */
@Controller
@RequestMapping("/book/furniture_books_type")
public class Furniture_books_typeController extends BaseController{
	@Autowired
	private IFurniture_books_typeService iFurniture_books_typeService;

	@RequestMapping("/list")
	public String list(String name, String code, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		dwzPageBean.getCountResultMap().put("name", name);
		
		Wrapper wrapper = Condition.create().like("name", name);
		Page resultPage = iFurniture_books_typeService.selectPage(dwzPageBean.toPage(), wrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "/book/furniture_books_type/list";
	}

	@RequestMapping("/toInsert")
	public String toInsert(HttpServletRequest request, HttpServletResponse response) {
		return "/book/furniture_books_type/edit";
	}

	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Furniture_books_type furniture_books_type , HttpServletRequest request, HttpServletResponse response) {
		
		if (iFurniture_books_typeService.insert(furniture_books_type)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}

	}

	@RequestMapping("/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("record", iFurniture_books_typeService.selectById(id));
		return "/book/furniture_books_type/edit";
	}

	@RequestMapping("/update")
	@ResponseBody
	public Object update(Furniture_books_type furniture_books_type , HttpServletRequest request, HttpServletResponse response) {
		if (iFurniture_books_typeService.updateById(furniture_books_type)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (iFurniture_books_typeService.deleteBatchIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
}
