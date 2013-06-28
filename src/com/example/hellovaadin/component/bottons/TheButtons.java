package com.example.hellovaadin.component.bottons;

import com.vaadin.server.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.TextField;

public class TheButtons extends CustomComponent implements ClickListener{
	
	private Button 		oneButton;
	private Button 		tooButton;
	private TextField 	textField;

	public TheButtons(){
		oneButton = new Button("Botton One", this);
		oneButton.setComponentError(new UserError("Bad Click"));
		tooButton = new Button("A Button Too", this);
		textField = new TextField();
		textField.setComponentError(new UserError("Bad Value"));
		
		//Mettiamo adesso i bottoni in un qualche layout
		Layout root = new HorizontalLayout();
		root.addComponent(oneButton);
		root.addComponent(tooButton);
		setCompositionRoot(root);
	}
	
	
	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton() == oneButton){
			oneButton.setCaption("Pushed ONE");
		}else{
			tooButton.setCaption("Pushed TOO");
		}
	}

}
