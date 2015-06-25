package serg.task.tools;

/**
 * Just interface with constant values.
 * 
 * @author Serg Maximchuk
 */
public interface MyConstants {
	
	/**
	 * Google web-site address
	 */
	final static String GOOGLE = "http://www.google.com";
	
	/**
	 * Input field
	 */
	final static String INPUT = "//input[@type='text']";
	
	/**
	 * Button to google smth
	 */
	final static String BUTTON = "//button[@name='btnG']";
	
	/**
	 * Casual link on result page
	 */
	final static String LINK = "(//h3[@class='r']/a)";
	
	/**
	 * Pause time, equals 3 sec. To upload all page
	 * before do smth with data.
	 */
	final static int MSECONDS = 3000;
	
	/**
	 * Limit symbols in string message
	 */
	final static byte LIMIT = 100;

}
