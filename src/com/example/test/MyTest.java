package com.example.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.gwt.i18n.shared.FirstStrongDirectionEstimator;
import com.vaadin.testbench.TestBenchTestCase;

public class MyTest extends TestBenchTestCase{
	private String 					baseUrl;
	private StringBuffer 			verificationErrors = new StringBuffer();
	private PhantomJSDriver 		pjsDriver;
	
	private final String			USER_NAME = "alessio.casini";
	private final String			USER_PASSWORD = "Pippo123";
	
	@Before
	public void setUp() throws Exception{
		pjsDriver = new PhantomJSDriver(DesiredCapabilities.phantomjs());
		baseUrl = "http://localhost:8080/HelloVaadins/";
		pjsDriver.get(baseUrl);
	}
	
	@Test
	public void testCase() throws Exception{
		baseUrl = "http://localhost:8080/HelloVaadin/";
		pjsDriver.get(baseUrl);
		
		//Clicca sul Bottone di Login
		WebElement loginBtn 		= pjsDriver.findElement(By.id("loginBtn"));
		WebElement userNameTxt		= pjsDriver.findElement(By.id("userNameTxt"));
		WebElement passwordTxt		= pjsDriver.findElement(By.id("passTxt"));
		String loginBtnText = loginBtn.getText();
		//Controllo che abbia il nome correttto e che sia visualizzato
		Assert.assertEquals("Login", loginBtnText);
		
		userNameTxt.clear();
		userNameTxt.sendKeys("alessio.casini");
		passwordTxt.clear();
		passwordTxt.sendKeys("Pippo123");
		//Recupero del valore dalla text
		String valuePassword = passwordTxt.getAttribute("value");
		String valueUsername = userNameTxt.getAttribute("value");
		
		
		Assert.assertEquals(USER_NAME, valueUsername);
		Assert.assertEquals(USER_PASSWORD, valuePassword);
		
		loginBtn.click();
		
		WebElement panelMenu		= pjsDriver.findElement(By.id("PanelMenu"));
		Assert.assertEquals("List of Equals", panelMenu.getText());
		
	}
	
	@Test
	public void testCase2() throws Exception{
		baseUrl = "http://localhost:8080/elloVaadin/";
		pjsDriver.get(baseUrl);
	}
}
