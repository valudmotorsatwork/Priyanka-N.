package com.Model;

public class CountryLanguage {


@Override
	public String toString() {
		return "CountryLanguage [Language=" + Language + ", IsOfficial=" + IsOfficial + ", Percentage=" + Percentage
				+ ", CountryCode=" + CountryCode + ", getCountryCode()=" + getCountryCode() + ", getLanguage()="
				+ getLanguage() + ", isIsOfficial()=" + isIsOfficial() + ", getPercentage()=" + getPercentage()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}


private String Language;
private boolean IsOfficial;
private String Percentage;
private String CountryCode;


public String getCountryCode() {
	return CountryCode;
}
public void setCountryCode(String countryCode) {
	this.CountryCode = countryCode;
}
public String getLanguage() {
	return Language;
}
public void setLanguage(String language) {
	this.Language = language;
}
public boolean isIsOfficial() {
	return IsOfficial;
}
public void setIsOfficial(boolean isOfficial) {
	this.IsOfficial = isOfficial;
}

public String getPercentage() {
	return Percentage;
}
public void setPercentage(String percentage) {
	this.Percentage = percentage;
}

	
public CountryLanguage(String CountryCode,String Language) {
	super();
	this.CountryCode=CountryCode;
	this.Language=Language;
	
}
public CountryLanguage() {}


	
}
