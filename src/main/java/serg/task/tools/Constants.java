package serg.task.tools;

/**
 * Simple interface with constant values.
 * 
 * @author Serg Maximchuk
 */
public interface Constants {
	
	/**
	 * Google web-site address.
	 */
	final static String GOOGLE = "http://www.google.com";
	
	/**
	 * Button to google smth.
	 */
	final static String BUTTON = "//button[@name='btnG']";
	
	/**
	 * Casual link of result page.
	 */
	final static String LINK = "(//h3[@class='r']/a)";
	
	/**
	 * Link of next result page.
	 */
	final static String NEXT_PAGE = "(//td[@class='b navend']/a[@id='pnnext'])";
	
	/**
	 * Pause time, equals 1 sec. It's given to see the page before do smth with it.
	 */
	final static int MSECONDS = 1000;
}