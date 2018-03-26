package com.oldneighborhood.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="announcement")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Announcement implements Serializable{
	private static final long serialVersionUID = 3127219252441967623L;
	
	@Id
	private Long a_ID;
	@NonNull
	private String a_title;
	@NonNull
	private String a_content;
	private String a_image;
	private String a_author;
	@Column(columnDefinition="int default 0")
	private Integer a_view;
	@Column(columnDefinition="timestamp default now()")
	private Timestamp a_date;
	
	private String ad_ID;
	@Column(columnDefinition="tinyint default 0")
	private Boolean isSticky;
	
	

}
