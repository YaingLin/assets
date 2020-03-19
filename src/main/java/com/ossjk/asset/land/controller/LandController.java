package com.ossjk.asset.land.controller;


import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ossjk.asset.base.controller.BaseController;
import com.ossjk.asset.common.util.CommonUtil;
import com.ossjk.asset.common.vo.DwzPageBean;
import com.ossjk.asset.land.entity.Land;
import com.ossjk.asset.land.service.ILandService;

/**
 * <p>
 * 土地明细 前端控制器
 * </p>
 *
 * @author lym
 * @since 2020-01-12
 */
@Controller
@RequestMapping("/land/land")
public class LandController extends BaseController {
	@Autowired
	private ILandService ils;
	
	@RequestMapping("/list")
	@RequiresPermissions("/land/land/list")
	public String list(String address, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("address", address);
		Wrapper wrapper = Condition.create().like("address", address);
		Page resultPage = ils.selectPage(dwzPageBean.toPage(), wrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "land/land/list";
	}

	@RequestMapping("/toInsert")
	@RequiresPermissions("/land/land/toInsert")
	public String toInsert(HttpServletRequest request, HttpServletResponse response) {
		return "land/land/edit";
	}
	
	@RequestMapping("/insert")
	@RequiresPermissions("/land/land/toInsert")
	@ResponseBody
	public Object insert(Land l, HttpServletRequest request, HttpServletResponse response) {
		Wrapper<Land> wrapper = Condition.create().eq("address", l.getAddress());
		Land land=ils.selectOne(wrapper);
		if(!CommonUtil.isBlank(land)) {
			return ajaxError("区域信息已在库中存在。");
		}else if(ils.insert(l)){
			return ajaxSuccess();
		}else {
			return ajaxError();
		}
	}
	
	@RequestMapping("/toUpdate")
	@RequiresPermissions("/land/land/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("record", ils.selectById(id));
		return "land/land/edit";
	}
	
	@RequestMapping("/update")
	@RequiresPermissions("/land/land/list")
	@ResponseBody
	public Object update(Land l, HttpServletRequest request, HttpServletResponse response) {
		if (ils.updateById(l)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@RequiresPermissions("/land/land/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (ils.deleteBatchIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
}
