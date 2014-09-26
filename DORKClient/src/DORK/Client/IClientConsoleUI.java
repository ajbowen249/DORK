package DORK.Client;
/**
 * Interface for DORK Client COnsole UI System
 * 
 * @author Alex Bowen
 * @version 0.0.1
 */

public interface IClientConsoleUI 
{
	/**
	 * "Main Loop" of the Console UI
	 */
	void startUI();
	
	/**
	 * Displays and handles console IO
	 * for the main menu
	 */
	NextUIScreenEnum mainMenu();
	
	/**
	 * Displays and handles console IO
	 * for adding a new server
	 */
	NextUIScreenEnum addServer();
	
	/**
	 * Displays and handles console IO
	 * for the saved servers list
	 */
	NextUIScreenEnum savedServers();

}
