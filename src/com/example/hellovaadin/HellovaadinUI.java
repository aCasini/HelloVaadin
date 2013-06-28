package com.example.hellovaadin;

import java.util.Date;

import javax.servlet.annotation.WebServlet;

import com.example.hellovaadin.component.bottons.TheButtons;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("hellovaadin")
public class HellovaadinUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = HellovaadinUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		// Create the content root layout for the UI
		VerticalLayout content = new VerticalLayout();
		setContent(content);
		// Add a simple component
		Label label = new Label("Hello Vaadin user");
		content.addComponent(label);
		// Add a component with user interaction
		content.addComponent(new Button("Show Error Notification",
				new ClickListener() {
					public void buttonClick(ClickEvent event) {
						Notification.show("The time is " + new Date(),Notification.TYPE_ERROR_MESSAGE);
					}
				}));
		
		content.addComponent(new Button("Show Warning Notification", new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
				Notification.show("Warning Notification!", "Warning", Notification.TYPE_WARNING_MESSAGE);
			}
		}));
		
		MyComposite myComposite = new MyComposite();
		content.addComponent(myComposite);
		
		TheButtons theButtons = new TheButtons();
		content.addComponent(theButtons);
	}

}