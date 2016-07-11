package com.Model;

public class City
{
	@Override
	public String toString() {
		return "City [ID=" + ID + ", District=" + District + ", Name=" + Name + ", Population=" + Population
				+ ", CountryCode=" + CountryCode + ", getID()=" + getID() + ", getDistrict()=" + getDistrict()
				+ ", getName()=" + getName() + ", getPopulation()=" + getPopulation() + ", getCountryCode()="
				+ getCountryCode() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	private String ID;
	private String District;
	private String Name;
	private String Population;
	private String CountryCode;
	public City()
	{
		
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPopulation() {
		return Population;
	}
	public void setPopulation(String population) {
		Population = population;
	}
	public String getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	public City(String iD, String district, String name) {
		super();
		ID = iD;
		District = district;
		Name = name;
		
	}
	
	
	
	
}
