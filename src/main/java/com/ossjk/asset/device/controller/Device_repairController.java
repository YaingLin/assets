package com.ossjk.asset.device.controller;


import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.ossjk.asset.device.entity.Device_repair;
import com.ossjk.asset.device.service.IDevice_repairService;
import com.ossjk.asset.system.entity.User;
import com.ossjk.asset.system.service.IUserService;

/**
 * <p>
 * 设备维修表 前端控制器
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@Controller
@RequestMapping("/device/device_repair")
public class Device_repairController extends BaseController{
	@Autowired
	private IDevice_repairService iDevice_repairService;

	@Autowired
	private IUserService iUserService;

	@RequestMapping("/list")
	public String list(String damager, String repairer, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		dwzPageBean.getCountResultMap().put("damager", damager);
		dwzPageBean.getCountResultMap().put("repairer", repairer);
		Wrapper wrapper = Condition.create().like("damager", damager).like("repairer", repairer);
		Page resultPage = iDevice_repairService.selectDevice_repairVo(dwzPageBean.toPage(), wrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "device/device_repair/list";
	}

	@RequestMapping("/toInsert")
	public String toInsert(HttpServletRequest request, HttpServletResponse response,ModelMap map) {
		List<User> userlist=iUserService.selectList(null);
		map.put("userlist",userlist);
		return "device/device_repair/edit";
	}

	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Device_repair device_repair, HttpServletRequest request, HttpServletResponse response) {
		Wrapper<Device_repair> wrapper = Condition.create().eq("damager", device_repair.getDamager()).or().eq("repairer", device_repair.getRepairer());
		Device_repair  device_repair2 = iDevice_repairService.selectOne(wrapper);
		if (!CommonUtil.isBlank(device_repair2)) {
			return ajaxError("报修人和维修人");
		}
		if (iDevice_repairService.insert(device_repair)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
	@RequestMapping("/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("record", iDevice_repairService.selectById(id));
		List<User> userlist=iUserService.selectList(null);
		map.put("userlist",userlist);
		return "device/device_repair/edit";
	}

	@RequestMapping("/update")
	@ResponseBody
	public Object update(Device_repair device_repair, HttpServletRequest request, HttpServletResponse response) {
		if (iDevice_repairService.updateById(device_repair)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (iDevice_repairService.deleteBatchIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
}
