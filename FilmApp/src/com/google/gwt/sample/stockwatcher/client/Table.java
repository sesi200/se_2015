package com.google.gwt.sample.stockwatcher.client;

import com.google.gwt.i18n.client.DateTimeFormat;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
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
import com.google.gwt.view.client.ListDataProvider;

public class Table{
	 private Database data = new Database(50);
	 private static int rowNumber = 15;
	 private List<Film> list = data.getDatabase();
	 private SimplePager pager = new SimplePager();
	 private ListDataProvider<Film> dataProvider = new ListDataProvider<Film>();
	 private CellTable<Film> cellTable = new CellTable<Film>();
	 
	 public CellTable<Film> getCellTable(){
		 return cellTable;
	 }
	 
	 public SimplePager getPager(){
		 return pager;
	 }
	 
	 public void createTable(){	    

	    // Create name column.
	    TextColumn<Film> nameColumn = new TextColumn<Film>() {
	      @Override
	      public String getValue(Film film) {
	        return film.getName();
	      }
	    };

	    // Create year column.
	    TextColumn<Film> yearColumn = new TextColumn<Film>() {
	      @Override
	      public String getValue(Film film) {
	        return film.getYear()+"";
	      }
	    };
	    
	    // Create duration column.
	    TextColumn<Film> durationColumn = new TextColumn<Film>() {
	      @Override
	      public String getValue(Film film) {
	        return film.getDuration()+"";
	      }
	    };
	    
	    // Create genre column.
	    TextColumn<Film> genreColumn = new TextColumn<Film>() {
	      @Override
	      public String getValue(Film film) {
	  		ArrayList<String> genres = film.getGenres();
	  		String genresString = new String();
	  		for(String v: genres){genresString += v + " ";	}
	        return genresString;
	      }
	    };
	    
	    // Create language column.
	    TextColumn<Film> languageColumn = new TextColumn<Film>() {
	      @Override
	      public String getValue(Film film) {
	  		ArrayList<String> languages = film.getLanguage();
	  		String languagesString = new String();
	  		for(String v: languages){languagesString += v + "/ ";	}
		    return languagesString;
		  }
		};
		    
		  // Create country column.
		  TextColumn<Film> countryColumn = new TextColumn<Film>() {
		    @Override
	     public String getValue(Film film) {
	 		ArrayList<String> countries = film.getCountries();
	 		String countriesString = new String();
		 	for(String v: countries){countriesString += v + ", ";	}
		 	return countriesString;
		   }
		 };
		 
		// Add the columns to panel.
	    cellTable.addColumn(nameColumn, "Name");
	    cellTable.addColumn(yearColumn, "Year");
	    cellTable.addColumn(durationColumn, "Duration");
	    cellTable.addColumn(genreColumn, "Genre");
	    cellTable.addColumn(languageColumn, "Language");
	    cellTable.addColumn(countryColumn, "Country");
		
	    // Set the total row count.
	    cellTable.setRowCount(data.getDatabase().size(), true);
		
	    // Push the data into the widget.
	    cellTable.setRowData(0, data.getDatabase());
	   
	    // set number of rows to be displayed by pager
	    pager.setDisplay(cellTable);
	    pager.setPageSize(rowNumber);
	    
		// use dataProvider (used for pager)
	    dataProvider.addDataDisplay(cellTable);
	    dataProvider.setList(list);	  
 }
}