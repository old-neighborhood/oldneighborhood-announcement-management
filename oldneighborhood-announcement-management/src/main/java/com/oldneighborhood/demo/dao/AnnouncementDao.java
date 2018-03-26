package com.oldneighborhood.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oldneighborhood.demo.entity.Announcement;

public interface AnnouncementDao extends JpaRepository<Announcement, Long>{

}
