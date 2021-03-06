package DORK.Client;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Main loop for DORK Client Application
 * 
 * @author Alex Bowen
 * @version 0.0.1
 */

public class DORKClientMain 
{
	private static Scanner _kb = new Scanner(System.in);
	
	private static IClientConsoleUI _ui;
	
	public static void main(String[] args) 
	{
		SavedUserSettings userSettings = SavedUserSettings.createOrLoadDefaultSettings();
		
		_ui = new ClientConsoleUI(userSettings, new HTTPRequester(), _kb);
		
		_ui.startUI();
		
		System.exit(0);
	}
}
