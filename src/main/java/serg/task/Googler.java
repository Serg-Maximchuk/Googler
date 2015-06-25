package serg.task;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import serg.task.driver.MyFirefoxDriver;
import serg.task.tools.MyConstants;

/**
 * Class Googler. Google smth and prints to console 
 * name of window by clicking on every result link 
 * on first page.
 * 
 * @author Serg Maximchuk
 */
public class Googler implements MyConstants {
	
	/**
	 * Just short method call and limited message length
	 * 
	 * @param command - a command that needs to print
	 */
	public static void say(String command){
		
		//limiting the message
		command = (command.length() > LIMIT) ? 
				command.substring(0, LIMIT)+"..." : command;
		
		System.out.println(command);
	}
	
	/**
	 * Method asks to input word which will be googled
	 * 
	 * @return word - word that need to google
	 */
	public static String getWord() {
		
		Scanner input;
		
		String word = "";
		
		printFirstMessage();
		
		input = new Scanner(System.in);
		word = input.nextLine();
		
		//if you dont input any word
		if (word.equals("")||word.equals(" ")) {
			
			printBadMessage();
			word = getWord();
		}
		
		input.close();
		return word;
	}
	
	/**
	 * ask to input interested word
	 */
	public static void printFirstMessage(){
		say("Just type what you want to google ");
	}
	
	/**
	 * if you input nothing
	 */
	public static void printBadMessage(){
		say("Type somethig ");
	}
	
	/**
	 * Short way to pause programm
	 * if internetS r slow, or bad machine,
	 * the page might not downloads fully.
	 * This time is given for downloading the page,
	 * and after some time (3 sec) resuming work.
	 * Maybe u dont need this, but my PC is VERY slow.
	 */
	public static void pause(){
		
		try {	Thread.sleep(MSECONDS);	}
		
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		//get interested word
		String googleThis = getWord();
		
		say("Google " + googleThis + "... ");
		
		//create FF driver
		MyFirefoxDriver driver = new MyFirefoxDriver();
		
		//go to google web-site
		driver.get(GOOGLE);
		pause();
		
		//find input field and type word inside
		driver.find(INPUT).sendKeys(googleThis);
		pause();
		
		//find button to google smth and clicking it
		driver.find(BUTTON).click();
		pause();
		
		//calculate number of links
		//usually it is 10, but if you want more...
		List<WebElement> list = driver.findElements(By.xpath(LINK));
		pause();
		
		/**
		 * Number of result links.
		 */
		final int NUMBER_OF_LINKS = (list.size());
		
		//cycle that opens all links
		int i = 1;
		while(i <= NUMBER_OF_LINKS){
			pause();
			
			//find link by XPath and number, clicking it
			driver.find(LINK+"["+i+"]").click();
			pause();
			
			//get title, very simple
			say(driver.getTitle());
			pause();
			
			//go back
			driver.navigate().back();
			pause();
			
			i++;
			}
		
		//shut down this thing
		driver.quit();
	}
}