package com.wendao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wendao.pojo.Airplane;

public interface AirplaneMapper {
	
	List<Airplane> selByTakeidLandid(
			@Param("takeid") int takeid, 
			@Param("landid") int landid);
	
	
	
	
	
}
