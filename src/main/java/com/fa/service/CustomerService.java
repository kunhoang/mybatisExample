package com.fa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fa.dto.CustomerDTO;
import com.fa.entity.Customer;

public interface CustomerService {

	List<Customer> getAll();
	int insert(Customer customer);
	int update(Customer customer);
	int deleteById(int id);
	Customer findById(int id);
	List<Customer> search(String name);
	List<CustomerDTO> listAll();
}
