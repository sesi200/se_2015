package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;

public class Database implements IImport, IExport {

	private ArrayList<Film> storage_array;
	private String file = new String(); //FileName location must be set!!
	
	//Create a test-film1 for testing Export function
	private Film createFilm1(){
		ArrayList<String> language = new ArrayList<String>();
		language.add("German");
		language.add("English");
		ArrayList<String> genre = new ArrayList<String>();
		genre.add("Romance");
		ArrayList<String> country = new ArrayList<String>();
		country.add("England");
		country.add("United States of America");
		country.add("Switzerland");
		Film film1 = new Film("film1", 1967, 92.5f, language, genre, country);
		return film1;
	}
	//Create a test-film2 for testing Export function
	private Film createFilm2(){
		ArrayList<String> language = new ArrayList<String>();
		language.add("Spanish");
		language.add("English");
		language.add("Swedisch");
		ArrayList<String> genre = new ArrayList<String>();
		genre.add("Science Fiction");
		genre.add("Action");
		ArrayList<String> country = new ArrayList<String>();
		country.add("England");
		country.add("Switzerland");
		Film film2 = new Film("film2", 2100, 10.5567f, language, genre, country);
		return film2;
	}
	
	public Database(){
		storage_array = new ArrayList<Film>();
		
		for(int i=0; i<50; i++){
			storage_array.add(createFilm1());
			storage_array.add(createFilm1());
			storage_array.add(createFilm1());
			storage_array.add(createFilm1());
			storage_array.add(createFilm2());
			storage_array.add(createFilm2());
		}
	
		//importFile(file);
	}
	
	@Override
	public void exportXML() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exportPNG() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void importFile(String fileLocation) {
		// TODO Auto-generated method stub
		
	}
	
	public void addFilm(Film filmToAdd){
		storage_array.add(filmToAdd);	
	}
	
	public Film getFilm(int i){
		return storage_array.get(i);	
	}
	
	public ArrayList<Film> getDatabase(){
		return storage_array;	
	}
	
	ArrayList<Film> getFilteredData(String filter){
		// TODO Auto-generated method stub
		return null;
	}

}
