package com.fa.service;

import java.util.List;
import com.fa.entity.TinhThanh;

public interface ITinhThanh {
	List<TinhThanh> getAll();
	int insert(TinhThanh tinhThanh);
	int update(int id);
	int deleteById(int id);
	TinhThanh findById(int id);
	TinhThanh search(String tenTT,String password);
}
