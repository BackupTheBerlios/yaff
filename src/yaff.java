import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class yaff {
	/*
	 * This class implements the command line interface for yaff
	 */

	public static void main(String[] args) {
		//TODO: Add code to handle command line arguments
		try {
			yaff.openConfigFiles();
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}
	
	private static Friend parseFriendConfig(String path) {
		//TODO: implement config file parser for friend files, use String.split() method
	}
	
	private static Properties parseNetConfig(String path) {
		//TODO: implement config file parser for global file, use String.split() method
	}
	
	private static void openConfigFiles() throws IOException {
		String path;
		if (System.getProperty("os.name") == "Linux") {
			path = System.getProperty("user.home")+"/.config/yaff";
		}
		else {
			path = null;
		}
		// TODO: set config file path for other platforms
		String fsep = System.getProperty("file.separator");
		File file = new File(path);
		if (file.exists() == false) {
			file.mkdir();
			System.out.println("First run of this program."+System.getProperty("line.separator")+"Please create new configuration file. See documentation for details.");
		}
		String[] networks = file.list();
		ArrayList<YaffNet> yaffnets;
		for (String network: networks) {
			String friendpath = path + fsep + network + fsep + "friends";
			file = new File(friendpath);
			String[] friends = file.list();
			ArrayList<Friend> friendlist;
			for (String friend: friends) {
				Friend f = yaff.parseFriendConfig(friendpath+fsep+friend);
				friendlist.add(f);
			}
			YaffNet yf = new YaffNet(); //use real YaffNet constructor
			yaffnets.add(yf);
		}
	}
}
