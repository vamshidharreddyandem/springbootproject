package com.memorystack.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "title", columnDefinition = "varchar(45)", nullable = false)
	private String title;

	@Column(name = "location", columnDefinition = "varchar(45)")
	private String location;

	@Column(name = "payrate", columnDefinition = "int")
	private Integer payrate;

	@Column(name = "discription", columnDefinition = "varchar(500)")
	private String discription;

	public Job() {
	}

	public Job(Integer id, String title, String location, Integer payrate, String discription) {
		super();
		this.id = id;
		this.title = title;
		this.location = location;
		this.payrate = payrate;
		this.discription = discription;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getPayrate() {
		return this.payrate;
	}

	public void setPayrate(Integer payrate) {
		this.payrate = payrate;
	}

	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Override
	public String toString() {
		return "Job \nID : " + this.id + "\nTitle : " + this.title + "\nLocation : " + this.location + "\nPayrate : "
				+ this.payrate + "\nDiscription : \n" + this.discription;
	}
}
