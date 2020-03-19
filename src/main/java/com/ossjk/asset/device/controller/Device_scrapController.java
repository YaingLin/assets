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
import com.ossjk.asset.device.entity.Device_scrap;
import com.ossjk.asset.device.service.IDevice_scrapService;
import com.ossjk.asset.system.entity.User;
import com.ossjk.asset.system.service.IUserService;

/**
 * <p>
 * 设备报废 前端控制器
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@Controller
@RequestMapping("/device/device_scrap")
public class Device_scrapController extends BaseController {
	@Autowired
	private IDevice_scrapService iDevice_scrapService;
	@Autowired
	private IUserService iUserService;

	@RequestMapping("/list")
	public String list(String scraper, String approver, DwzPageBean dwzPageBean, ModelMap map,
			HttpServletRequest request, HttpServletResponse response) {
		dwzPageBean.getCountResultMap().put("scraper", scraper);
		dwzPageBean.getCountResultMap().put("approver", approver);
		Wrapper wrapper = Condition.create().like("scraper", scraper).like("approver", approver);
		Page resultPage = iDevice_scrapService.selectDevice_scrapVo(dwzPageBean.toPage(), wrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "device/device_scrap/list";
	}

	@RequestMapping("/toInsert")
	public String toInsert(HttpServletRequest request, HttpServletResponse response,ModelMap map) {
		List<User> userlist=iUserService.selectList(null);
		map.put("userlist",userlist);
		return "device/device_scrap/edit";
	}

	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Device_scrap device_scrap, HttpServletRequest request, HttpServletResponse response) {
		Wrapper<Device_scrap> wrapper = Condition.create().eq("scraper", device_scrap.getScraper()).or().eq("approver",
				device_scrap.getApprover());
		Device_scrap device_scrap2 = iDevice_scrapService.selectOne(wrapper);
		if (!CommonUtil.isBlank(device_scrap2)) {
			return ajaxError("报废人或审批人");
		}
		if (iDevice_scrapService.insert(device_scrap)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		List<User> userlist=iUserService.selectList(null);
		map.put("userlist",userlist);
		map.put("record", iDevice_scrapService.selectById(id));
		return "device/device_scrap/edit";
	}

	@RequestMapping("/update")
	@ResponseBody
	public Object update(Device_scrap device_scrap, HttpServletRequest request, HttpServletResponse response) {
		if (iDevice_scrapService.updateById(device_scrap)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (iDevice_scrapService.deleteBatchIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
}
