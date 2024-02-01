package com.fa.mapper;

import com.fa.dto.CustomerDTO;
import com.fa.entity.Customer;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CustomerMapper {
	List<Customer> getAll();
	int insert(Customer customer);
	int update(Customer customer);
	int deleteById(int id);
	Customer findById(int id);
	
	@Select("select * from Customer where name like concat(#{name},'%')")
	List<Customer> searchByName(@Param("name") String name);	
	
	@Select("select c.id,c.name,c.age,c.age,t.TenTT from Customer c, TinhThanh t where c.maTT = t.maTT")
	List<CustomerDTO> listDTO();
}