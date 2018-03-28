package com.oldneighborhood.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oldneighborhood.demo.dao.AnnouncementDao;
import com.oldneighborhood.demo.entity.Announcement;
import com.oldneighborhood.demo.entity.Page;
import com.oldneighborhood.demo.service.AnnouncementService;

@Service
public class AnnouncementServiceImpl implements AnnouncementService{
	
	@Autowired
	private AnnouncementDao announcementDao;
	
	@Override
	public int count() {
		return (int) announcementDao.count();
	}
	
	@Override
	public List<Announcement> list(Page page) {
		List<Announcement> list = null;
		if (page.isDesc()) {
			list = announcementDao.listByPageDown(page.getOffset_row(), page.getPage_size());
		}else {
			list = announcementDao.listByPageUp(page.getOffset_row(), page.getPage_size());
		}
		System.out.println(list.toString());
		return list;
	}
	
	@Override
	public Announcement getdetail(Integer a_ID) {
		Announcement announce = announcementDao.findOne(a_ID);
		return announce;
	}

	@Override
	@Transactional
	public Announcement release(Announcement announcement) {
		Announcement newannouncement = announcementDao.saveAndFlush(announcement);
		System.out.println(newannouncement.toString());
		return newannouncement;
	}

	@Override
	@Transactional
	public boolean modify(Announcement announcement) {
		boolean flag = false;
		try {
			announcementDao.modify(
					announcement.getA_title(), announcement.getA_content(), announcement.getA_image(), 
					announcement.getA_author(), announcement.getA_ID());
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	@Transactional
	public boolean stick(Integer a_ID) {
		boolean flag = false;
		try {
			announcementDao.stick(a_ID);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	@Transactional
	public boolean unstick(Integer a_ID) {
		boolean flag = false;
		try {
			announcementDao.unstick(a_ID);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}


	@Override
	@Transactional
	public boolean delete(Integer a_ID) {
		boolean flag = false;
		try {
			Announcement annouce = announcementDao.findOne(a_ID);
			announcementDao.delete(annouce);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	@Transactional
	public boolean view(Integer a_ID) {
		Announcement announce = announcementDao.findOne(a_ID);
		announcementDao.view( announce.getA_view() + 1, a_ID);
		return false;
	}
}
