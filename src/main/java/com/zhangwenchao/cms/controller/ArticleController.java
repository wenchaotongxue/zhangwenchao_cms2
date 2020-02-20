package com.zhangwenchao.cms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.xml.internal.xsom.impl.WildcardImpl.Other;
import com.zhangwenchao.cms.common.CmsConstant;
import com.zhangwenchao.cms.common.JsonResult;
import com.zhangwenchao.cms.pojo.Article;
import com.zhangwenchao.cms.pojo.Category;
import com.zhangwenchao.cms.pojo.Channel;
import com.zhangwenchao.cms.pojo.Favorite;
import com.zhangwenchao.cms.pojo.User;
import com.zhangwenchao.cms.service.ArticleService;
import com.zhangwenchao.cms.service.FavoriteService;


@Controller
@RequestMapping("/article/")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private FavoriteService favoriteService;
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/*
	 * 发布文章   
	 */
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String add(Integer id,Model model) {
		logger.info("articleId:{}",id);
		if(id!=null) {
			Article article = articleService.getById(id);
			logger.info(article.toString());
			model.addAttribute("article", article);
			List<Category> cateList = articleService.getCateListByChannelId(article.getChannelId());
			model.addAttribute("cateList", cateList);
		}
		List<Channel> channelList = articleService.getChannelList();
		model.addAttribute("channelList", channelList);
		return "article/add";
	}      
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult add(Article article,Model model,HttpSession session) {
		System.out.println(article);
		User userInfo = (User)session.getAttribute(CmsConstant.UserSessionKey);
		if(userInfo==null) {
			return JsonResult.fail(CmsConstant.unLoginErrorCode, "未登录");
		}
		article.setUserId(userInfo.getId());
		boolean result = articleService.save(article);
		return JsonResult.sucess(result);
	}
	
	/*
	 * 根据频道Id查询分类列表   
	 */
	@RequestMapping(value="getCateList",method=RequestMethod.GET)
	@ResponseBody
	public JsonResult getCateList(Integer channelId,Model model,HttpSession session) {
		return JsonResult.sucess(articleService.getCateListByChannelId(channelId));
	}
	
	
	/*
	 * 批量删除   
	 */
	@RequestMapping("delByIds")
	public @ResponseBody JsonResult delByIds(String ids) {
		if(ids==null) {
			return JsonResult.fail(10001, "请选择删除的文章");
		}
		//已审核判断
		boolean isCheck = articleService.isAllCheck(ids);
		if(!isCheck) {
			return JsonResult.fail(10001, "请选择未审核的文章删除");
		}
		//删除
		boolean result = articleService.delByIds(ids);
		if(result) {
			return JsonResult.sucess();
		}
		return JsonResult.fail(500, "未知错误");
	}
	
	
	/**
	 * 收藏夹功能
	 * 
	 */
	
	@RequestMapping("favorite")
	public String favorite(Model m,String tt) {
	
		 
		List favoritelist = favoriteService.showFavor(tt);
		  
		
		 m.addAttribute("favoritelist", favoritelist);
		
		return "article/favorite";	
	}
	
	@RequestMapping("addfavorite")
	public String addfavorite() {
		
		
		return "article/addfavorite";
		
	}
	
	@RequestMapping("doAdd")
	public Object doAdd(Favorite favorite) {
	 int i=	favoriteService.toadd(favorite);
		 
		
		return i>0;
		
	}
	@RequestMapping("del")
	public Object del(Integer id) {
	 int i=	favoriteService.del(id);
		 
		
		return i>0;
		
	}
	
	
	
	
}
