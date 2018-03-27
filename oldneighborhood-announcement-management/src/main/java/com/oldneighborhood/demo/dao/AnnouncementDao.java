package com.oldneighborhood.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.oldneighborhood.demo.entity.Announcement;

public interface AnnouncementDao extends JpaRepository<Announcement, Integer>{
	
	@Query(value = "select * from announcement order by a_date asc limit ?, ? ", nativeQuery = true)
	public List<Announcement> listByPageUp(int offset_row, int page_size);
	
	@Query(value = "select * from announcement order by a_date desc limit ?, ? ", nativeQuery = true)
	public List<Announcement> listByPageDown(int offset_row, int page_size);
	
	@Modifying
	@Query(value = "update announcement set a_title=?, a_content=?, a_image=?, a_author=? where a_ID=? ", nativeQuery = true)
	public void modify(String a_title, String a_content, String a_image, String a_author, Integer a_ID);
	
	@Modifying
	@Query(value = "update announcement set isSticky=1 where a_ID=? ", nativeQuery = true)
	public void stick(Integer a_ID);
	
	@Modifying
	@Query(value = "update announcement set isSticky=0 where a_ID=? ", nativeQuery = true)
	public void unstick(Integer a_ID);
	
	@Modifying
	@Query(value = "update announcement set a_view=? where a_ID=? ", nativeQuery = true)
	public void view(Integer view, Integer a_ID);

}
