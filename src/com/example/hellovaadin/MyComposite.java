package com.example.hellovaadin;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;

/**
 * Classe Custom per la creazione di un nuovo componente
 * Implementazione del Listener @ClickListener
 * @author kaso
 *
 */
public class MyComposite extends CustomComponent implements ClickListener{
	
	Button button;
	
	public MyComposite() {
		//Definizione di in layout orizzontale
		Layout layout = new HorizontalLayout();
		
		button = new Button("Do not push this");
		button.addClickListener(this);
		layout.addComponent(button);
		
		setCompositionRoot(layout);
	}


	@Override
	public void buttonClick(ClickEvent event) {
		button.setCaption("Do not push this again!");
	}
}
