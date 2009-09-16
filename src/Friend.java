import java.io.*;
import java.net.*;
import java.sql.Timestamp;
import java.util.Date;

public class Friend {
	private YaffNet net;
	
	private String name;
	private InetAddress address;
	private InetAddress alternativeAddress;
	private int port;
	private String RSAKey;
	private Timestamp lastSeen;
	
	public Friend(String name, InetAddress address, int port) {
		this.address = address;
		this.port = port;
		this.name = name;
	}
	
	public void sendFile() {
		
	}
	/**
	 * 
	 * @return the last time Friend was online
	 */
	public Timestamp getTimestamp() {
		return lastSeen;
	}
	/**
	 * sets new Timestamp
	 */
	public void setTimestamp() {
		Date today = new Date();
		lastSeen = new Timestamp(today.getTime());
	}
}
