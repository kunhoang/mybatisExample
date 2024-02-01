package com.fa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.entity.TinhThanh;
import com.fa.mapper.TinhThanhMapper;

@Service
@Transactional
public class TinhThanhService implements ITinhThanh{

	@Autowired
	TinhThanhMapper tinhThanhMapper;
	
	@Override
	public List<TinhThanh> getAll() {
		// TODO Auto-generated method stub
		return tinhThanhMapper.getAll();
	}

	@Override
	public int insert(TinhThanh tinhThanh) {
		// TODO Auto-generated method stub
		return tinhThanhMapper.insert(tinhThanh);
	}

	@Override
	public int update(int id) {
		TinhThanh tt = findById(id);
		if(tt == null) {
			return 0;
		}
		return tinhThanhMapper.update(tt);
	}

	@Override
	public int deleteById(int id) {
		return tinhThanhMapper.deleteById(id);
	}

	@Override
	public TinhThanh findById(int id) {
		// TODO Auto-generated method stub
		return tinhThanhMapper.findById(id);
	}

	@Override
	public TinhThanh search(String tenTT, String password) {
		// TODO Auto-generated method stub
		return tinhThanhMapper.login(tenTT, password);
	}

}
