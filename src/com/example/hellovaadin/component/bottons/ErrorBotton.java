package com.example.hellovaadin.component.bottons;

import com.example.hellovaadin.component.error.MyError;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ErrorBotton extends CustomComponent implements ClickListener{

	private Button button;
	
	public ErrorBotton(){
		button = new Button("Click me to show error", this);
		Layout layout = new VerticalLayout();
		layout.addComponent(button);
		setCompositionRoot(layout);
		
		//Configurazione dell 'errore
		UI.getCurrent().setErrorHandler(new MyError(layout));
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		((String)null).length();
	}
	
}
