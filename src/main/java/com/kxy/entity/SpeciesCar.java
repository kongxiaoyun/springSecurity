package com.kxy.entity;

import java.util.List;

public class SpeciesCar {
	
	private Integer speciesId;
	
	private Integer regionId;
	
	private String speciesName;
	
	private List<TypeCar> typeCarList;

	public Integer getSpeciesId() {
		return speciesId;
	}

	public void setSpeciesId(Integer speciesId) {
		this.speciesId = speciesId;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getSpeciesName() {
		return speciesName;
	}

	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}

	public List<TypeCar> getTypeCarList() {
		return typeCarList;
	}

	public void setTypeCarList(List<TypeCar> typeCarList) {
		this.typeCarList = typeCarList;
	}
	
	

}
