package com.zhangwenchao.cms.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhangwenchao.cms.dao.ArticleRepository;
import com.zhangwenchao.cms.pojo.Article;
import com.zhangwenchao.cms.pojo.Channel;
import com.zhangwenchao.cms.pojo.User;
import com.zhangwenchao.cms.service.ArticleService;
import com.zhangwenchao.cms.service.UserService;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	/*
	 * login后台登录   
	 */
	@RequestMapping("/")
	public String login() {
		return "admin/login";
	}
	
	/*
	 * 后台首页     
	 */
	@RequestMapping("/home")
	public String home() {
		return "admin/home";
	}
	
	/*
	 * 后台欢迎页面   
	 */
	@RequestMapping("/welcome")
	public String welcome() {
		return "admin/welcome";
	}
	
	/*
	 * 用户管理   
	 */
	@RequestMapping("/user")
	public String user(User user,Model model,
			@RequestParam(value="pageNum",defaultValue="1") int pageNum,@RequestParam(value="pageSize",defaultValue="3") int pageSize) {
		PageInfo<User> pageInfo = userService.getPageInfo(user,pageNum,pageSize);
		model.addAttribute("pageInfo", pageInfo);
		return "admin/user";
	}

	/*
	 * 禁用用户   
	 */
	@RequestMapping("/user/locked")
	@ResponseBody
	public boolean locked(Integer userId) {
		boolean locked = userService.locked(userId);
		return locked;
	}
	
	/*
	 * 启用
	 */
	@RequestMapping("/user/unLocked")
	@ResponseBody
	public boolean unLocked(Integer userId) {
		boolean locked = userService.unLocked(userId);
		return locked;
	}
	
	
	/*
	 * 文章管理  
	 */
	@RequestMapping("/article")
	public String article(Article article,Model model,
			@RequestParam(value="pageNum",defaultValue="1") int pageNum,@RequestParam(value="pageSize",defaultValue="3") int pageSize) {
		//设置文章状态
		article.setStatusIds("0,-1,1");
		PageInfo<Article> pageInfo = articleService.getPageInfo(article,pageNum,pageSize);
		model.addAttribute("pageInfo", pageInfo);
		List<Channel> channelList = articleService.getChannelList();
		model.addAttribute("channelList", channelList);
		return "admin/article";
	}
	
	
	/*
	 * 修改文章状态   
	 */
	@RequestMapping("/article/update/status")
	@ResponseBody
	public boolean updateArticleStatus(Article article) {
		boolean bl=false;
		
		bl = articleService.updateStatus(article.getId(), article.getStatus());
		if(bl) {
			Article art = articleService.getById(article.getId());
			
			articleRepository.save(art);
			return bl;
		}
		return bl;
	}
	
	/*
	 * 文章加热
	 */
	@RequestMapping("/article/addHot")
	@ResponseBody
	public boolean addHot(Article article) {
		return articleService.addHot(article.getId());
	}
	

}
