import java.io.*;
import java.security.*;
import java.util.ArrayList;

public class SharedResource {

	private File diskFile;
	private long chunkCount;
	private String hash;
	private boolean complete;
	private ArrayList <FileChunk> chunks;
	
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
	//TODO: needs to be checked!
	private ArrayList <FileChunk> generateChunks() {
		chunks = new ArrayList <FileChunk> ();
		for(long i = 0;;i++) {
			FileChunk f = new FileChunk(diskFile, i);
			chunks.add(f);
			if(f.isFinal()) {
				chunkCount = (f.getIndex() + 1);
				break;
			}
		}
		return chunks;
	}
}
