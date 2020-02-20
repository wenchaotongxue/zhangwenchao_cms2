package com.zhangwenchao.cms.pojo;

public class Tousu {

	private Integer id;
	private int articleId;
	private int userId;
	private String content;
	private String created;
	@Override
	public String toString() {
		return "Tousu [id=" + id + ", articleId=" + articleId + ", userId=" + userId + ", content=" + content
				+ ", created=" + created + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public Tousu(Integer id, int articleId, int userId, String content, String created) {
		super();
		this.id = id;
		this.articleId = articleId;
		this.userId = userId;
		this.content = content;
		this.created = created;
	}
	public Tousu() {
		super();
		// TODO Auto-generated constructor stub
	}

}
