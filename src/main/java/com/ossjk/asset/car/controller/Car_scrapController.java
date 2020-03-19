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
import com.ossjk.asset.car.entity.Car_scrap;
import com.ossjk.asset.car.service.ICarService;
import com.ossjk.asset.car.service.ICar_scrapService;
import com.ossjk.asset.common.util.CommonUtil;
import com.ossjk.asset.common.vo.DwzPageBean;
import com.ossjk.asset.system.service.IUserService;

/**
 * <p>
 * 车辆报废 前端控制器
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@Controller
@RequestMapping("/car/car_scrap")
public class Car_scrapController extends BaseController {
	@Autowired
	private ICar_scrapService iCar_scrapService;
	@Autowired
	private ICarService iCarService;
	@Autowired
	private IUserService iUserService;

	@RequestMapping("/list")
	public String list(String cid, String damager, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request,
			HttpServletResponse response) {
		dwzPageBean.getCountResultMap().put("cid", cid);
		Wrapper wrapper = Condition.create().isWhere(true).like("s.cid", cid);
		Page resultPage = iCar_scrapService.selectCar_scrapVo(dwzPageBean.toPage(), wrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "car/car_scrap/list";
	}

	@RequestMapping("/toInsert")
	public String toInsert(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		map.put("user", iUserService.selectList(null));
		map.put("car", iCarService.selectList(null));
		return "car/car_scrap/edit";
	}

	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Car_scrap car_scrap, HttpServletRequest request, HttpServletResponse response) {
		Wrapper<Car_scrap> wrapper = Condition.create().eq("cid", car_scrap.getCid());
		Car_scrap car_scrap2 = iCar_scrapService.selectOne(wrapper);
		if (!CommonUtil.isBlank(car_scrap2)) {
			return ajaxError("重复");
		}
		if (iCar_scrapService.insert(car_scrap)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}

	}

	@RequestMapping("/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("record", iCar_scrapService.selectById(id));
		map.put("user", iUserService.selectList(null));
		map.put("car", iCarService.selectList(null));
		return "car/car_scrap/edit";
	}

	@RequestMapping("/update")
	@ResponseBody
	public Object update(Car_scrap car_scrap, HttpServletRequest request, HttpServletResponse response) {
		if (iCar_scrapService.updateById(car_scrap)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (iCar_scrapService.deleteBatchIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
}
