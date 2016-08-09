//package com.mkyong.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class mydes
{
	public static void main(String[] args) {



									BufferedReader br = null;

									try 
									{
										String sCurrentLine;
	
										br = new BufferedReader(new FileReader("C:\\shag.txt"));

										while ((sCurrentLine = br.readLine()) != null)
										 {
											System.out.println(sCurrentLine);
										}	

										}
									catch (IOException e) 
									{
										e.printStackTrace();
									} 
									finally 
									{
										try 
										{
											if (br != null)br.close();
										}
										 catch (IOException ex) 
										{
											ex.printStackTrace();
										}
									}


		try{

		    KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
		    SecretKey myDesKey = keygenerator.generateKey();

		    Cipher desCipher;

		    // Create the cipher
		    desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

		    // Initialize the cipher for encryption
		    desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);

		    //sensitive information

		     //br = new BufferedReader(new FileReader("C:\\shag.txt"));
		     byte[] text1=sCurrentLine.getBytes();
		    //byte[] text = "No body can see me".getBytes();

		    System.out.println("Text [Byte Format] : " + text1);
		    //System.out.println("Text [Byte Format] : " + text);

		    System.out.println("Text : " + new String(text1));

		    // Encrypt the text
		    byte[] textEncrypted = desCipher.doFinal(text1);

		    System.out.println("Text Encryted : " + textEncrypted);

		    // Initialize the same cipher for decryption
		    desCipher.init(Cipher.DECRYPT_MODE, myDesKey);

		    // Decrypt the text
		    byte[] textDecrypted = desCipher.doFinal(textEncrypted);

		    System.out.println("Text Decryted : " + new String(textDecrypted));

		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}catch(NoSuchPaddingException e){
			e.printStackTrace();
		}catch(InvalidKeyException e){
			e.printStackTrace();
		}catch(IllegalBlockSizeException e){
			e.printStackTrace();
		}catch(BadPaddingException e){
			e.printStackTrace();
		}

	}
}