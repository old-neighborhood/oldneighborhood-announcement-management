package com.oldneighborhood.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oldneighborhood.demo.dao.AnnouncementDao;
import com.oldneighborhood.demo.entity.Announcement;
import com.oldneighborhood.demo.service.AnnouncementService;

@Service
public class AnnouncementServiceImpl implements AnnouncementService{
	
	@Autowired
	private AnnouncementDao announcementDao;
	
	@Override
	public List<Announcement> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Announcement release(Announcement announcement) {
		Announcement newannoucement = announcementDao.saveAndFlush(announcement);
		System.out.println(newannoucement.toString());
		return newannoucement;
	}

	@Override
	public boolean modify(Announcement announcement) {
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean stick(String a_ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String a_ID) {
		
		// TODO Auto-generated method stub
		return false;
	}


}
