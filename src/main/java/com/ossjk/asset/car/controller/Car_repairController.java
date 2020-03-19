package com.ossjk.asset.car.controller;

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
import com.ossjk.asset.car.entity.Car_repair;
import com.ossjk.asset.car.service.ICarService;
import com.ossjk.asset.car.service.ICar_repairService;
import com.ossjk.asset.common.util.CommonUtil;
import com.ossjk.asset.common.vo.DwzPageBean;
import com.ossjk.asset.system.service.IUserService;

/**
 * <p>
 * 车辆维修表 前端控制器
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@Controller
@RequestMapping("/car/car_repair")
public class Car_repairController extends BaseController {

	@Autowired
	private ICar_repairService iCar_repairService;
	@Autowired
	private IUserService iUserService;
	@Autowired
	private ICarService iCarService;

	@RequestMapping("/list")
	public String list(String cid, String damager, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request,
			HttpServletResponse response) {
		dwzPageBean.getCountResultMap().put("cid", cid);
		Wrapper wrapper = Condition.create().isWhere(true).like("r.cid", cid);
		Page resultPage = iCar_repairService.selectCar_repairVo(dwzPageBean.toPage(), wrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "car/car_repair/list";
	}

	@RequestMapping("/toInsert")
	public String toInsert(HttpServletRequest request, HttpServletResponse response,ModelMap map) {
		map.put("user", iUserService.selectList(null));
		map.put("car", iCarService.selectList(null));
		return "car/car_repair/edit";
	}

	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Car_repair car_repair, HttpServletRequest request, HttpServletResponse response) {
		Wrapper<Car_repair> wrapper = Condition.create().eq("cid", car_repair.getCid());
		Car_repair car_repair2 = iCar_repairService.selectOne(wrapper);
		if (!CommonUtil.isBlank(car_repair2)) {
			return ajaxError("重复");
		}
		if (iCar_repairService.insert(car_repair)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}

	}

	@RequestMapping("/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("record", iCar_repairService.selectById(id));
		map.put("user", iUserService.selectList(null));
		map.put("car", iCarService.selectList(null));
		return "car/car_repair/edit";
	}

	@RequestMapping("/update")
	@ResponseBody
	public Object update(Car_repair car_repair, HttpServletRequest request, HttpServletResponse response) {
		if (iCar_repairService.updateById(car_repair)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (iCar_repairService.deleteBatchIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
}
