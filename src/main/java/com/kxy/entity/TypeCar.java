package com.kxy.entity;

import java.util.List;

public class TypeCar {
	
	private Integer typeId;
	
	private Integer speciesId;
	
	private String typeName;
	
	private List<NameCar> nameCarList;

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getSpeciesId() {
		return speciesId;
	}

	public void setSpeciesId(Integer speciesId) {
		this.speciesId = speciesId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<NameCar> getNameCarList() {
		return nameCarList;
	}

	public void setNameCarList(List<NameCar> nameCarList) {
		this.nameCarList = nameCarList;
	}
	
	

}
