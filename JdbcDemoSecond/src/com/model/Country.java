package com.model;

public class Country {
	
	private String Code;
	private String Name;
	//private boolean Continent;
	private String Region;
	private String HeadofState;
	private String Population;
	private String Capital;
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public String getHeadofState() {
		return HeadofState;
	}
	public void setHeadofState(String headofState) {
		HeadofState = headofState;
	}
	public String getPopulation() {
		return Population;
	}
	public void setPopulation(String population) {
		Population = population;
	}
	public String getCapital() {
		return Capital;
	}
	public void setCapital(String capital) {
		Capital = capital;
	}
	public Country(String code, String name, String region, String headofState, String population, String capital) {
		super();
		Code = code;
		Name = name;
		Region = region;
		HeadofState = headofState;
		Population = population;
		Capital = capital;
	}
	
	
	
	
	

}
