package serg.task.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Nuff interesting, just one simple method.
 * 
 * 
 * @author Serg Maximchuk
 *
 */
public class MyFirefoxDriver extends FirefoxDriver {
	
	/**
	 * Just shorter method call.
	 * Finding element by XPath
	 * 
	 * @param XPath
	 * @return WebElement
	 */
	public WebElement find(String XPath){
		return this.findElement(By.xpath(XPath));
	}
}