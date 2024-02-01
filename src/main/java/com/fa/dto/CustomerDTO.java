package com.fa.dto;

import javax.validation.constraints.NotBlank;

import com.fa.annotation.CheckAge;

public class CustomerDTO {
	private int id;
	private String name;
	private int age;
	private int maTT;
	private String tenTT;
	
	public CustomerDTO(int id, String name, int age, int maTT, String tenTT) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.maTT = maTT;
		this.tenTT = tenTT;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMaTT() {
		return maTT;
	}

	public void setMaTT(int maTT) {
		this.maTT = maTT;
	}

	public String getTenTT() {
		return tenTT;
	}

	public void setTenTT(String tenTT) {
		this.tenTT = tenTT;
	}
	
	
}
