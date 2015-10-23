package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;

public class Film {
	
	private String name;
	private int year;
	private float duration;
	private ArrayList<String> genres;
	private ArrayList<String> language;
	private ArrayList<String> countries;
	
	public Film(String name, int year, float duration, ArrayList<String> language, ArrayList<String> genres, ArrayList<String> countries) {
		this.name = name;
		this.year = year;
		this.duration = duration;
		this.language = language;
		this.genres = genres;
		this.countries = countries;
	}
	
	public String getName() {
		return name;
	}
	public float getDuration() {
		return duration;
	}
	public int getYear() {
		return year;
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
