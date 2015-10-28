package com.google.gwt.sample.stockwatcher.client;

import com.google.gwt.i18n.client.DateTimeFormat;

import java.util.Date;
import java.util.ArrayList;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Window;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Table{

	private FlexTable filmTable = new FlexTable();
	private ArrayList<Film> films = new ArrayList<Film>();
	private HorizontalPanel ButtonPanel = new HorizontalPanel();
	private Button nextButton = new Button("Next");
	private Button backButton = new Button("Back");
	private int nextCounter = 0;
	private Database database = new Database();
	private int datasize = database.getDatabase().size();
	private static int n_film = 12;

	public FlexTable getFilmTable(){
		return filmTable;
	}
	
	public HorizontalPanel getButtonPanel(){
		return ButtonPanel;
	}
	
	public void createTable () {
		
		//Create table for stock data
	    filmTable.setText(0, 0, "Name");
	    filmTable.setText(0, 1, "Year");
	    filmTable.setText(0, 2, "Duration");
	    filmTable.setText(0, 3, "Language");
	    filmTable.setText(0, 4, "Genre");
	    filmTable.setText(0, 5, "Country");

	    //Add Button to panel
	    ButtonPanel.add(backButton);
	    ButtonPanel.add(nextButton);
	    
	    // Add styles to elements in the table and the next-button.
	    filmTable.setCellPadding(6);
	    filmTable.getRowFormatter().addStyleName(0, "tableHeader");
	    filmTable.addStyleName("table");
	    ButtonPanel.addStyleName("buttonPanel");
	    
		//Default fill table with films
		fillTableNum(nextCounter, n_film);
		nextCounter += n_film;
		
	    // Listen for mouse events on the next button.
		// When button was clicked, show next n_film films
	    nextButton.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	    		nextCounter = fillTableNum(nextCounter, n_film);
	      }
	    });
	    
	    // Listen for mouse events on the back button.
	    // When button was clicked, show previous n_film films
	    backButton.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	    	if(nextCounter-n_film<0){nextCounter=0;}
	    	nextCounter = fillTableNum(nextCounter-2*n_film, n_film);    	
	      }
	    });	
	  
	}
	
	// Add a film to the table.
	private void fillTable(Film film, int i){
		
	  //Converting all values and storing them in String objects
		String name = film.getName();
		int year = film.getYear();		String yearString = year+"";		
		float duration = film.getDuration();		String durationString = duration+"";
		
		//Languages
		ArrayList<String> languages = new ArrayList<String>();
		languages = film.getLanguage();
		String languagesString = new String();
		for(String v: languages){languagesString += v + "/ ";	}
		
		//Genres
		ArrayList<String> genres = new ArrayList<String>();
		genres = film.getGenres();
		String genresString = new String();
		for(String v: genres){genresString += v + " ";	}
		
		//Countries
		ArrayList<String> countries = new ArrayList<String>();
		countries = film.getCountries();
		String countriesString = new String();
		for(String v: countries){countriesString += v + ", ";	}
		
		//int row = filmTable.getRowCount();
		films.add(film);
		filmTable.setText(i, 0, name);
		filmTable.setText(i, 1, yearString);
		filmTable.setText(i, 2, durationString);
		filmTable.setText(i, 3, languagesString);
		filmTable.setText(i, 4, genresString);
		filmTable.setText(i, 5, countriesString);
	
	}
	
	// Fill table with num films
	private int fillTableNum(int position, int num){		
		int new_num;
		if(num>datasize){
			new_num=datasize;
		}
		else 
			new_num = num;
			
		for(int i=0; i<new_num; i++){
			fillTable(database.getFilm(position+i),i+1);	
		}
		return position+num;
	}

}