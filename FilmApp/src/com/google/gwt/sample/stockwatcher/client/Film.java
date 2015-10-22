package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;

public class Film {
	
	private String name;
	private float duration;
	private ArrayList<String> genres;
	private ArrayList<String> language;
	private ArrayList<String> countries;
	
	public Film(String name, float duration, ArrayList<String> genres, ArrayList<String> language, ArrayList<String> countries) {
		this.name = name;
		this.duration = duration;
		this.genres = genres;
		this.language = language;
		this.countries = countries;
	}
	
	public String getName() {
		return name;
	}
	public float getDuration() {
		return duration;
	}
	public ArrayList<String> getGenres() {
		return genres;
	}
	public ArrayList<String> getLanguage() {
		return language;
	}
	public ArrayList<String> getCountries() {
		return countries;
	}
	
	

}
