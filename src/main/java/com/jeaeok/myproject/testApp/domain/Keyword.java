package com.jeaeok.myproject.testApp.domain;

import java.time.LocalDateTime;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Keyword {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long num;
	
	private String query;
	@Convert(converter = CategoryGroupCode.class)
	private String category_group_code;
	private String x;
	private String y;
	private Long radius;
	private String rect;
	private Integer page;
	private Integer size;
	private String sort;
	
	@CreationTimestamp
    private LocalDateTime createdTime;
	
	@ManyToOne(targetEntity=User.class, fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getCategory_group_code() {
		return category_group_code;
	}
	public void setCategory_group_code(String category_group_code) {
		this.category_group_code = category_group_code;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public Long getRadius() {
		return radius;
	}
	public void setRadius(Long radius) {
		this.radius = radius;
	}
	public String getRect() {
		return rect;
	}
	public void setRect(String rect) {
		this.rect = rect;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
