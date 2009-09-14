import javax.crypto.*;
import java.security.*;

public class CryptoTransport {
	
	public static int RSA_KEYSIZE = 2048;
		
	public static void generateRSAKeys() {
		try {
			KeyPairGenerator pairgen = KeyPairGenerator.getInstance("RSA");
			SecureRandom random = new SecureRandom();
			pairgen.initialize(RSA_KEYSIZE, random);
			KeyPair keyPair = pairgen.generateKeyPair();
			
		}
		catch (IOException e) {
			System.out.println(e);
		}
		catch (GeneralSecurityException e) {
			System.out.println(e);
		}
	}
}
