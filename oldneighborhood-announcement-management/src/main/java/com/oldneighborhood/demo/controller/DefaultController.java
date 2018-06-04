package com.oldneighborhood.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @URL http://localhost:8083/oldneighborhood/announcement
 * @ClassName: DefaultController  
 * @Description: 公告管理默认页面
 * @author Brian  
 * @date 2018年3月26日  
 *
 */
@Controller
public class DefaultController {
	
	@RequestMapping("/info")
	public String announce() {
		return "/info";
	}
	
	@RequestMapping("/parkinglot")
	public @ResponseBody String getRealParkinglot() {
		return null;
	}

}
