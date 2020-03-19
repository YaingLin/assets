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
import com.ossjk.asset.device.entity.Device_receive;
import com.ossjk.asset.device.service.IDeviceService;
import com.ossjk.asset.device.service.IDevice_receiveService;
import com.ossjk.asset.device.vo.Device_receiveVo;
import com.ossjk.asset.system.entity.User;
import com.ossjk.asset.system.service.IUserService;

/**
 * <p>
 * 设备领用表 前端控制器
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@Controller
@RequestMapping("/device/device_receive")
public class Device_receiveController extends BaseController {
	@Autowired
	private IDevice_receiveService iDevice_receiveService;

	@Autowired
	private IUserService iUserService;

	@Autowired
	private IDeviceService iDeviceService;

	@RequestMapping("/list")
	public String list(String receipt, String recipients, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request,
			HttpServletResponse response) {
		dwzPageBean.getCountResultMap().put("receipt", receipt);
		dwzPageBean.getCountResultMap().put("recipients", recipients);
		Wrapper wrapper = Condition.create().like("receipt", receipt).like("recipients", recipients);
		Page resultPage = iDevice_receiveService.selectDevice_receiveVo(dwzPageBean.toPage(), wrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "device/device_receive/list";
	}

	@RequestMapping("/toInsert")
	public String toInsert(HttpServletRequest request, HttpServletResponse response,ModelMap map) {
		List<User> userlist=iUserService.selectList(null);
		List<Device> deviceServicelist=iDeviceService.selectList(null);
		map.put("deviceServicelist",deviceServicelist);
		map.put("userlist", userlist);
		return "device/device_receive/edit";
	}

	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Device_receive device_receive, HttpServletRequest request, HttpServletResponse response) {
		Wrapper<Device_receive> wrapper = Condition.create().eq("receipt", device_receive.getReceipt()).or()
				.eq("recipients", device_receive.getRecipients());
		Device_receive device_receive2 = iDevice_receiveService.selectOne(wrapper);
		if (!CommonUtil.isBlank(device_receive2)) {
			return ajaxError("单据号或领用人");
		}
		if (iDevice_receiveService.insert(device_receive)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		List<User> userlist=iUserService.selectList(null);
		List<Device> deviceServicelist=iDeviceService.selectList(null);
		map.put("deviceServicelist",deviceServicelist);
		map.put("userlist", userlist);
		map.put("record", iDevice_receiveService.selectById(id));
		return "device/device_receive/edit";
	}

	@RequestMapping("/update")
	@ResponseBody
	public Object update(Device_receiveVo device_receive, HttpServletRequest request, HttpServletResponse response) {
		if (iDevice_receiveService.updateById(device_receive)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (iDevice_receiveService.deleteBatchIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
}
