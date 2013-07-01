package com.example.hellovaadin.component;

import com.example.hellovaadin.HellovaadinUI;
import com.example.hellovaadin.views.StartView;
import com.example.services.MockLogin;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

public class LoginBox extends CustomComponent implements ClickListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Panel 			panel = new Panel("Log In");
	private TextField		userName = new TextField("User Name");
	private PasswordField	passText = new PasswordField("password");
	private Button			loginBtn = new Button("Login");
	private Navigator		navigator;
	
	public LoginBox(){
		FormLayout content = new FormLayout();
		content.addComponent(userName);
		content.addComponent(passText);
		content.addComponent(loginBtn);
		loginBtn.addClickListener(this);
		panel.setContent(content);
		panel.setId("LoginPanel");
		//Setting della dimensione del pannello
		panel.setWidth("300");
		
		setCompositionRoot(panel);
		
	}

	@Override
	public void buttonClick(ClickEvent event) {
		//Recupero i valori per il login
		String usernameValue = userName.getValue();
		String passwordValue = passText.getValue();
		if(usernameValue == null || usernameValue.equalsIgnoreCase("")){
			Notification.show("Inserire un nome utente per il login!", Notification.Type.ERROR_MESSAGE);
		}else if(passwordValue == null || passwordValue.equalsIgnoreCase("")){
			Notification.show("Inserire una password per il login!", Notification.Type.ERROR_MESSAGE);
		}else {
			Boolean resultLogin = MockLogin.loginAction(usernameValue, passwordValue);
			if(resultLogin){
				Notification.show("Login Riuscito correttanebte!!", "login action", Notification.Type.HUMANIZED_MESSAGE);
				((StartView)getParent()).getNavigator().navigateTo(HellovaadinUI.MAINVIEW);
//				panel.setVisible(false);
			}else{
//				JavaScript.getCurrent().execute("alert('PIPPO')");
				Notification.show("Utente non abilitato!", Notification.Type.ERROR_MESSAGE);
			}
	
			
		}
	}

	public Navigator getNavigator() {
		return navigator;
	}

	public void setNavigator(Navigator navigator) {
		this.navigator = navigator;
	}

}
