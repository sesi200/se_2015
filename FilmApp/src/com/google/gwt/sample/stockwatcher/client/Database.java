package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;

public class Database implements IImport, IExport {

	private ArrayList<Film> storage_array;
	private String file = new String(); //FileName location must be set!!
	
	public Database(){
		storage_array = new ArrayList<Film>();
		importFile(file);
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
		// TODO Auto-generated method stub
		
	}
	
	ArrayList<Film> getFilteredData(String filter){
		// TODO Auto-generated method stub
		return null;
	}

}
