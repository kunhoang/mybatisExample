package com.fa.entity;

public class TinhThanh {

	private int maTT;
	private String tenTT;
	private String password;
	
	
	
	public TinhThanh() {
		super();
	}
	
	public TinhThanh(String tenTT,String password) {
		super();
		this.tenTT = tenTT;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
