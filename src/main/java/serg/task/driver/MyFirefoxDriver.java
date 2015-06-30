package serg.task.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import serg.task.tools.Constants;

/**
 * Class MyFirefoxDriver. Extends {@linkplain FirefoxDriver} class.
 * Implements {@linkplain Constants} interface.
 * Contains some convenient methods.
 * 
 * @author Serg Maximchuk
 */
public class MyFirefoxDriver extends FirefoxDriver implements Constants {
	
	/**
	 * Find link by number on google result page.
	 * 
	 * @param num - number of link
	 * @return founded WebElement
	 */
	public WebElement findLinkByNumber(int num) {
		return this.findElement(By.xpath(LINK+"["+num+"]"));
	}
	
	/**
	 * Find next page link.
	 * 
	 * @return next page {@code WebEelement}
	 */
	public WebElement findNextPage() {
		return this.findElement(By.xpath(NEXT_PAGE));
	}
	
	/**
	 * Calculate number of result links. Usually it equals 10, 
	 * but one of them can be a sponsored link, or images etc...
	 * 
	 * @return number of links.
	 */
	public int getNumberOfLinks() {
		return this.findElements(By.xpath(LINK)).size();
	}
	
	/**
	 * Find button "Google".
	 * 
	 * @return button {@code WebEelement}
	 */
	public WebElement findButton() {
		return this.findElement(By.xpath(BUTTON));
	}
	
	/**
	 * Find search field.
	 * 
	 * @return search field {@code WebEelement}
	 */
	public WebElement findSearchField() {
		return this.findElement(By.name("q"));
	}
	
	/**
	 * Short call to pause program. It is time to get page downloads fully, 
	 * and after some time (1 sec) resuming work.
	 */
	public static void pause(){
		
		try {	Thread.sleep(MSECONDS);	}
		
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method that google some {@code String}.
	 * Goes to Google web site, input interested {@code String},
	 * then clicking "Find" button.
	 * 
	 * @param googleThis - {@code String} that will be googled
	 */
	public void google(String googleThis) {
		
		//go to google web-site
		this.get(GOOGLE);
		pause();
		
		//find input field and type word inside
		this.findSearchField().sendKeys(googleThis);
		
		//find button to google smth and clicking it
		this.findButton().click();
		
		pause();	
	}
	
	/**
	 * Method looks is there the Next page.
	 * 
	 * @return {@code true} if next page exists, {@code false} otherwise
	 */
	public boolean isNextPageExists() {
		
		boolean result = true;
		
		try {	this.findNextPage();	}
		
		catch (Exception e) {
			result = false;
		}
		return result;
	}
}