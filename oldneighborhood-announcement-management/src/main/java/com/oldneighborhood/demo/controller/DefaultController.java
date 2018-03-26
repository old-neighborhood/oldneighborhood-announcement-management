package com.oldneighborhood.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @URL http://localhost:8083/oldneighborhood/announcement
 * @ClassName: DefaultController  
 * @Description: 公告管理默认页面
 * @author Brian  
 * @date 2018年3月26日  
 *
 */
@Controller
@RequestMapping(path= {"/announcement"})
public class DefaultController {
	
	public String announce() {
		return "/announcement";
	}

}