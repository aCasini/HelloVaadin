package com.example.hellovaadin;

import javax.servlet.annotation.WebServlet;

import com.example.hellovaadin.views.MainView;
import com.example.hellovaadin.views.StartView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("hellovaadin")
public class HellovaadinUI extends UI {
	private Navigator 				navigator = new Navigator(this, this);
	public static final String 		MAINVIEW = "main";
	
	@WebServlet(value = "/Hello/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = HellovaadinUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		// Create the content root layout for the UI
//		VerticalLayout layout = new VerticalLayout();
//		setContent(content);
		// Add a simple component
//		Label label = new Label("Hello Vaadin user");
//		content.addComponent(label);
//		// Add a component with user interaction
//		content.addComponent(new Button("Show Error Notification",
//				new ClickListener() {
//					public void buttonClick(ClickEvent event) {
//						Notification.show("The time is " + new Date(),Notification.Type.ERROR_MESSAGE);
//					}
//				}));
//		
//		content.addComponent(new Button("Show Warning Notification", new ClickListener() {
//			
//			@Override
//			public void buttonClick(ClickEvent event) {
//				
//				Notification.show("Warning Notification!", "Warning", Notification.Type.WARNING_MESSAGE);
//			}
//		}));
		
//		MyComposite myComposite = new MyComposite();
//		content.addComponent(myComposite);
//		
//		TheButtons theButtons = new TheButtons();
//		content.addComponent(theButtons);
//		
//		ErrorBotton errorButton = new ErrorBotton();
//		content.addComponent(errorButton);
		
		getPage().setTitle("Gaming wiht Vaadin");
		
//		LoginBox login = new LoginBox();
//		setContent(login);
		
		//Creazione della Navigation per il controllo della View
		//Creazione e Registrazione della View
		StartView startView = new StartView();
		startView.setNavigator(navigator);
		navigator.addView("", startView);
		
		MainView mainView = new MainView();
		mainView.setNavigator(navigator);
		navigator.addView(MAINVIEW, mainView);
		
	}

	public Navigator getNavigator() {
		return navigator;
	}

	public void setNavigator(Navigator navigator) {
		this.navigator = navigator;
	}

	public static String getMainview() {
		return MAINVIEW;
	}
	
}