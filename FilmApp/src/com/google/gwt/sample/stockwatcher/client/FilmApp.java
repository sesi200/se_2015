package com.google.gwt.sample.stockwatcher.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class FilmApp implements EntryPoint {
	
	private VerticalPanel mainPanel = new VerticalPanel();
	private Table mainTable = new Table();
	
	public void onModuleLoad() {
	  
		mainTable.createTable();

		// Add the pager and list to the page.
		mainPanel.add(mainTable.getCellTable());
		mainPanel.add(mainTable.getPager());
		RootPanel.get("Main").add(mainPanel);
   
	}
}

