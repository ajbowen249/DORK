/**
 * Handles requests to the "info" context
 * 
 * @author Alex Bowen
 * @version 0.0.1
 *
 */

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.org.apache.xml.internal.security.utils.Base64;

public class DORKServerInfoRequestHandler implements IDORKServerRequestHandler , HttpHandler 
{
	@Override
	public void handle(HttpExchange req) 
	{
		//This should eventually send over the saved server info file
		//For now, make a fake one and send
		
		DORKServerInfo serverInfo = new DORKServerInfo("192.168.0.1", "TestServer");
		
		try 
		{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(baos);
			
			String serializedSettings = Base64.encode(baos.toByteArray());
			
			req.sendResponseHeaders(200, serializedSettings.length());
			OutputStream responseOS = req.getResponseBody();
			responseOS.write(serializedSettings.getBytes());
			responseOS.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
