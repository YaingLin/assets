package com.ossjk.asset.system.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import com.baomidou.mybatisplus.plugins.Page;
import com.ossjk.asset.base.controller.BaseController;
import com.ossjk.asset.common.util.CommonUtil;
import com.ossjk.asset.common.vo.DwzPageBean;
import com.ossjk.asset.common.vo.ZtreeBean;
import com.ossjk.asset.system.entity.Permission;
import com.ossjk.asset.system.entity.Role;
import com.ossjk.asset.system.entity.Role_permission;
import com.ossjk.asset.system.service.IPermissionService;
import com.ossjk.asset.system.service.IRoleService;
import com.ossjk.asset.system.service.IRole_permissionService;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author lym
 * @since 2020-01-09
 */
@Controller
@RequestMapping("/system/role")
public class RoleController extends BaseController {
	@Autowired
	private IRoleService irs;
	@Autowired
	private IPermissionService ips;
	@Autowired
	private IRole_permissionService irps;

	@RequestMapping("/list")
	@RequiresPermissions("/system/role/list")
	public String list(String name, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request,
			HttpServletResponse response) {
		map.put("name", name);
		Wrapper wrapper = Condition.create().like("name", name).orderBy("crtm desc");
		Page resultPage = irs.selectPage(dwzPageBean.toPage(), wrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "system/role/list";
	}

	@RequestMapping("/toInsert")
	@RequiresPermissions("/system/role/toInsert")
	public String toInsert(HttpServletRequest request, HttpServletResponse response) {
		return "system/role/edit";
	}

	@RequestMapping("/insert")
	@RequiresPermissions("/system/role/toInsert")
	@ResponseBody
	public Object insert(Role ro, HttpServletRequest request, HttpServletResponse response) {
		Wrapper<Role> wrapper = Condition.create().eq("name", ro.getName());
		Role role = irs.selectOne(wrapper);
		if (!CommonUtil.isBlank(role)) {
			return ajaxError("职位名称已存在。");
		} else if (irs.insert(ro)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/toUpdate")
	@RequiresPermissions("/system/role/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("record", irs.selectById(id));
		return "system/role/edit";
	}

	@RequestMapping("/update")
	@RequiresPermissions("/system/role/toUpdate")
	@ResponseBody
	public Object update(Role ro, HttpServletRequest request, HttpServletResponse response) {
		// ro.setMdtm((new Date()).toString());
		if (irs.updateById(ro)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/toAuthorize")
	@RequiresPermissions("/system/role/toAuthorize")
	public String toShouquan(ModelMap map, String id) {

		List<Permission> permissions = ips.selectList(null);

		// 回显数据，查询已经授权的数据
		Wrapper wrapper = Condition.create().isWhere(true).like("rid", id);
		List<String> pid = irps.SelectRole_permissionCid(wrapper);

		List list = new ArrayList();

		for (Permission permission : permissions) {
			ZtreeBean e = new ZtreeBean();
			// 优化程序
			e.setChecked(pid.contains(permission.getId()));
			e.setId(permission.getId());
			e.setPId(permission.getPid());
			e.setName(permission.getName());
			e.setOpen(true);
			list.add(e);
		}
		map.put("zNodes", JSON.toJSONString(list));
		map.put("rid", id);
		return "system/role/authorize";
	}

	@RequestMapping("/authorize")
	@RequiresPermissions("/system/role/toAuthorize")
	@ResponseBody
	public Object authorize(String[] pid, String rid, HttpServletRequest request, HttpServletResponse response) {
		if (irps.insertBatchAuthorize(pid, rid)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@RequiresPermissions("/system/role/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (irs.deleteBatchIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

}
