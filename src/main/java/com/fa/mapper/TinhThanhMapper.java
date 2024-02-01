package com.fa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.fa.entity.TinhThanh;
@Mapper
public interface TinhThanhMapper {

	List<TinhThanh> getAll();
	int insert(TinhThanh tinhThanh);
	int update(TinhThanh tinhThanh);
	int deleteById(int id);
	TinhThanh findById(int id);
	
	@Select("select * from TinhThanh where tenTT like concat('%',#{tenTT},'%') and password like concat ('%',#{password},'%')")
	TinhThanh login(@Param("tenTT") String tenTT,@Param("password") String password);
}
