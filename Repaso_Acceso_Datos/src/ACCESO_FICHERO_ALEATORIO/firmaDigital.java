package ACCESO_FICHERO_ALEATORIO;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.*;

public class firmaDigital {

	public static void main(String[] args) {
		KeyPairGenerator claves;
		try {
			claves = KeyPairGenerator.getInstance("RSA");
			claves.initialize(2048);
			KeyPair parClaves = claves.generateKeyPair();
			
			PrivateKey clavePrivada = parClaves.getPrivate();
			PublicKey clavePublica = parClaves.getPublic();
			
			//Mensaje o documento a firmar
			String mensaje = "Documento a firmar IES Augustóbriga";
			byte[] datos = mensaje.getBytes("UTF-8");
			
			
			
			// crear la firma (el boli con qué firmar)
			Signature firma = Signature.getInstance("SHA256withRSA");
			
			firma.initSign(clavePrivada);
			firma.update(datos);
			byte[] firmaBytes = firma.sign(); // firmamos digitalmente los datos
			
			System.out.println("Firma: "+Base64.getEncoder().encodeToString(firmaBytes).length()+"\t"+Base64.getEncoder().encodeToString(firmaBytes));
			
			// COMPROBACIÓN -- SE DEBE HACER EN OTRO SISTEMA
			Signature verificador = Signature.getInstance("SHA256withRSA");
			verificador.initVerify(clavePublica);
			verificador.update(datos);
			
			boolean esValida = verificador.verify(firmaBytes);
			System.out.println("¿Firma válida?: \t"+ esValida);
			
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
