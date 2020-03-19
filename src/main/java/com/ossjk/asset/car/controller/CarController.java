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
import com.ossjk.asset.car.entity.Car;
import com.ossjk.asset.car.service.ICarService;
import com.ossjk.asset.car.service.ICar_typeService;
import com.ossjk.asset.common.util.CommonUtil;
import com.ossjk.asset.common.vo.DwzPageBean;
import com.ossjk.asset.system.service.IUserService;

/**
 * <p>
 * 车辆明细 前端控制器
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@Controller
@RequestMapping("/car/car")
public class CarController extends BaseController {
	@Autowired
	private ICarService iCarService;
	@Autowired
	private ICar_typeService iCar_typeService;
	@Autowired
	private IUserService iUserService;

	@RequestMapping("/list")
	public String list(String ctid, String code, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request,
			HttpServletResponse response) {
		dwzPageBean.getCountResultMap().put("ctid", ctid);
		dwzPageBean.getCountResultMap().put("code", code);
		Wrapper wrapper = Condition.create().isWhere(true).like("c.ctid", ctid).like("c.code", code);
		Page resultPage = iCarService.selectCarVo(dwzPageBean.toPage(), wrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "car/car/list";
	}

	@RequestMapping("/toInsert")
	public String toInsert(HttpServletRequest request, HttpServletResponse response,ModelMap map) {
		map.put("user", iUserService.selectList(null));
		map.put("car_type", iCar_typeService.selectList(null));
		return "car/car/edit";
	}

	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Car car, HttpServletRequest request, HttpServletResponse response) {
		Wrapper<Car> wrapper = Condition.create().eq("sno", car.getSno());
		Car car2 = iCarService.selectOne(wrapper);
		if (!CommonUtil.isBlank(car2)) {
			return ajaxError("重复");
		}
		if (iCarService.insert(car)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}

		}

	@RequestMapping("/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("record", iCarService.selectById(id));
		map.put("car_type", iCar_typeService.selectList(null));
		map.put("user", iUserService.selectList(null));
		return "car/car/edit";
	}

	@RequestMapping("/update")
	@ResponseBody
	public Object update(Car car, HttpServletRequest request, HttpServletResponse response) {
		if (iCarService.updateById(car)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (iCarService.deleteBatchIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
}
