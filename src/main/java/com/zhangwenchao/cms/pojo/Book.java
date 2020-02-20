package com.zhangwenchao.cms.pojo;

public class Book {

	private Integer id;
	private String id2;

	private String name;
	private int type;
	private String phone;
	private String author;
	private int like;
	@Override
	public String toString() {
		return "Book [id=" + id + ", id2=" + id2 + ", name=" + name + ", type=" + type + ", phone=" + phone
				+ ", author=" + author + ", like=" + like + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getId2() {
		return id2;
	}
	public void setId2(String id2) {
		this.id2 = id2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public Book(Integer id, String id2, String name, int type, String phone, String author, int like) {
		super();
		this.id = id;
		this.id2 = id2;
		this.name = name;
		this.type = type;
		this.phone = phone;
		this.author = author;
		this.like = like;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
