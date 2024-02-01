package com.fa.entity;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

import com.fa.annotation.CheckAge;

public class Customer {
    
	private int id;
	@NotBlank(message = "Invalid name")
	private String name;
	@CheckAge
	private int age;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@FutureOrPresent(message = "Invalid day")
	private LocalDate birth;
	private int maTT;
	private boolean sex;
	
	
	public Customer() {
		super();
	}
	
	

	public Customer(int id, @NotBlank(message = "Invalid name") String name, int age,
			@FutureOrPresent(message = "Invalid day") LocalDate birth, int maTT, boolean sex) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.birth = birth;
		this.maTT = maTT;
		this.sex = sex;
	}

	
	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}



	public LocalDate getBirth() {
		return birth;
	}



	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}



	public int getMaTT() {
		return maTT;
	}

	public void setMaTT(int maTT) {
		this.maTT = maTT;
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
	
	
}