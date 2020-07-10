package com.kxy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kxy.entity.RegionCar;

@Mapper
public interface CarMapper {
	
	List<RegionCar> queryCarInfo();

}
