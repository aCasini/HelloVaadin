package com.example.hellovaadin.component.error;

import com.vaadin.server.DefaultErrorHandler;
import com.vaadin.server.ErrorEvent;
import com.vaadin.server.ErrorHandler;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;

public class MyError extends DefaultErrorHandler implements ErrorHandler{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Layout layout;
	
	public MyError(Layout layout){
		this.layout = layout;
	}
	
	@Override
	public void error(ErrorEvent event) {
		String cause = "<b>The click failed because:</b><br/>";
		for (Throwable t = event.getThrowable(); t != null; t = t.getCause()){
				if (t.getCause() == null){ 
					// We're at final cause
					cause += t.getClass().getName() + "<br/>";
				}
		}
		// Display the error message in a custom fashion
		layout.addComponent(new Label(cause, ContentMode.HTML));
		// Do the default error handling (optional)
		doDefault(event); 
//		super.error(event);
	}
	
}
