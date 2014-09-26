package DORK.Common;
/**
 * Container for information about a server saved
 * by the player
 * 
 * @author Alex Bowen
 * @version 0.0.1
 */

public class ServerInfo implements java.io.Serializable
{
	public String IPAddress;
	public String ServerName;
	
	public ServerInfo(String ipAddress, String serverName)
	{
		IPAddress = ipAddress;
		ServerName = serverName;
	}
	
	public boolean equals(ServerInfo other)
	{
		boolean equal = (other.IPAddress.equals(this.IPAddress))
					 && (other.ServerName.equals(this.ServerName));
		
		return equal;
	}
}
