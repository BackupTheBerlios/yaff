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

	//TODO: needs to be checked! probably junk due to heap overflow issues; chunks need to be generated one after another
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
