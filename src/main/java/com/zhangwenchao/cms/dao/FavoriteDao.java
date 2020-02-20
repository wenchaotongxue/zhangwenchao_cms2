package com.zhangwenchao.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhangwenchao.cms.pojo.Favorite;

public interface FavoriteDao {
     
	 /**
	  * 查看我的收藏夹
	 * @param tt 
	  * @return
	  */
	List showFavor(@Param("tt")String tt);

	int toadd(@Param("favorite")Favorite favorite);

	int del(@Param("id")Integer id);

}
