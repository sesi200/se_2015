package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;
import org.junit.Test;

public class AddFilm {

	@Test
	public void test() {
		//Create a test-film1 for testing Export function
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

		//Create a test-film2 for testing Export function
			ArrayList<String> language2 = new ArrayList<String>();
			language2.add("Spanish");
			language2.add("English");
			language2.add("Swedisch");
			ArrayList<String> genre2 = new ArrayList<String>();
			genre2.add("Science Fiction");
			genre2.add("Action");
			ArrayList<String> country2 = new ArrayList<String>();
			country2.add("England");
			country2.add("Switzerland");
			Film film2 = new Film("film2", 2100, 10.5567f, language2, genre2, country2);
			
			Database testdata = new Database();
			testdata.addFilm(film1);
			testdata.addFilm(film2);		
	}

}
