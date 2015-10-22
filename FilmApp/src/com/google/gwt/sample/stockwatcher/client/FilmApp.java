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

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class FilmApp implements EntryPoint {
	
	private Button exportButton = new Button("Export as XML");
	private HorizontalPanel exportPanel = new HorizontalPanel();
	final Database database = new Database();
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		exportPanel.add(exportButton);
		
		// We can add style names to widgets
		exportButton.addStyleName("exportButton");

		// Add the exportButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("Export").add(exportButton);

		// Create a handler for the exportButton
		class MyHandler implements ClickHandler{
			/**
			 * Fired when the user clicks on the exportButton.
			 */
			public void onClick(ClickEvent event) {
				database.exportXML();
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		exportButton.addClickHandler(handler);
	}
}
