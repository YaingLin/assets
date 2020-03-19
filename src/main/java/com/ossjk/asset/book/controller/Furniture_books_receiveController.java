package com.ossjk.asset.book.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ossjk.asset.base.controller.BaseController;
import com.ossjk.asset.book.entity.Furniture_book;
import com.ossjk.asset.book.entity.Furniture_books_receive;
import com.ossjk.asset.book.service.IFurniture_bookService;
import com.ossjk.asset.book.service.IFurniture_books_receiveService;
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
 * 家具图书领用表 前端控制器
 * </p>
 *
 * @author lxw
 * @since 2020-01-09
 */
@Controller
@RequestMapping("/book/furniture_books_receive")
public class Furniture_books_receiveController extends BaseController{
	@Autowired
	private IFurniture_books_receiveService iFurniture_books_receiveService;
	@Autowired
	private IFurniture_bookService furniture_bookService;
	@RequestMapping("/list")
	public String list(String receipt, String code, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		dwzPageBean.getCountResultMap().put("receipt", receipt);
		
		Wrapper wrapper = Condition.create().isWhere(true).like("receipt", receipt);
		Page resultPage = iFurniture_books_receiveService.selectFurniture_books_receiveVo(dwzPageBean.toPage(), wrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "/book/furniture_books_receive/list";
	}

	@RequestMapping("/toInsert")
	public String toInsert(HttpServletRequest request, HttpServletResponse response,ModelMap map) {
		map.put("product_types", furniture_bookService.selectAll());
		return "/book/furniture_books_receive/edit";
	}

	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Furniture_books_receive furniture_books_receive , HttpServletRequest request, HttpServletResponse response) {
		Wrapper<Furniture_books_receive> wrapper = Condition.create().eq("receipt", furniture_books_receive.getReceipt());
		Furniture_books_receive user = iFurniture_books_receiveService.selectOne(wrapper);
		if (!CommonUtil.isBlank(user)) {
			return ajaxError("重复");
		}
		if (iFurniture_books_receiveService.insert(furniture_books_receive)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}

	}

	@RequestMapping("/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("product_types", furniture_bookService.selectAll());
		map.put("record", iFurniture_books_receiveService.selectById(id));
		return "/book/furniture_books_receive/edit";
	}

	@RequestMapping("/update")
	@ResponseBody
	public Object update(Furniture_books_receive furniture_books_receive , HttpServletRequest request, HttpServletResponse response) {
		if (iFurniture_books_receiveService.updateById(furniture_books_receive)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (iFurniture_books_receiveService.deleteBatchIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
}
