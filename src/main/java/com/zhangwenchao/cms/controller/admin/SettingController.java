package com.zhangwenchao.cms.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangwenchao.cms.common.JsonResult;
import com.zhangwenchao.cms.pojo.Settings;
import com.zhangwenchao.cms.service.SettingsService;

@Controller
@RequestMapping("/admin/")
public class SettingController {
	@Autowired
	private SettingsService settingsService;
	
	/*
	 * 系统设置   
	 */
	@RequestMapping("/settings")
	public String settings(Model model) {
		Settings settings = settingsService.get();
		model.addAttribute("settings", settings);
		return "admin/settings";
	}
	
	@RequestMapping("/settings/save")
	@ResponseBody
	public Object save(Model model,Settings settings) {
        System.out.println(settings);
		boolean result = settingsService.save(settings);
		if(result) {
			return JsonResult.sucess();
		}
		return JsonResult.fail(500, "修改失败");
	}
}
