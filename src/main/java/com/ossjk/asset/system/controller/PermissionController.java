package com.ossjk.asset.system.controller;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.velocity.runtime.directive.Foreach;
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
import com.ossjk.asset.system.entity.Permission;
import com.ossjk.asset.system.service.IPermissionService;

/**
 * <p>
 * 权限 前端控制器
 * </p>
 *
 * @author lym
 * @since 2020-01-09
 */
@Controller
@RequestMapping("/system/permission")
public class PermissionController extends BaseController {

	@Autowired
	private IPermissionService ips;
	
	@RequestMapping("/list")
	@RequiresPermissions("/system/permission/list")
	public String list(String name, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("name", name);
		Wrapper wrapper = Condition.create().like("name", name);
		List<Permission> list = ips.selectList(wrapper);
		List list2=new ArrayList();
		for (Permission permission : list) {
			Map map2=new HashMap();
			map2.put("id", permission.getId());
			map2.put("pId", permission.getPid());
			map2.put("name", permission.getName());
			map2.put("open",true);
			list2.add(map2);
		}
		map.put("json", JSON.toJSONString(list2));
		return "system/permission/list";
	}

	@RequestMapping("/toInsert")
	@RequiresPermissions("/system/permission/toInsert")
	public String toInsert(ModelMap map,String pid,BigDecimal level,HttpServletRequest request, HttpServletResponse response) {
		map.put("pid",pid);
		map.put("level",level.doubleValue()+1);
		map.put("permission", ips.selectList(null));
		return "system/permission/edit";
	}
	
	@RequestMapping("/insert")
	@RequiresPermissions("/system/permission/toInsert")
	@ResponseBody
	public Object insert(Permission per, HttpServletRequest request, HttpServletResponse response) {
//		Wrapper<Permission> wrapper = Condition.create().eq("name", per.getName());
//		Permission permission=ips.selectOne(wrapper);
//		if(!CommonUtil.isBlank(permission)) {
//			return ajaxError("权限名称已存在。");
//		}else 
		if(ips.insert(per)){
			return ajaxSuccess();
		}else {
			return ajaxError();
		}
	}
	
	@RequestMapping("/toUpdate")
	@RequiresPermissions("/system/permission/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(id);
		map.put("record", ips.selectById(id));
		map.put("permission", ips.selectList(null));
		return "system/permission/edit";
	}
	
	@RequestMapping("/update")
	@RequiresPermissions("/system/permission/toUpdate")
	@ResponseBody
	public Object update(Permission per, HttpServletRequest request, HttpServletResponse response) {
		per.setMdtm(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS").format(new Date()));
		if (ips.updateById(per)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@RequiresPermissions("/system/permission/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (ips.deleteBatchIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
	@RequestMapping("/toInsertRoot")
	@RequiresPermissions("/system/permission/toInsert")
	public String toParentInsert(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("pid", 0);
		map.put("level", 1);
		return "system/permission/edit";
	}

}
