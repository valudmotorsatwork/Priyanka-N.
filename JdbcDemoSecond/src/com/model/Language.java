package com.model;

public class Language
{

	
	private String Language;
	private com.model.City countrycode;
	private boolean IsOfficial;
	private String Percentage;
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	
	
	public boolean isIsOfficial() {
		return IsOfficial;
	}
	public void setIsOfficial(boolean isOfficial) {
		IsOfficial = isOfficial;
	}
	public String getPercentage() {
		return Percentage;
	}
	public void setPercentage(String percentage) {
		Percentage = percentage;
	}
	public Language(String language, String countrycode, boolean isOfficial, String percentage) {
		super();
		Language = language;
	
		IsOfficial = isOfficial;
		Percentage = percentage;
	}
	
	
}
