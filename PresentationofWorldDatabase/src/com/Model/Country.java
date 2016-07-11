package com.Model;

public class Country 
{
 
	@Override
	public String toString() {
		return "Country [Code=" + Code + ", Name=" + Name + ", Continent=" + Continent + ", Region=" + Region
				+ ", Population=" + Population + ", HeadOfState=" + HeadOfState + ", Capital=" + Capital + ", language="
				+ language + ", city=" + city + ", getCode()=" + getCode() + ", getName()=" + getName()
				+ ", getContinent()=" + getContinent() + ", getRegion()=" + getRegion() + ", getPopulation()="
				+ getPopulation() + ", getHeadOfState()=" + getHeadOfState() + ", getCapital()=" + getCapital()
				+ ", getLanguage()=" + getLanguage() + ", getCity()=" + getCity() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	private String Code;
	private String Name;
	private String Continent;
	private String Region;
	private String Population;
	private String HeadOfState;
	private String Capital;
	private CountryLanguage language;
	private City city;
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
	public String getContinent() {
		return Continent;
	}
	public void setContinent(String continent) {
		Continent = continent;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public String getPopulation() {
		return Population;
	}
	public void setPopulation(String population) {
		Population = population;
	}
	public String getHeadOfState() {
		return HeadOfState;
	}
	public void setHeadOfState(String headOfState) {
		HeadOfState = headOfState;
	}
	public String getCapital() {
		return Capital;
	}
	public void setCapital(String capital) {
		Capital = capital;
	}
	public CountryLanguage getLanguage() {
		return language;
	}
	public void setLanguage(CountryLanguage language) {
		this.language = language;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	
	
	
	
}
