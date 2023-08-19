package com.manish.studntapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private int id;
	private String name;
	private String disc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisc() {
		return disc;
	}

	public void setDisc(String disc) {
		this.disc = disc;
	}

	public Student(int id, String name, String disc) {
		super();
		this.id = id;
		this.name = name;
		this.disc = disc;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
}
