import java.net.*;
import java.util.ArrayList;
import java.io.*;


public class YaffNet {
	
	private ArrayList<Friend> friends; 
	
	private ServerSocket listener;
	
	private YaffNet(){
		friends = new ArrayList<Friend>(1);
		//bissl friends adden damit was drin steht (workaround damits rennt)
	}
	
	public YaffNet(String netName, int port) {
		this();
		try {
			this.listener = new ServerSocket(port);
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}	

	
	
}
