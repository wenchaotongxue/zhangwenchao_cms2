package com.zhangwenchao.cms.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.zhangwenchao.cms.service.UserService;
import com.zhangwenchao.common.utils.StringUtils;


public class AuthUserInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		Object userInfo = request.getSession().getAttribute(CmsConstant.UserSessionKey);
		if(userInfo!=null) {
			return true;
		}
		//通过username请求获得cookie
		String username = CookieUtil.getCookieByName(request, "username");
		//判断username是否为空
		if(StringUtils.isNotBlank(username)) {
			UserService userService = SpringBeanUtils.getBean(UserService.class);
			userInfo= userService.getByUsername(username);
			request.getSession().setAttribute(CmsConstant.UserSessionKey, userInfo);
			return true;
		}
		response.sendRedirect("/user/login");
		
		return false;
	}

}






































































































