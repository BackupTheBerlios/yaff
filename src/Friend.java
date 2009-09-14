import java.io.*;
import java.net.*;

public class Friend {
	private YaffNet net;
	
	private String name;
	private InetAddress address;
	private InetAddress alternativeAddress;
	private int port;
	private String RSAKey;
	
	public Friend(String name, InetAddress address, int port) {
		this.address = address;
		this.port = port;
		this.name = name;
	}
	
	public void sendFile() {
		
	}
}
