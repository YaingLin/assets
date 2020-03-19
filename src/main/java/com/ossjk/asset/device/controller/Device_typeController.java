package com.ossjk.asset.device.controller;


import java.util.Arrays;

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
import com.ossjk.asset.device.entity.Device_type;
import com.ossjk.asset.device.service.IDevice_typeService;

/**
 * <p>
 * 设备类型 前端控制器
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@Controller
@RequestMapping("/device/device_type")
public class Device_typeController extends BaseController {
	@Autowired
	private IDevice_typeService iDevice_typeService ;

	@RequestMapping("/list")
	public String list(String intlcode, String model, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		dwzPageBean.getCountResultMap().put("intlcode", intlcode);
		dwzPageBean.getCountResultMap().put("model", model);
		Wrapper wrapper = Condition.create().like("intlcode", intlcode).like("model", model);
		Page resultPage = iDevice_typeService.selectPage(dwzPageBean.toPage(), wrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "device/device_type/list";
	}

	@RequestMapping("/toInsert")
	public String toInsert(HttpServletRequest request, HttpServletResponse response) {
		return "device/device_type/edit";
	}

	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Device_type device_type, HttpServletRequest request, HttpServletResponse response) {
		Wrapper<Device_type> wrapper = Condition.create().eq("intlcode", device_type.getIntlcode()).or().eq("model", device_type.getModel());
		Device_type  device_type2 = iDevice_typeService.selectOne(wrapper);
		if (!CommonUtil.isBlank(device_type2)) {
			return ajaxError("国际编号或型号");
		}
		if (iDevice_typeService.insert(device_type)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
	@RequestMapping("/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("record", iDevice_typeService.selectById(id));
		return "device/device_type/edit";
	}

	@RequestMapping("/update")
	@ResponseBody
	public Object update(Device_type device_type, HttpServletRequest request, HttpServletResponse response) {
		if (iDevice_typeService.updateById(device_type)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (iDevice_typeService.deleteBatchIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
}
