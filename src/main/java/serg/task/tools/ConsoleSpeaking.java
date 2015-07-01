package serg.task.tools;

/**
 * Interface that helps me do not type {@code System.out.println()} every time when it needs.
 * 
 * @author Serg Maximchuk
 */
public interface ConsoleSpeaking {
	
	/**
	 * Limit of symbols in string message.
	 */
	final static byte LIMIT = 100;
	
	/**
	 * Just short method call.
	 * 
	 * @param command - The {@code String} to be printed
	 */
	public void say( String command );
}