package com.example.hellovaadin;

import javax.servlet.annotation.WebServlet;

import com.example.hellovaadin.component.LoginBox;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("hellovaadin")
public class HellovaadinUI extends UI {

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
		
		LoginBox login = new LoginBox();
		setContent(login);
		
	}

}