package com.example.hellovaadin.views;

import com.example.hellovaadin.component.LoginBox;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class StartView extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Navigator navigator;

	public StartView() {
//		Button button = new Button("Go to Main View",
//				new Button.ClickListener() {
//					@Override
//					public void buttonClick(ClickEvent event) {
////						navigator.navigateTo(MAINVIE);
//					}
//				});
		
		LoginBox login = new LoginBox();
		login.setNavigator(navigator);
		addComponent(login);
//		addComponent(button);
		setComponentAlignment(login, Alignment.MIDDLE_CENTER);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Welcome to the Animal Farm");
	}

	public Navigator getNavigator() {
		return navigator;
	}

	public void setNavigator(Navigator navigator) {
		this.navigator = navigator;
	}

}
