import java.io.*;
import java.security.*;

public class SharedResource {

	private File diskFile;
	private long chunkCount;
	private String hash;
	private boolean complete;
	
	public SharedResource(File f) {
		diskFile = f;
	}
	
	public void write(){
		
	}
	/* md needs to be updated every time a new chunk is generated in order to avoid heap overflows!
	 * 
	private String getHash(File f) {
		
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		byte[] b = new byte[(int)f.length()];
		md.update(b);
		byte[] hash = md.digest();
	}
	*/
}
