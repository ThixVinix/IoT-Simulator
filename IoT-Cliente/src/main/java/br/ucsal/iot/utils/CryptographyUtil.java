package br.ucsal.iot.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CryptographyUtil {

	private static final String SEGREDO = "12345abcde";
	private static final String AES_ECB_PKCS5PADDING = "AES/ECB/PKCS5PADDING";
	private static final String FORMATACAO = "UTF-8";
	private static SecretKeySpec secretKey;

	private CryptographyUtil() {
	}

	public static String encriptar(String texto) throws Exception {
		escolherChave(SEGREDO);
		Cipher cipher = Cipher.getInstance(AES_ECB_PKCS5PADDING);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		return Base64.getEncoder().encodeToString(cipher.doFinal(texto.getBytes(FORMATACAO)));
	}

	public static String decriptar(String texto) throws Exception {
		escolherChave(SEGREDO);
		Cipher cipher = Cipher.getInstance(AES_ECB_PKCS5PADDING);
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		return new String(cipher.doFinal(Base64.getDecoder().decode(texto)));
	}

	private static void escolherChave(String myKey) {
		MessageDigest sha = null;
		try {
			byte[] key = myKey.getBytes(FORMATACAO);
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
