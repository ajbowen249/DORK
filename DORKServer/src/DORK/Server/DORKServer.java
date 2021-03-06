package DORK.Server;
/**
 * Main DORK Server Class
 * 
 * @author Alex Bowen
 * @version 0.0.1
 *
 */

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;

public class DORKServer implements IDORKServer 
{
	private int _port;
	private HttpServer _server;
	private IDORKServerRequestHandler _requestHandler;
	private ServerInfoRequestHandler _infoRequestHandler;
	
	public DORKServer(int port)
	{
		_port = port;
		
		_requestHandler = new DORKServerRequestHandler();
		_infoRequestHandler = new ServerInfoRequestHandler();
		
		try 
		{
			_server = HttpServer.create(new InetSocketAddress(_port), 0);
			
			_server.createContext("/main", (HttpHandler)_requestHandler);
			_server.createContext("/info", (HttpHandler)_infoRequestHandler);
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public int getPort() 
	{
		return _port;
	}

	@Override
	public void setPort(int newPort) 
	{
		_port = newPort;
	}

	@Override
	public void start() 
	{
		System.out.printf("Starting DORK Server on port %s...\n", _port);
		
		_server.start();
	}

	@Override
	public void stop() 
	{
		System.out.println("Shutting down DORK Server...");
		_server.stop(0);
	}
}
