package com.zhangwenchao.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangwenchao.cms.dao.CarDao;
import com.zhangwenchao.cms.pojo.Car;
import com.zhangwenchao.cms.service.CarService;
import com.zhangwenchao.common.utils.GeoUtils;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	private CarDao carDao;

	@Override
	public List<Car> list(Car car) {
		// TODO Auto-generated method stub
		List<Car> list = carDao.list(car);
		
		if(car.getLon()!=null&&car.getLat()!=null) {
			for (Car car2 : list) {
				Double distance = GeoUtils.getDistance(car.getLat(),car.getLon(),car2.getLat(),car2.getLon());
				
				car2.setJuli(distance.intValue());
				
			}
		}
		return list;
	}
	
	
}
