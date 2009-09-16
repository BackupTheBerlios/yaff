import java.io.*;

public class FileChunk {
	
	public final long CHUNK_SIZE  = 256000;
	
	private byte[] data; //chunk data
	private long index; //index of this particular chunk in a file;
	private boolean finalChunk = false;
	
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
