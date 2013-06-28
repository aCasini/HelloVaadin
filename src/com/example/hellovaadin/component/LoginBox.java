package com.example.hellovaadin.component;

import java.awt.Panel;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

public class LoginBox extends CustomComponent{
	
	private Panel panel = new Panel();;
	
	public LoginBox(){
		FormLayout content = new FormLayout();
		content.addComponent(new TextField("User Name"));
		content.addComponent(new TextField("Password:"));
		content.addComponent(new Button("Login"));
		
		setCompositionRoot(content);
		
	}

}
