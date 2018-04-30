package com.sut;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SeleniumTest {

	public static void main(String[] args) throws MalformedURLException {

	    WebDriver chrome = new RemoteWebDriver(new URL("http://52.163.103.33:4444/wd/hub"), new ChromeOptions());
	    WebDriver firefox = new RemoteWebDriver(new URL("http://52.163.103.33:4444/wd/hub"), new FirefoxOptions());

	    try
	    {
		    // run against chrome
		    chrome.get("http://52.163.103.33:8081/helloworld/");
		    WebElement chromeSutHeader = chrome.findElement(By.tagName("h2"));
		    Assert.assertEquals("Hello World!", chromeSutHeader.getText());

		    // run against firefox
		    firefox.get("http://52.163.103.33:8081/helloworld/");
		    WebElement firefoxSutHeader = firefox.findElement(By.tagName("h2"));
		    Assert.assertEquals("Hello World!", firefoxSutHeader.getText());	    	
	    }
	    finally
	    {
		    chrome.quit();
		    firefox.quit();	    	
	    }
		
	}

}
