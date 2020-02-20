package com.zhangwenchao.cms.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangwenchao.cms.pojo.Car;
import com.zhangwenchao.cms.service.CarService;

@Controller
@RequestMapping("/admin/car/")
public class CarController {

	@Autowired
	private CarService carService;
	
	@RequestMapping("list")
	public String list(Model m,Car car,@RequestParam(defaultValue="1")int pageNum) {
		PageHelper.startPage(pageNum,4);
		
		List<Car> list=carService.list(car);
		for (Car car2 : list) {
			System.out.println(car2);
		}
		PageInfo<Car> pageInfo = new PageInfo<>(list);
		m.addAttribute("list", list);
		m.addAttribute("pageInfo", pageInfo);
		
		
		return "car/list";
	}
}
