package DORK.Client;
import DORK.Common.ServerInfo;

/**
 * Handles HTTP Requests
 * 
 * @author Alex
 * @version 0.0.1
 */

public interface IHTTPRequester 
{
	/**
	 * Performs a GET request to the given path
	 * 
	 * @param path the extension of the base URL
	 * @return the HTTP response
	 */
	public String GetRequest(String path);
	
	/**
	 * Gets the information of the server on the base URL
	 * 
	 * @return the ServerInfo object
	 */
	public ServerInfo GetServerInfo(String ipAddress);
}
