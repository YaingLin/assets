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
import com.ossjk.asset.device.entity.Device;
import com.ossjk.asset.device.entity.Device_type;
import com.ossjk.asset.device.service.IDeviceService;
import com.ossjk.asset.device.service.IDevice_typeService;
import com.ossjk.asset.device.vo.DeviceVo;
import com.ossjk.asset.system.entity.User;
import com.ossjk.asset.system.service.IUserService;

/**
 * <p>
 * 设备明细 前端控制器
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@Controller
@RequestMapping("/device/device")
public class DeviceController extends BaseController{
	@Autowired
	private IDeviceService iDeviceService;

	@Autowired
	private IUserService iUserService;

	@Autowired
	private IDevice_typeService iDevice_typeService;

	@RequestMapping("/list")
	public String list(String sno, String creator, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		dwzPageBean.getCountResultMap().put("sno", sno);
		dwzPageBean.getCountResultMap().put("creator", creator);
		Wrapper wrapper = Condition.create().like("sno", sno).like("creator", creator);
		Page resultPage = iDeviceService.selectDeviceVo(dwzPageBean.toPage(), wrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "device/device/list";
	}

	@RequestMapping("/toInsert")
	public String toInsert(HttpServletRequest request, HttpServletResponse response,ModelMap map) {
		List<User> userList= iUserService.selectList(null);
		List<Device_type> Device_typelist=iDevice_typeService.selectList(null);
		map.put("userList",userList);
		map.put("Device_typelist",Device_typelist);
		return "device/device/edit";
	}

	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(DeviceVo deviceVo, HttpServletRequest request, HttpServletResponse response) {
		Wrapper<Device> wrapper = Condition.create().eq("sno", deviceVo.getSno()).or().eq("creator", deviceVo.getCreator());
		Device  device2 = iDeviceService.selectOne(wrapper);
		if (!CommonUtil.isBlank(device2)) {
			return ajaxError("序列号或登记人");
		}
		if (iDeviceService.insert(deviceVo)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
	@RequestMapping("/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("record", iDeviceService.selectById(id));
		List<User> userList= iUserService.selectList(null);
		List<Device_type> Device_typelist=iDevice_typeService.selectList(null);
		map.put("userList",userList);
		map.put("Device_typelist",Device_typelist);
		return "device/device/edit";
	}

	@RequestMapping("/update")
	@ResponseBody
	public Object update(DeviceVo deviceVo, HttpServletRequest request, HttpServletResponse response) {
		if (iDeviceService.updateById(deviceVo)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (iDeviceService.deleteBatchIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

}
