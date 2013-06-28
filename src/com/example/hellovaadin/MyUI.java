package com.example.hellovaadin;

import java.util.Date;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class MyUI extends UI{

	@WebServlet(value = "/MyUI/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MyUI.class)
	public static class Servlet extends VaadinServlet {
	}
	
	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout content = new VerticalLayout();
		setContent(content);
		// Add a simple component
		Label label = new Label("Hello Vaadin user");
		content.addComponent(label);
		// Add a component with user interaction
		content.addComponent(new Button("Show Error Notification",
				new ClickListener() {
					public void buttonClick(ClickEvent event) {
						Notification.show("The time is " + new Date(),Notification.Type.ERROR_MESSAGE);
					}
				}));
		
		content.addComponent(new Button("Show Warning Notification", new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
				Notification.show("Warning Notification!", "Warning", Notification.Type.WARNING_MESSAGE);
			}
		}));
	}
	
}
