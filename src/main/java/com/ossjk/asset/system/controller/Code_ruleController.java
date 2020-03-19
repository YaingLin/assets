package com.ossjk.asset.system.controller;


import java.util.Arrays;

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
import com.ossjk.asset.system.entity.Code_rule;
import com.ossjk.asset.system.service.ICode_ruleService;

/**
 * <p>
 * 流水号规则表 前端控制器
 * </p>
 *
 * @author lym
 * @since 2020-01-09
 */
@Controller
@RequestMapping("/system/code_rule")
public class Code_ruleController extends BaseController{

	@Autowired
	private ICode_ruleService icrs;
	
	@RequestMapping("/list")
	@RequiresPermissions("/system/code_rule/list")
	public String list(String name, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("name", name);
		Wrapper wrapper = Condition.create().like("name", name);
		Page resultPage = icrs.selectPage(dwzPageBean.toPage(), wrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "system/code_rule/list";
	}

	@RequestMapping("/toInsert")
	@RequiresPermissions("/system/code_rule/toInsert")
	public String toInsert(HttpServletRequest request, HttpServletResponse response) {
		return "system/code_rule/edit";
	}
	
	@RequestMapping("/insert")
	@RequiresPermissions("/system/code_rule/toInsert")
	@ResponseBody
	public Object insert(Code_rule cr, HttpServletRequest request, HttpServletResponse response) {
		Wrapper<Code_rule> wrapper = Condition.create().eq("name", cr.getName());
//		String time=(new Date()).toString();
//		cr.setCrtm(time);
//		cr.setMdtm(time);
		Code_rule code_rule=icrs.selectOne(wrapper);
		if(!CommonUtil.isBlank(code_rule)) {
			return ajaxError("权限名称已存在。");
		}else if(icrs.insert(cr)){
			return ajaxSuccess();
		}else {
			return ajaxError();
		}
	}
	
	@RequestMapping("/toUpdate")
	@RequiresPermissions("/system/code_rule/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("record", icrs.selectById(id));
		return "system/code_rule/edit";
	}
	
	@RequestMapping("/update")
	@RequiresPermissions("/system/code_rule/toUpdate")
	@ResponseBody
	public Object update(Code_rule cr, HttpServletRequest request, HttpServletResponse response) {
//		cr.setMdtm((new Date()).toString());
		if (icrs.updateById(cr)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@RequiresPermissions("/system/code_rule/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (icrs.deleteBatchIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

}
