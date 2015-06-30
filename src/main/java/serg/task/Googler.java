package serg.task;

import java.util.Scanner;

import serg.task.driver.MyFirefoxDriver;
import serg.task.tools.ConsoleSpeaking;

/**
 * Class Googler. Google smth and prints to console 
 * names of googled pages by autoclicking on every result link.
 * 
 * @author Serg Maximchuk
 */
public class Googler implements ConsoleSpeaking {
	
	@Override
	public void say(String command){
		
		//limiting the message
		command = (command.length() > LIMIT) ? 
				command.substring(0, LIMIT)+"..." : command;
		
		System.out.println(command);
	}
	
	/**
	 * String what needs to google.
	 */
	private String googleThis;
	
	private static Scanner input;
	
	public void setGoogleThis(String googleThis) {
		this.googleThis = googleThis;
	}
	
	public String getGoogleThis() {
		return googleThis;
	}
	
	/**
	 * Constructor with greetings.
	 */
	public Googler(){
		say("Hi there! Googler welcomes you!\nWhat you want to google?");
	}
	
	public String getStringFromConsole() {
		
		String word = "";
		
		input = new Scanner(System.in);
		word = input.nextLine();
		
		//if input is empty or whitespace
		if (word.equals("")||word.equals(" ")) {
			
			say("Just type somethig.");
			word = getStringFromConsole();
		}
		
		return word;
	}
	
	public static void main(String[] args) {
		
		//say hello
		Googler googler = new Googler();
		
		//get interested word(s)
		String str = googler.getStringFromConsole();
		
		//set what to google
		googler.setGoogleThis(str);
		googler.say("Opening Mozilla Firefox...");
		
		//create Firefox WebDriver, opening the FF with new profile
		MyFirefoxDriver driver = new MyFirefoxDriver();
		
		//google what needs
		driver.google(googler.getGoogleThis());
		
		PageWalker Walker = new PageWalker(driver);
		//go through the page, print result names to console
		Walker.goThroughPage();
		//work done
		driver.close();
		input.close();
	}	
}