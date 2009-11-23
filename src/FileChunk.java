import java.io.*;
import java.util.zip.*;

public class FileChunk {
	
	public final long CHUNK_SIZE  = 8388608;
	
	private byte[] data; //chunk data
	private long index; //index of this particular chunk in a file;
	private boolean finalChunk = false;
	private long adler32; //much faster than crc32 but not that reliable; still appropriate!
	private long crc32;
	// Consider using hashes, e.g. md5, SHA-1, Skein (variable bit-length)
	
	
	public FileChunk(File f, long index){		
		this.index = index;
		this.data = truncate(f, index);	
	}
	/**
	 * 
	 * @param file to truncate
	 * @param index of the chunk 
	 * @return byte array of the chunk data
	 */
	private byte[] truncate(File file, long index){
		
		try {
			RandomAccessFile rf = new RandomAccessFile(file,"r");

			if((rf.length() - index*CHUNK_SIZE) >= CHUNK_SIZE) {
				data = new byte[(int) CHUNK_SIZE];
				rf.seek(index * CHUNK_SIZE);
				rf.read(data);	
				return data;
			} else {
				data = new byte[(int) (rf.length() - index*CHUNK_SIZE)];
				finalChunk = true;
				return data;
			}
						
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public long getAdler32() {
		Adler32 adler = new Adler32();
		adler.update(data);
		this.adler32 = adler.getValue();
		return adler32;
	}
	
	public long getCRC32() {
		CRC32 crc = new CRC32();
		crc.update(data);
		this.crc32 = crc.getValue();
		return crc32;
	}

	public byte[] getData() {
		return data;
	}
	public long getIndex(){
		return index;
	}
	public boolean isFinal() {
		return finalChunk;
	}
	
}
