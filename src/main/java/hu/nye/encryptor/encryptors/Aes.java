package hu.nye.encryptor.encryptors;

import hu.nye.encryptor.service.KeyInputHandler;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.List;

public class Aes {

    //128 bites
    private byte[] keyBytes = {
            0x00, 0x01, 0x02,
            0x03, 0x04, 0x05,
            0x06, 0x07, 0x08,
            0x09, 0x0A, 0x0B,
            0x0C, 0x0D, 0x0E,
            0x0F
    };
    private byte[] encrypted;
    private KeyInputHandler keyInputHandler = new KeyInputHandler();

    public String aesEncryptor(String text, String selected) throws Exception {

        byte[] keys = keyInputHandler.aesInputHandler(selected);

        SecretKeySpec keySpec = new SecretKeySpec(keys, "AES");
        SecretKey secretKey = keySpec;

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        encrypted = cipher.doFinal(text.getBytes());

        String s = "";
        for (byte variable : encrypted) {
            s += variable + " ";
        }
        s = s.trim();

        return s;
    }

    public String aesDecryptor(List<Byte> input, String selected) throws Exception {

        byte[] keys = keyInputHandler.aesInputHandler(selected);

        SecretKeySpec keySpec = new SecretKeySpec(keys, "AES");
        SecretKey secretKey = keySpec;

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] inputBytes = new byte[input.size()];
        for (int i = 0; i < input.size(); i++) {
            inputBytes[i] = input.get(i);
        }

        byte[] decrypted = cipher.doFinal(inputBytes);

        return new String(decrypted, "UTF-8");
    }
}
