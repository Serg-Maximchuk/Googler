package serg.task;

import java.util.Scanner;

import org.openqa.selenium.NoSuchElementException;

import serg.task.driver.MyFirefoxDriver;
import serg.task.tools.ConsoleSpeaking;

/**
 * Class PageWalker. Walks through the page and prints result names to console.
 * 
 * @author Serg Maximchuk
 */
public class PageWalker implements ConsoleSpeaking {
	
	@Override
	public void say( String command ) {
		
		//limiting the message
		command = ( command.length() > LIMIT ) ? 
				command.substring( 0, LIMIT ) + "..." : command;
		
		System.out.println( command );
	}
	
	private MyFirefoxDriver driver;
	
	private int numberOfLinks;
	
	public void setNumberOfLinks( int numberOfLinks ) {
		this.numberOfLinks = numberOfLinks;
	}
	
	/**
	 * Constructor of PageWalker.
	 * 
	 * @param driver - {@linkplain MyFirefoxDriver}
	 */
	public PageWalker( MyFirefoxDriver driver ) {
		this.driver = driver;
	}
	
	/**
	 * Finds link by number, get it's name and prints it to console.
	 */
	public void goThroughPage() {
		
		setNumberOfLinks( driver.getNumberOfLinks() );
		
		if ( numberOfLinks == 0 ) 	//smth wrong? get this message and quit FF
				say( "Somethin wrong. There are no links." );
		
		//cycle that opens all links and prints it's names
		else {	doTheMainTask();
					if ( driver.isNextPageExists() ) 
							askNextPage();
	}	}
	
	/**
	 * Clicks to link, get name, go back, repeat...
	 */
	public void doTheMainTask() {
		
		int i = 1;
		while	( i <= numberOfLinks )	{
			try	{	
				//find link by number, clicking it
				driver.findLinkByNumber( i ).click();
				MyFirefoxDriver.pause();
				
				
				//number + page's title
				say( i + ". " + driver.getTitle() );
				
				//go back
				driver.navigate().back();
				MyFirefoxDriver.pause();
				i++;
			
			}	catch ( NoSuchElementException e )	{
					say( "Page do not loads fully. Seems that your internet or PC is slow." 
							+ "\nTry to increase time constant serg.task.tools.Constants.MSECONDS"
							+ "\nRetrying task..." );
					MyFirefoxDriver.pause();
	}	}	}
	
	/**
	 * Asking about going to the next search page. 
	 * Takes "Y/N" answer.
	 */
	public void askNextPage() {
		say( "Go to the next page? Y/N" );
		
		Scanner input = new Scanner( System.in );
		String answer = input.nextLine();
		
		if ( answer.equalsIgnoreCase( "y" ) ) {
			
			driver.findNextPage().click();		//go to next page
			MyFirefoxDriver.pause();			
			goThroughPage();					//goes through page doing main task
	}	}
}