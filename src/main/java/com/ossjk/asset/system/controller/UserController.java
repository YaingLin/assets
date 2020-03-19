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
import com.ossjk.asset.system.entity.User;
import com.ossjk.asset.system.service.IOrganizationService;
import com.ossjk.asset.system.service.IRoleService;
import com.ossjk.asset.system.service.IUserService;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author chair
 * @since 2018-07-09
 */
@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController {
	@Autowired
	private IOrganizationService ios;
	@Autowired
	private IRoleService irs;
	@Autowired
	private IUserService iUserService;

	@RequestMapping("/list")
	@RequiresPermissions("/system/user/list")
	public String list(String name, String phone, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("name", name);
		map.put("phone", phone);
		Wrapper wrapper = Condition.create().like("u.name", name).like("u.phone", phone);
//		System.out.println(Condition.create().notIn(phone, null));
		Page resultPage = iUserService.selectUserVo(dwzPageBean.toPage(), wrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "system/user/list";
	}

	@RequestMapping("/toInsert")
	@RequiresPermissions("/system/user/toInsert")
	public String toInsert(HttpServletRequest request, HttpServletResponse response,ModelMap map) {
		map.put("organization", ios.selectList(null));
		map.put("role",irs.selectList(null));
		return "system/user/edit";
	}

	@RequestMapping("/insert")
	@RequiresPermissions("/system/user/toInsert")
	@ResponseBody
	public Object insert(User user, HttpServletRequest request, HttpServletResponse response) {
		Wrapper<User> wrapper = Condition.create().eq("name", user.getName()).or().eq("phone", user.getPhone());
		User user2 = iUserService.selectOne(wrapper);
		if (!CommonUtil.isBlank(user2)) {
			return ajaxError("姓名或手机重复");
		}
		if (iUserService.insert(user)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}

	}

	@RequestMapping("/toUpdate")
	@RequiresPermissions("/system/user/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("record", iUserService.selectById(id));
		map.put("organization", ios.selectList(null));
		map.put("role",irs.selectList(null));
		return "system/user/edit";
	}

	@RequestMapping("/update")
	@RequiresPermissions("/system/user/toUpdate")
	@ResponseBody
	public Object update(User user, HttpServletRequest request, HttpServletResponse response) {
		if (iUserService.updateById(user)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@RequiresPermissions("/system/user/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (iUserService.deleteBatchIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

}
