package com.oldneighborhood.demo.service;

import java.util.List;

import com.oldneighborhood.demo.entity.Announcement;
import com.oldneighborhood.demo.entity.Page;
/**
 * 
 * @ClassName: AnnouncementService  
 * @Description: 公告管理实现：发布/修改/置顶/删除
 * @author Brian  
 * @date 2018年3月27日  
 *
 */
public interface AnnouncementService {
	
	public int count();
	
	public List<Announcement> listall();
	
	public List<Announcement> listBySticky();
	
	public List<Announcement> list(Page page);
	
	public Announcement getdetail(Integer a_ID);
	
	public Announcement release(Announcement announcement);
	
	public boolean modify(Announcement announcement);
	
	public boolean stick(Integer a_ID);
	
	public boolean unstick(Integer a_ID);
	
	public boolean delete(Integer a_ID);
	
	public boolean view(Integer a_ID);

}
