/**
 * DORK Server HttpRequestHandler
 * 
 * @author Alex Bowen
 * @version 0.0.1
 * 
 */

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class DORKServerRequestHandler implements IDORKServerRequestHandler, HttpHandler 
{
	public DORKServerRequestHandler()
	{
		
	}
	
	@Override
	public void handle(HttpExchange req) 
	{
		System.out.printf("Recieved request %s\n", req.getLocalAddress().getHostName());
		
		try 
		{
			String response = "Ballsack.";
			req.sendResponseHeaders(200, response.length());
			OutputStream os = req.getResponseBody();
	        os.write(response.getBytes());
	        os.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
