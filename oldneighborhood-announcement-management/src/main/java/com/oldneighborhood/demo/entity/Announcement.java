package com.oldneighborhood.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="announcement")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class Announcement implements Serializable{
	private static final long serialVersionUID = 3127219252441967623L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer a_ID;
	@NonNull
	private String a_title;
	@NonNull
	private String a_content;
	private String a_image;
	private String a_author;
	@Column(columnDefinition="int default 0")
	private Integer a_view;
//	@Column(columnDefinition="timestamp not null default now()", updatable=false)
	@Column(columnDefinition="timestamp not null default now()")
	private Timestamp a_date;
	
	private Integer ad_ID;
	@Column(columnDefinition="tinyint not null default 0")
	private Boolean isSticky;
	//新建公告的参数
	public Announcement(String a_title, String a_content, String a_image, String a_author, Integer ad_ID) {
		super();
		this.a_title = a_title;
		this.a_content = a_content;
		this.a_image = a_image;
		this.a_author = a_author;
		this.ad_ID = ad_ID;
	}
	
	//修改公告的参数
	public Announcement(String a_title, String a_content, String a_image, String a_author) {
		super();
		this.a_title = a_title;
		this.a_content = a_content;
		this.a_image = a_image;
		this.a_author = a_author;
	}
	
}
