package com.oldneighborhood.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oldneighborhood.demo.entity.Announcement;
import com.oldneighborhood.demo.entity.Page;
import com.oldneighborhood.demo.service.AnnouncementService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping(path= {"/announcement"})
public class AnnouncementController {
	
	@Autowired
	private AnnouncementService announcementService;
	@RequestMapping("/listall")
	public String listall() {
		List<Announcement> annouce = announcementService.listall();
		JSONArray json = JSONArray.fromObject(annouce);
		return json.toString();
	}
	
	@RequestMapping("/listSticky")
	public String listBySticky() {
		List<Announcement> annouce = announcementService.listBySticky();
		JSONArray json = JSONArray.fromObject(annouce);
		return json.toString();
	}
	
	@RequestMapping(path= {"/list"})
	public String list(@RequestBody Map<String, Object> reqMap) {
		int total_rows = announcementService.count();
		int current_pages = Integer.parseInt(reqMap.get("current_page").toString());
		int page_size = Integer.parseInt(reqMap.get("page_size").toString());
		boolean desc = Boolean.parseBoolean(reqMap.get("desc_sort").toString());
		Page page = new Page(total_rows, current_pages, page_size, desc);
		
		List<Announcement> announce = announcementService.list(page);
		JSONArray json = JSONArray.fromObject(announce);
		return json.toString();
	}
	
	@RequestMapping(path= {"/release"})
	public String release(@RequestBody Map<String, Object> reqMap) {
		Announcement announce = new Announcement(
				reqMap.get("a_title").toString(), 
				reqMap.get("a_content").toString(), 
				reqMap.get("a_image").toString(), 
				reqMap.get("a_author").toString(), 
				reqMap.get("ad_ID").toString());
		
		Announcement newannounce = announcementService.release(announce);
		if (newannounce != null) {
			return "{\"result\":\"success\"}";
		}else {
			return "{\"result\":\"error\"}";
		}
	}
	
	@RequestMapping(path= {"/announcedetail"})
	public String detail(@RequestBody Map<String, Object> reqMap) {
		Announcement announce = announcementService.getdetail(
				Integer.parseInt(reqMap.get("a_ID").toString()));
		JSONObject json = JSONObject.fromObject(announce);
		return json.toString();
	}
	
	@RequestMapping(path= {"/modify"})
	public String modify(@RequestBody Map<String, Object> reqMap) {
		Announcement annouce = new Announcement(
				Integer.parseInt(reqMap.get("a_ID").toString()),
				reqMap.get("a_title").toString(), 
				reqMap.get("a_content").toString(), 
				reqMap.get("a_image").toString(), 
				reqMap.get("a_author").toString());
		boolean flag = announcementService.modify(annouce);
		return flag ? "{\"result\":\"success\"}" : "{\"result\":\"error\"}";
	}
	
	@RequestMapping(path= {"/stick"})
	public String stick(@RequestBody Map<String, Object> reqMap) {
		boolean flag = announcementService.stick(Integer.parseInt(reqMap.get("a_ID").toString()));
		return flag ? "{\"result\":\"success\"}" : "{\"result\":\"error\"}";
	}
	@RequestMapping(path= {"/unstick"})
	public String unstick(@RequestBody Map<String, Object> reqMap) {
		boolean flag = announcementService.unstick(Integer.parseInt(reqMap.get("a_ID").toString()));
		return flag ? "{\"result\":\"success\"}" : "{\"result\":\"error\"}";
	}
	
	@RequestMapping(path= {"/delete"})
	public String delete(@RequestBody Map<String, Object> reqMap) {
		boolean flag = announcementService.delete(Integer.parseInt(reqMap.get("a_ID").toString()));
		return flag ? "{\"result\":\"success\"}" : "{\"result\":\"error\"}";
	}

}
