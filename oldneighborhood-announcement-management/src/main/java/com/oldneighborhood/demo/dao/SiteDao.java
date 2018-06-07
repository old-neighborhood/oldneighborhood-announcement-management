package com.oldneighborhood.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.oldneighborhood.demo.entity.Site;

public interface SiteDao extends JpaRepository<Site, Integer>{
	@Query(value = "select * from site order by a_date desc limit ?, ? ", nativeQuery = true)
	public List<Site> listByPage(int offset_row, int page_size);
	
	@Query(value = "select * from site where site_name like ? ", nativeQuery = true)
	public List<Site> findByNameLike(String name);
	
	@Query(value = "select * from site where site_name = ? ", nativeQuery = true)
	public Site findByName(String sitename);
	
	//部分完善
	@Modifying
	@Query(value = "update site set site_image = ?, site_intro = ? where site_ID = ? ", 
			nativeQuery = true) 
	public void updateSitePart(String site_image, String site_intro, Integer site_ID);
	
	@Modifying
	@Query(value = "update site set site_name = ?, site_address = ?, site_ticket = ?, "
			+ "site_time = ?, site_tele = ? where site_ID = ? ", 
			nativeQuery = true) 
	public void updateSiteUp(String site_name, String site_address, String site_ticket, 
			String site_time, String site_tele, Integer site_ID);
	
	@Modifying
	@Query(value = "update site "
					+ "set site_name = ?, site_address = ?, site_image = ?, "
					+ "site_intro = ?, site_tele = ?, site_web = ?, "
					+ "site_email = ?, site_ticket = ?, site_time = ? "
					+ "where site_ID = ? ", 
			nativeQuery = true) 
	public void updateSite(String site_name, String site_address, 
			String site_image, String site_intro, String site_tele, 
			String site_wed, String site_email, Double site_ticket, 
			String site_time, Integer site_ID);
	
	@Modifying
	@Query(value="update site set site_state = 'CLOSED' where site_ID = ? ", nativeQuery = true)
	public void closeSite(Integer site_ID);
	
	@Modifying
	@Query(value="update site set site_type = ? where site_ID = ? ", nativeQuery = true)
	public void changeType(String site_type, Integer site_ID);
}
