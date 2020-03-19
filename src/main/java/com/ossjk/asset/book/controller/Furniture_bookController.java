package com.ossjk.asset.book.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ossjk.asset.base.controller.BaseController;
import com.ossjk.asset.book.entity.Furniture_book;
import com.ossjk.asset.book.service.IFurniture_bookService;
import com.ossjk.asset.book.service.IFurniture_books_typeService;
import com.ossjk.asset.common.util.CommonUtil;
import com.ossjk.asset.common.vo.DwzPageBean;
import com.ossjk.asset.system.entity.User;
import com.ossjk.asset.system.service.IUserService;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

/**
 * <p>
 * 家具图书明细 前端控制器
 * </p>
 *
 * @author lxw
 * @since 2020-01-09
 */
@Controller
@RequestMapping("/book/furniture_book")
public class Furniture_bookController extends BaseController{
	@Autowired
	private IFurniture_bookService bookService;
	@Autowired
	private IFurniture_books_typeService books_typeService;
	@RequestMapping("/list")
	public String list(String name, String code, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		dwzPageBean.getCountResultMap().put("name", name);
		dwzPageBean.getCountResultMap().put("code", code);
		Wrapper wrapper = Condition.create().isWhere(true).like("name", name).like("code", code);
		Page resultPage = bookService.selectFurniture_bookVo(dwzPageBean.toPage(), wrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "book/furniture_book/list";
	}

	@RequestMapping("/toInsert")
	public String toInsert(HttpServletRequest request, HttpServletResponse response,ModelMap map) {
		map.put("product_types", books_typeService.selectAll());
		return "book/furniture_book/edit";
	}

	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Furniture_book furniture_book , HttpServletRequest request, HttpServletResponse response) {
		Wrapper<Furniture_book> wrapper = Condition.create().eq("name", furniture_book.getName()).or().eq("code", furniture_book.getCode());
		Furniture_book user = bookService.selectOne(wrapper);
		if (!CommonUtil.isBlank(user)) {
			return ajaxError("姓名或流水号重复");
		}
		if (bookService.insert(furniture_book)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}

	}

	@RequestMapping("/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("product_types", books_typeService.selectAll());
		map.put("record", bookService.selectById(id));
		return "book/furniture_book/edit";
	}

	@RequestMapping("/update")
	@ResponseBody
	public Object update(Furniture_book furniture_book , HttpServletRequest request, HttpServletResponse response) {
		if (bookService.updateById(furniture_book)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (bookService.deleteBatchIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
}
