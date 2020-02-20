package com.zhangwenchao.cms.pojo;

import java.io.Serializable;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

public class Favorite implements Serializable{
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	 private Integer id;
	 private String texts;
	 private String url;
	 private Integer user_id;
	 private String created;
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTexts() {
		return texts;
	}


	public void setTexts(String texts) {
		this.texts = texts;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public Integer getUser_id() {
		return user_id;
	}


	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}


	public String getCreated() {
		return created;
	}


	public void setCreated(String created) {
		this.created = created;
	}


	@Override
	public String toString() {
		return "Favorite [id=" + id + ", texts=" + texts + ", url=" + url + ", user_id=" + user_id + ", created="
				+ created + "]";
	}


	public Favorite(Integer id, String texts, String url, Integer user_id, String created) {
		super();
		this.id = id;
		this.texts = texts;
		this.url = url;
		this.user_id = user_id;
		this.created = created;
	}


	public Favorite() {
		super();
	}
	 
	    
	 
	 
	
	
	
	

}
