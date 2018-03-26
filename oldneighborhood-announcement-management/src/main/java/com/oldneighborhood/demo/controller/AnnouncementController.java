package com.oldneighborhood.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oldneighborhood.demo.service.AnnouncementService;

@RestController
@RequestMapping(path= {"/announcement"})
public class AnnouncementController {
	
	@Autowired
	private AnnouncementService announcementService;
	
	@RequestMapping(path= {"/release"})
	public String release(@RequestBody Map<String, Object> reqMap) {
		return "";
	}
	
	@RequestMapping(path= {"/modify"})
	public String modify(@RequestBody Map<String, Object> reqMap) {
		return "";
	}
	
	@RequestMapping(path= {"/stick"})
	public String stick(@RequestBody Map<String, Object> reqMap) {
		return "";
	}
	
	@RequestMapping(path= {"/delete"})
	public String delete(@RequestBody Map<String, Object> reqMap) {
		return "";
	}

}
