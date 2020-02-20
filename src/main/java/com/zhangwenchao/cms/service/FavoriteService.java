package com.zhangwenchao.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangwenchao.cms.dao.FavoriteDao;
import com.zhangwenchao.cms.pojo.Favorite;
@Service
public class FavoriteService {

	
	
	@Autowired
	private FavoriteDao facoriteDao;

	public  List showFavor(String tt) {
		// TODO Auto-generated method stub
		return facoriteDao.showFavor(tt);
	}

	public int toadd(Favorite favorite) {
		// TODO Auto-generated method stub
		return facoriteDao.toadd(favorite);
	}

	public int del(Integer id) {
		// TODO Auto-generated method stub
		return facoriteDao.del(id);
	}
	
	
	
	 

}
