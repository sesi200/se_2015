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
	private HorizontalPanel nextButtonPanel = new HorizontalPanel();
	private Button nextButton = new Button("Next");
	private int nextCounter = 0;
	private Database database = new Database();

	public FlexTable getFilmTable(){
		return filmTable;
	}
	
	public HorizontalPanel getNextButtonPanel(){
		return nextButtonPanel;
	}
	
	public Button getNextButton(){
		return nextButton;
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
	    nextButtonPanel.add(nextButton);
	    
	    // Add styles to elements in the table and the next-button.
	    filmTable.setCellPadding(6);
	    filmTable.getRowFormatter().addStyleName(0, "tableHeader");
	    filmTable.addStyleName("table");
	    nextButtonPanel.addStyleName("buttonPanel");
	    
		//Default fill table with 10 films
		fillTable10(nextCounter);
		nextCounter+=10;
		
	    // Listen for mouse events on the Add button.
	    nextButton.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	  		fillTable10(nextCounter);
	  		nextCounter+=10;
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
		for(String v: languages){languagesString += v + " ";	}
		
		//Genres
		ArrayList<String> genres = new ArrayList<String>();
		genres = film.getGenres();
		String genresString = new String();
		for(String v: genres){genresString += v + " ";	}
		
		//Countries
		ArrayList<String> countries = new ArrayList<String>();
		countries = film.getCountries();
		String countriesString = new String();
		for(String v: countries){countriesString += v + " ";	}
		
		//int row = filmTable.getRowCount();
		films.add(film);
		filmTable.setText(i, 0, name);
		filmTable.setText(i, 1, yearString);
		filmTable.setText(i, 2, durationString);
		filmTable.setText(i, 3, languagesString);
		filmTable.setText(i, 4, genresString);
		filmTable.setText(i, 5, countriesString);
	
	}
	
	private void fillTable10(int position){		
  		position--;
		for(int i=1; i<10; i++){
			fillTable(database.getFilm(position+i),i);	
		}		
	}

}