package com.ossjk.asset.land.controller;


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
import com.ossjk.asset.land.service.ILandService;
import com.ossjk.asset.land.service.ILand_receiveService;
import com.ossjk.asset.land.vo.Land_receiveVo;
import com.ossjk.asset.system.service.IOrganizationService;
import com.ossjk.asset.system.service.IUserService;

/**
 * <p>
 * 土地分配情况 前端控制器
 * </p>
 *
 * @author lym
 * @since 2020-01-12
 */
@Controller
@RequestMapping("/land/land_receive")
public class Land_receiveController extends BaseController {
	@Autowired
	private ILand_receiveService ilrs;
	@Autowired
	private IUserService ius;
	@Autowired
	private IOrganizationService ios;
	@Autowired
	private ILandService ils;
	
	@RequestMapping("/list")
	@RequiresPermissions("/land/land_receive/list")
	public String list(String address, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("address", address);
		Wrapper wrapper = Condition.create().like("address", address);
		Page resultPage = ilrs.selectLand_receiveVo(dwzPageBean.toPage(), wrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "land/land_receive/list";
	}

	@RequestMapping("/toInsert")
	@RequiresPermissions("/land/land_receive/toInsert")
	public String toInsert(ModelMap map,HttpServletRequest request, HttpServletResponse response) {
		Wrapper wrapper = Condition.create().where(" status=0 ");
		map.put("land" ,ils.selectList(wrapper));
		map.put("organization" ,ios.selectList(null));
		map.put("user" ,ius.selectList(null));
		return "land/land_receive/edit";
	}
	
	@RequestMapping("/insert")
	@RequiresPermissions("/land/land_receive/toInsert")
	@ResponseBody
	public Object insert(Land_receiveVo lrv, HttpServletRequest request, HttpServletResponse response) {
		if(ilrs.insertVo(lrv)){
			return ajaxSuccess();
		}else {
			return ajaxError();
		}
	}
	
	@RequestMapping("/toUpdate")
	@RequiresPermissions("/land/land_receive/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		Land_receiveVo record = ilrs.selectVoById(id);
		map.put("record", record);
		Wrapper wrapper = Condition.create().where(" status=0 ").or(" id='"+ record.getLid()+"' ");
		map.put("land" ,ils.selectList(wrapper));
		map.put("organization" ,ios.selectList(null));
		map.put("user" ,ius.selectList(null));
		map.put("olid",record.getLid());
		return "land/land_receive/edit";
	}
	
	@RequestMapping("/update")
	@RequiresPermissions("/land/land_receive/toUpdate")
	@ResponseBody
	public Object update(Land_receiveVo lrv,String olid, HttpServletRequest request, HttpServletResponse response) {
		if (ilrs.updateVoById(lrv,olid)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@RequiresPermissions("/land/land_receive/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (ilrs.deleteBatchIdsAndReset(id)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
}
