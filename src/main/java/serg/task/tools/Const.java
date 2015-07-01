package serg.task.tools;

/**
 * Simple {@code Enum} with constant values.
 * 
 * @author Serg Maximchuk
 */
public enum Const {
	
	/**
	 * Button to google smth.
	 */
	BUTTON	{	@Override
				public String toString() {
					return "//button[@name='btnG']";
			}	},
	/**
	 * Casual link of result page.
	 */
	LINK	{	@Override
				public String toString() {
					return "(//h3[@class='r']/a)";
			}	},
	/**
	 * Link of next result page.
	 */
	NEXT_PAGE	{	@Override
					public String toString() {
						return "(//td[@class='b navend']/a[@id='pnnext'])";
				}	};
}