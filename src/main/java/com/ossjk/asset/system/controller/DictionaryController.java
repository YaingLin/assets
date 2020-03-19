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
import com.ossjk.asset.system.entity.Dictionary;
import com.ossjk.asset.system.service.IDictionaryService;

/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author lym
 * @since 2020-01-09
 */
@Controller
@RequestMapping("/system/dictionary")
public class DictionaryController extends BaseController {

	@Autowired
	private IDictionaryService ids;
	
	@RequestMapping("/list")
	@RequiresPermissions("/system/dictionary/list")
	public String list(String dkey, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("dkey", dkey);
		Wrapper wrapper = Condition.create().like("dkey", dkey);
		Page resultPage = ids.selectPage(dwzPageBean.toPage(), wrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "system/dictionary/list";
	}
	@RequestMapping("/toInsert")
	@RequiresPermissions("/system/dictionary/toInsert")
	public String toInsert(HttpServletRequest request, HttpServletResponse response) {
		return "system/dictionary/edit";
	}
	
	@RequestMapping("/insert")
	@RequiresPermissions("/system/dictionary/toInsert")
	@ResponseBody
	public Object insert(Dictionary dict, HttpServletRequest request, HttpServletResponse response) {
		Wrapper<Dictionary> wrapper = Condition.create().eq("dkey", dict.getDkey());
//		String time=(new Date()).toString();
//		dict.setCrtm(time);
//		dict.setMdtm(time);
		Dictionary dictionary=ids.selectOne(wrapper);
		if(!CommonUtil.isBlank(dictionary)) {
			return ajaxError("主键名称已存在");
		}else if(ids.insert(dict)){
			return ajaxSuccess();
		}else {
			return ajaxError();
		}
	}
	
	@RequestMapping("/toUpdate")
	@RequiresPermissions("/system/dictionary/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("record", ids.selectById(id));
		return "system/dictionary/edit";
	}
	
	@RequestMapping("/update")
	@RequiresPermissions("/system/dictionary/toUpdate")
	@ResponseBody
	public Object update(Dictionary dict, HttpServletRequest request, HttpServletResponse response) {
//		dict.setMdtm((new Date()).toString());
		if (ids.updateById(dict)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@RequiresPermissions("/system/dictionary/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (ids.deleteBatchIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

}
