package serg.task.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import serg.task.tools.Const;

/**
 * Class MyFirefoxDriver. Extends {@linkplain FirefoxDriver} class.
 * Contains some convenient methods for finding Google result page elements.
 * Contains {@code google} method that goes to Google web site, input interested 
 * {@code String}, then clicking "Find" button..
 * 
 * @author Serg Maximchuk
 */
public class MyFirefoxDriver extends FirefoxDriver {
	
	/**
	 * Pause time, equals 1 sec. It's given to see the page before do smth with it.
	 */
	final static int MSECONDS = 1000;
	
	/**
	 * Find link by number on google result page.
	 * 
	 * @param num - number of link
	 * @return founded WebElement
	 */
	public WebElement findLinkByNumber( int num ) {
		return this.findElement( By.xpath( Const.LINK+"["+num+"]" ));
	}
	
	/**
	 * Find next page link.
	 * 
	 * @return next page {@code WebEelement}
	 */
	public WebElement findNextPage() {
		return this.findElement( By.xpath( Const.NEXT_PAGE.toString() ));
	}
	
	/**
	 * Calculate number of result links. Usually it equals 10, 
	 * but one of them can be a sponsored link, or images etc...
	 * 
	 * @return number of links.
	 */
	public int getNumberOfLinks() {
		return this.findElements( By.xpath( Const.LINK.toString() )).size();
	}
	
	/**
	 * Find button "Google".
	 * 
	 * @return button {@code WebEelement}
	 */
	public WebElement findButton() {
		return this.findElement( By.xpath( Const.BUTTON.toString() ));
	}
	
	/**
	 * Find search field.
	 * 
	 * @return search field {@code WebEelement}
	 */
	public WebElement findSearchField() {
		return this.findElement( By.name( "q" ) );
	}
	
	/**
	 * Short call to pause program. It is time to get page downloads fully, 
	 * and after some time (1 sec) resuming work.
	 */
	public static void pause() {
		
		try {	Thread.sleep(MSECONDS);	}
		
		catch ( InterruptedException e ) {
			e.printStackTrace();
	}	}
	
	/**
	 * Method that google some {@code String}.
	 * Goes to Google web site, input interested {@code String},
	 * then clicking "Find" button.
	 * 
	 * @param googleThis - {@code String} that will be googled
	 */
	public void google( String googleThis ) {
		
		//go to google web-site
		this.get( "http://www.google.com" );
		pause();
		
		//find input field and type word inside
		this.findSearchField().sendKeys( googleThis );
		
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
		
		catch ( NoSuchElementException e ) {
			result = false;
		}
		return result;
	}
}