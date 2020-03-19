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
import com.ossjk.asset.common.vo.DwzPageBean;
import com.ossjk.asset.house.service.IHouseService;
import com.ossjk.asset.house.service.IHouse_receiveService;
import com.ossjk.asset.house.vo.House_receiveVo;
import com.ossjk.asset.system.service.IOrganizationService;
import com.ossjk.asset.system.service.IUserService;

/**
 * <p>
 * 房屋分配情况 前端控制器
 * </p>
 *
 * @author lym
 * @since 2020-01-12
 */
@Controller
@RequestMapping("/house/house_receive")
public class House_receiveController extends BaseController {
	@Autowired
	private IHouse_receiveService ihrs;
	@Autowired
	private IUserService ius;
	@Autowired
	private IOrganizationService ios;
	@Autowired
	private IHouseService ihs;
	
	@RequestMapping("/list")
	@RequiresPermissions("/house/house_receive/list")
	public String list(String address, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("address", address);
		Wrapper wrapper = Condition.create().like("address", address);
		Page resultPage = ihrs.selectHouse_receiveVo(dwzPageBean.toPage(), wrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "house/house_receive/list";
	}

	@RequestMapping("/toInsert")
	@RequiresPermissions("/house/house_receive/toInsert")
	public String toInsert(ModelMap map,HttpServletRequest request, HttpServletResponse response) {
		Wrapper wrapper = Condition.create().where(" status=0 ");
		map.put("house" ,ihs.selectList(wrapper));
		map.put("organization" ,ios.selectList(null));
		map.put("user" ,ius.selectList(null));
		return "house/house_receive/edit";
	}
	
	@RequestMapping("/insert")
	@RequiresPermissions("/house/house_receive/toInsert")
	@ResponseBody
	public Object insert(House_receiveVo hrv, HttpServletRequest request, HttpServletResponse response) {
		if(ihrs.insertVo(hrv)){
			return ajaxSuccess();
		}else {
			return ajaxError();
		}
	}
	
	@RequestMapping("/toUpdate")
	@RequiresPermissions("/house/house_receive/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		House_receiveVo record = ihrs.selectVoById(id);
		map.put("record", record);
		Wrapper wrapper = Condition.create().where(" status=0 ").or(" id='"+record.getHid()+"' ");
		map.put("house" ,ihs.selectList(wrapper));
		map.put("organization" ,ios.selectList(null));
		map.put("user" ,ius.selectList(null));
		map.put("ohid", record.getHid());
		return "house/house_receive/edit";
	}
	
	@RequestMapping("/update")
	@RequiresPermissions("/house/house_receive/toUpdate")
	@ResponseBody
	public Object update(House_receiveVo hrv,String ohid, HttpServletRequest request, HttpServletResponse response) {
		if (ihrs.updateVoById(hrv,ohid)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@RequiresPermissions("/house/house_receive/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (ihrs.deleteBatchIdsAndReset(id)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
}
