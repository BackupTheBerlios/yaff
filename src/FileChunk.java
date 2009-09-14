import java.io.File;

public class FileChunk {
	public final long CHUNK_SIZE = 64000;
	
	private byte[] data;
	private long index; //index of this particular chunk in a file;
	
	public FileChunk(File f, long index){
		//a bissi file io (chunk einlesen)
	}
}
