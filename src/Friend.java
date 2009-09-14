import java.io.*;
import java.net.*;

public class Friend {
	public InetAddress address;
	public InetAddress alternativeAddress;
	public int port;
	
	public Friend(InetAddress address, int port) {
		this.address = address;
		this.port = port;
	}
}
