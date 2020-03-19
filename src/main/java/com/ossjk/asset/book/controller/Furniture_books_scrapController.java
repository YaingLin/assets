package com.ossjk.asset.book.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ossjk.asset.base.controller.BaseController;
import com.ossjk.asset.book.entity.Furniture_books_repair;
import com.ossjk.asset.book.entity.Furniture_books_scrap;
import com.ossjk.asset.book.service.IFurniture_bookService;
import com.ossjk.asset.book.service.IFurniture_books_repairService;
import com.ossjk.asset.book.service.IFurniture_books_scrapService;
import com.ossjk.asset.common.vo.DwzPageBean;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

/**
 * <p>
 * 家具图书报废 前端控制器
 * </p>
 *
 * @author lxw
 * @since 2020-01-09
 */
@Controller
@RequestMapping("/book/furniture_books_scrap")
public class Furniture_books_scrapController extends BaseController{
	@Autowired
	private IFurniture_books_scrapService furniture_books_scrapService;
	@Autowired
	private IFurniture_bookService furniture_bookService;
	@RequestMapping("/list")
	public String list(String scraper, String code, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		dwzPageBean.getCountResultMap().put("scraper", scraper);
		
		Wrapper wrapper = Condition.create().isWhere(true).like("scraper", scraper);
		Page resultPage = furniture_books_scrapService.selectFurniture_books_scrapVo(dwzPageBean.toPage(), wrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "/book/furniture_books_scrap/list";
	}

	@RequestMapping("/toInsert")
	public String toInsert(HttpServletRequest request, HttpServletResponse response,ModelMap map) {
		
		map.put("product_types", furniture_bookService.selectAll());
		return "/book/furniture_books_scrap/edit";
	}

	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Furniture_books_scrap furniture_books_scrap , HttpServletRequest request, HttpServletResponse response) {
		
		if (furniture_books_scrapService.insert(furniture_books_scrap)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}

	}

	@RequestMapping("/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		
		map.put("product_types", furniture_bookService.selectAll());
		map.put("record", furniture_books_scrapService.selectById(id));
		return "/book/furniture_books_scrap/edit";
	}

	@RequestMapping("/update")
	@ResponseBody
	public Object update(Furniture_books_scrap furniture_books_scrap , HttpServletRequest request, HttpServletResponse response) {
		if (furniture_books_scrapService.updateById(furniture_books_scrap)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (furniture_books_scrapService.deleteBatchIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
}
