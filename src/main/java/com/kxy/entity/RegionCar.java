package com.kxy.entity;

import java.util.List;

public class RegionCar {

	private Integer regionId;
	
	private String regionName;
	
	private List<SpeciesCar> speciesCarList;

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public List<SpeciesCar> getSpeciesCarList() {
		return speciesCarList;
	}

	public void setSpeciesCarList(List<SpeciesCar> speciesCarList) {
		this.speciesCarList = speciesCarList;
	}
	
	
}
