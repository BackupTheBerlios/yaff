import java.net.*;
import java.io.*;


public class YaffNet {
	
	private ServerSocket listener;
	
	public YaffNet(String netName) {
		try {
			this.listener = new ServerSocket();
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public Connection connect(Friend friend){
		Socket socket = new Socket(friend.address, friend.port); 
		return con
	}
	
}
