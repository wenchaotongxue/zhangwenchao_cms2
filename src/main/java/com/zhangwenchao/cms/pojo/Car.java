package com.zhangwenchao.cms.pojo;

public class Car { 
	private Integer id;
	private String created;
	private String plate;
	private String type;
	private Double lon = 121.446014;
	private Double lat= 31.215937;
	private int juli;
	@Override
	public String toString() {
		return "Car [id=" + id + ", created=" + created + ", plate=" + plate + ", type=" + type + ", lon=" + lon
				+ ", lat=" + lat + ", juli=" + juli + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public int getJuli() {
		return juli;
	}
	public void setJuli(int juli) {
		this.juli = juli;
	}
	public Car(Integer id, String created, String plate, String type, Double lon, Double lat, int juli) {
		super();
		this.id = id;
		this.created = created;
		this.plate = plate;
		this.type = type;
		this.lon = lon;
		this.lat = lat;
		this.juli = juli;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
