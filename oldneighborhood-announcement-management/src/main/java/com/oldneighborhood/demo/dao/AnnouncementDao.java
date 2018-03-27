package com.oldneighborhood.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.oldneighborhood.demo.entity.Announcement;

public interface AnnouncementDao extends JpaRepository<Announcement, Integer>{
	
	@Query(value = "select site_name from site where site_name like ? ", nativeQuery = true)
	public List<Announcement> listByPageUp(int offset_row, int page_size);
	
	@Query(value = "select site_name from site where site_name like ? ", nativeQuery = true)
	public List<Announcement> listByPageDown(int offset_row, int page_size);
	
	@Modifying
	@Query
	public void modify(String a_title, String a_content, String a_image, String a_author, Integer a_ID);
	
	@Modifying
	@Query
	public void stick(Integer a_ID);
	
	@Modifying
	@Query
	public void unstick(Integer a_ID);
	
	@Modifying
	@Query
	public void view(Integer view, Integer a_ID);

}
