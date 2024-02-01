package com.fa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.dto.CustomerDTO;
import com.fa.entity.Customer;
import com.fa.mapper.CustomerMapper;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerMapper customerMapper;
	
	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return customerMapper.getAll();
	}

	@Override
	public int insert(Customer customer) {
		// TODO Auto-generated method stub
		return customerMapper.insert(customer);
	}

	@Override
	public int update(Customer customer) {
		return customerMapper.update(customer);
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return customerMapper.deleteById(id);
	}

	@Override
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		return customerMapper.findById(id);
	}

	@Override
	public List<Customer> search(String name) {
		// TODO Auto-generated method stub
		return customerMapper.searchByName(name);
	}

	@Override
	public List<CustomerDTO> listAll() {
		// TODO Auto-generated method stub
		return customerMapper.listDTO();
	}

//	@Override
//	public List<String> getName() {
//		List<Customer> list = getAll();
//		List<String> getName = new ArrayList<>();
//		for (Customer customer : list) {
//			getName.add(customer.getName());
//		}
//		return getName;
//	}

}
