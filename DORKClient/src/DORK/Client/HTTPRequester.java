package DORK.Client;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import DORK.Common.ServerInfo;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

/**
 * Primary implementation of the IHTTPRequester
 * 
 * @author Alex Bowen
 * @version 0.0.1
 */

public class HTTPRequester implements IHTTPRequester 
{	
	@Override
	public String GetRequest(String path) 
	{
		String response = "";
		
		try 
		{
			URL url = new URL(path);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			InputStreamReader in = new InputStreamReader(con.getInputStream());
			
			int nextChar = in.read();
			while(nextChar != -1)
			{
				response += (char)nextChar;
				nextChar = in.read();
			}
			
		} 
		catch (MalformedURLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}

	@Override
	public ServerInfo GetServerInfo(String ipAddress) 
	{
		String fullPath = "http://" + ipAddress + ":8080/info";
		try 
		{
			byte[] rawResponse = Base64.decode(GetRequest(fullPath));
			InputStream stringStream = new ByteArrayInputStream(rawResponse);
			ObjectInputStream objStream = new ObjectInputStream(stringStream);
			ServerInfo serverInfo = (ServerInfo)objStream.readObject();
			return serverInfo;
		} 
		catch (IOException | ClassNotFoundException | Base64DecodingException e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
