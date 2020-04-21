package com.sahru.assginment.model;

import java.util.Date;

public class Customer {

	private String name;
    private int age;
    private String background;

	public Customer(String name, int age) {
		this.name =name;
		this.age = age;
	}

	public Customer() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}
}