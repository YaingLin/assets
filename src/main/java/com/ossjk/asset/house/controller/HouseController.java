package com.ossjk.asset.house.controller;

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
import com.ossjk.asset.house.entity.House;
import com.ossjk.asset.house.service.IHouseService;
import com.ossjk.asset.system.service.IUserService;

/**
 * <p>
 * 房屋明细 前端控制器
 * </p>
 *
 * @author lym
 * @since 2020-01-12
 */
@Controller
@RequestMapping("/house/house")
public class HouseController extends BaseController {
	@Autowired
	private IHouseService ihs;
	@Autowired
	private IUserService ius;

	@RequestMapping("/list")
	@RequiresPermissions("/house/house/list")
	public String list(String address, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request,
			HttpServletResponse response) {
		map.put("address", address);
		Wrapper wrapper = Condition.create().like("address", address);
		Page resultPage = ihs.selectHouseVo(dwzPageBean.toPage(), wrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "house/house/list";
	}

	@RequestMapping("/toInsert")
	@RequiresPermissions("/house/house/toInsert")
	public String toInsert(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("user", ius.selectList(null));
		return "house/house/edit";
	}

	@RequestMapping("/insert")
	@RequiresPermissions("/house/house/toInsert")
	@ResponseBody
	public Object insert(House h, HttpServletRequest request, HttpServletResponse response) {
		Wrapper<House> wrapper = Condition.create().eq("address", h.getAddress());
		House house = ihs.selectOne(wrapper);
		if (!CommonUtil.isBlank(house)) {
			return ajaxError("区域信息已在库中存在。");
		} else if (ihs.insert(h)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/toUpdate")
	@RequiresPermissions("/house/house/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("record", ihs.selectById(id));
		map.put("user", ius.selectList(null));
		return "house/house/edit";
	}

	@RequestMapping("/update")
	@RequiresPermissions("/house/house/toUpdate")
	@ResponseBody
	public Object update(House h, HttpServletRequest request, HttpServletResponse response) {
		if (ihs.updateById(h)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@RequiresPermissions("/house/house/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (ihs.deleteBatchIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
}
