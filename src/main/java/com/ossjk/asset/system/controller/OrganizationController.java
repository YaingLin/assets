package com.ossjk.asset.system.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.ossjk.asset.base.controller.BaseController;
import com.ossjk.asset.common.util.CommonUtil;
import com.ossjk.asset.common.vo.DwzPageBean;
import com.ossjk.asset.system.entity.Organization;
import com.ossjk.asset.system.service.IOrganizationService;

/**
 * <p>
 * 组织机构 前端控制器
 * </p>
 *
 * @author lym
 * @since 2020-01-09
 */
@Controller
@RequestMapping("/system/organization")
public class OrganizationController extends BaseController {

	@Autowired
	private IOrganizationService ios;

	@RequestMapping("/list")
	@RequiresPermissions("/system/organization/list")
	public String list(String name, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request,
			HttpServletResponse response) {
		map.put("name", name);
		Wrapper wrapper = Condition.create().like("name", name);
		List<Organization> list = ios.selectList(wrapper);
		List list2=new ArrayList();
		for (Organization organization : list) {
			Map map2=new HashMap();
			map2.put("id", organization.getId());
			map2.put("pId", organization.getPid());
			map2.put("name", organization.getName());
			map2.put("level",organization.getLevel());
			map2.put("open", true);
			list2.add(map2);
		}
		map.put("json", JSON.toJSONString(list2));
		return "system/organization/list";
	}

	@RequestMapping("/toInsert")
	@RequiresPermissions("/system/organization/toInsert")
	public String toInsert(ModelMap map,String pid,BigDecimal level, HttpServletRequest request, HttpServletResponse response) {
		map.put("pid",pid);
		map.put("level",level);
		return "system/organization/edit";
	}

	@RequestMapping("/insert")
	@RequiresPermissions("/system/organization/toInsert")
	@ResponseBody
	public Object insert(Organization org, HttpServletRequest request, HttpServletResponse response) {
		Wrapper<Organization> wrapper = Condition.create().eq("name", org.getName());
//		String time = (new Date()).toString();
//		org.setCrtm(time);
//		org.setMdtm(time);
		Organization organization = ios.selectOne(wrapper);
		if (!CommonUtil.isBlank(organization)) {
			return ajaxError("组织名称已存在。");
		} else if (ios.insert(org)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/toUpdate")
	@RequiresPermissions("/system/organization/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("record", ios.selectById(id));
		map.put("organization", ios.selectList(null));
		return "system/organization/edit";
	}

	@RequestMapping("/update")
	@RequiresPermissions("/system/organization/toUpdate")
	@ResponseBody
	public Object update(Organization org, HttpServletRequest request, HttpServletResponse response) {
//		org.setMdtm((new Date()).toString());
		if (ios.updateById(org)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@RequiresPermissions("/system/organization/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (ios.deleteBatchIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
	
	@RequestMapping("/toInsertRoot")
	@RequiresPermissions("/system/organization/toInsert")
	public String toParentInsert(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("pid", 0);
		map.put("level", 1);
		return "system/organization/edit";
	}

}
