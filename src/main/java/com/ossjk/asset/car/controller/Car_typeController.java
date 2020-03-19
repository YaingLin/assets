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
import com.ossjk.asset.car.entity.Car_type;
import com.ossjk.asset.car.service.ICar_typeService;
import com.ossjk.asset.common.util.CommonUtil;
import com.ossjk.asset.common.vo.DwzPageBean;

/**
 * <p>
 * 车辆类型 前端控制器
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@Controller
@RequestMapping("/car/car_type")
public class Car_typeController extends BaseController {
	@Autowired
	private ICar_typeService iCar_typeService;

	@RequestMapping("/list")
	public String list(String name, String damager, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request,
			HttpServletResponse response) {
		dwzPageBean.getCountResultMap().put("name", name);
		Wrapper wrapper = Condition.create().like("name", name);
		Page resultPage = iCar_typeService.selectPage(dwzPageBean.toPage(), wrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "car/car_type/list";
	}

	@RequestMapping("/toInsert")
	public String toInsert(HttpServletRequest request, HttpServletResponse response) {
		
		return "car/car_type/edit";
	}

	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Car_type car_type, HttpServletRequest request, HttpServletResponse response) {
		Wrapper<Car_type> wrapper = Condition.create().eq("name", car_type.getName());
		Car_type car_type2 = iCar_typeService.selectOne(wrapper);
		if (!CommonUtil.isBlank(car_type2)) {
			return ajaxError("重复");
		}
		if (iCar_typeService.insert(car_type)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}

	}

	@RequestMapping("/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("record", iCar_typeService.selectById(id));
		return "car/car_type/edit";
	}

	@RequestMapping("/update")
	@ResponseBody
	public Object update(Car_type car_type, HttpServletRequest request, HttpServletResponse response) {
		if (iCar_typeService.updateById(car_type)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (iCar_typeService.deleteBatchIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
}
