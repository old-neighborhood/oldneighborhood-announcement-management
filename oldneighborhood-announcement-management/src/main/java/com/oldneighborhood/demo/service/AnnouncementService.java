package com.oldneighborhood.demo.service;

import java.util.List;

import com.oldneighborhood.demo.entity.Announcement;
/**
 * 
 * @ClassName: AnnouncementService  
 * @Description: 公告管理实现：发布/修改/置顶/删除
 * @author Brian  
 * @date 2018年3月27日  
 *
 */
public interface AnnouncementService {
	
	public List<Announcement> list();
	
	public Announcement release(Announcement announcement);
	
	public boolean modify(Announcement announcement);
	
	public boolean stick(String a_ID);
	
	public boolean delete(String a_ID);

}
