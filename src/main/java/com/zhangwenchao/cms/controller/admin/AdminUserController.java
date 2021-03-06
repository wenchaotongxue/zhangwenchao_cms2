package com.zhangwenchao.cms.controller.admin;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangwenchao.cms.common.CmsConstant;
import com.zhangwenchao.cms.common.CmsMd5Util;
import com.zhangwenchao.cms.common.JsonResult;
import com.zhangwenchao.cms.pojo.User;
import com.zhangwenchao.cms.service.UserService;
import com.zhangwenchao.common.utils.StringUtils;


@Controller
@RequestMapping("/admin/user/")
public class AdminUserController {
	@Autowired
	private UserService userService;
	
	/*
	 * 后台登录接口   
	 */
	@RequestMapping("login")
	@ResponseBody
	public Object login(User user,HttpSession session) {
		//判断用户名和密码
		if(StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
			return JsonResult.fail(1000, "用户名和密码不能为空");
		}
		//查询用户
		User userInfo = userService.getByUsername(user.getUsername());
		//用户为空
		if(userInfo==null) {
			return JsonResult.fail(1000, "用户名或密码错误");
		}
		//是否管理员
		if(!userInfo.isAdmin()) {
			return JsonResult.fail(1000, "权限不够");
		}
		//判断密码
		String string2md5 = CmsMd5Util.string2MD5(user.getPassword());
		if(string2md5.equals(userInfo.getPassword())) {
			session.setAttribute(CmsConstant.UserAdminSessionKey, userInfo);
			return JsonResult.sucess();
		}
		return JsonResult.fail(500, "未知错误");
	}
	/*
	 * 退出
	 */
	@RequestMapping("logout")
	public Object logout(HttpServletResponse response,HttpSession session) {
		session.removeAttribute(CmsConstant.UserAdminSessionKey);
		return "redirect:/admin/";
	}
}
