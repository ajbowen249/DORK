package DORK.Server;
/**
 * Main DORK Server Request handler
 * 
 * for now, this is just in interface to 
 * an HttpHandler
 * 
 * @author Alex Bowen
 * @version 0.0.1
 *
 */

import com.sun.net.httpserver.HttpExchange;

public interface IDORKServerRequestHandler 
{
	/**
	 * Handles an HttpExchange
	 * 
	 * @param req the Http Request
	 */
	void handle(HttpExchange req);
}
