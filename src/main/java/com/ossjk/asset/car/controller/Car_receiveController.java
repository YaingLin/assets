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
import com.ossjk.asset.car.entity.Car_receive;
import com.ossjk.asset.car.service.ICarService;
import com.ossjk.asset.car.service.ICar_receiveService;
import com.ossjk.asset.common.util.CommonUtil;
import com.ossjk.asset.common.vo.DwzPageBean;
import com.ossjk.asset.system.service.IUserService;

/**
 * <p>
 * 车辆领用表 前端控制器
 * </p>
 *
 * @author Mht
 * @since 2020-01-09
 */
@Controller
@RequestMapping("/car/car_receive")
public class Car_receiveController extends BaseController {

	@Autowired
	private ICarService iCarService;
	@Autowired
	private ICar_receiveService iCar_receiveService;
	@Autowired
	private IUserService iUserService;

	@RequestMapping("/list")
	public String list(String cid, String receipt, DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request,
			HttpServletResponse response) {
		dwzPageBean.getCountResultMap().put("r.cid", cid);
		dwzPageBean.getCountResultMap().put("receipt", receipt);
		Wrapper wrapper = Condition.create().isWhere(true).like("r.cid", cid).like("receipt", receipt);
		Page resultPage = iCar_receiveService.selectCar_receiveVo(dwzPageBean.toPage(), wrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "car/car_receive/list";
	}

	@RequestMapping("/toInsert")
	public String toInsert(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		map.put("user", iUserService.selectList(null));
		map.put("car", iCarService.selectList(null));
		return "car/car_receive/edit";
	}

	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Car_receive car_receive, HttpServletRequest request, HttpServletResponse response) {
		Wrapper<Car_receive> wrapper = Condition.create().eq("receipt", car_receive.getReceipt());
		Car_receive car_receive2 = iCar_receiveService.selectOne(wrapper);
		if (!CommonUtil.isBlank(car_receive2)) {
			return ajaxError("单据号");
		}
		if (iCar_receiveService.insert(car_receive)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}

	}

	@RequestMapping("/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("record", iCar_receiveService.selectById(id));
		map.put("user", iUserService.selectList(null));
		map.put("car", iCarService.selectList(null));
		return "car/car_receive/edit";
	}

	@RequestMapping("/update")
	@ResponseBody
	public Object update(Car_receive car_receive, HttpServletRequest request, HttpServletResponse response) {
		if (iCar_receiveService.updateById(car_receive)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Object update(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (iCar_receiveService.deleteBatchIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
}
