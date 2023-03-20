package hu.nye.encryptor.encryptors;

import hu.nye.encryptor.service.KeyInputHandler;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.List;

public class Des {

    private byte[] keyBytes = {0x01, 0x23, 0x45, 0x67, (byte) 0x89, (byte) 0xab, (byte) 0xcd, (byte) 0xef};
    private SecretKey secretKey;
    private Cipher cipher;
    private byte[] encrypted;
    private KeyInputHandler keyInputHandler = new KeyInputHandler();

    public String desEncryptor(String text, String selected) throws Exception {

        byte[] keys = keyInputHandler.desInputHandler(selected);

        SecretKeySpec keySpec = new SecretKeySpec(keys, "DES");
        secretKey = keySpec;
        cipher = Cipher.getInstance("DES");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] input = text.getBytes();
        encrypted = cipher.doFinal(input);

        String s = "";
        for (byte variable : encrypted) {
            s += variable + " ";
        }
        s = s.trim();

        return s;
    }

    public String desDecryptor(List<Byte> input, String selected) throws Exception {
        byte[] keys = keyInputHandler.desInputHandler(selected);

        SecretKeySpec keySpec = new SecretKeySpec(keys, "DES");
        secretKey = keySpec;
        cipher = Cipher.getInstance("DES");

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] inputBytes = new byte[input.size()];
        for (int i = 0; i < input.size(); i++) {
            inputBytes[i] = input.get(i);
        }

        byte[] decrypted = cipher.doFinal(inputBytes);

        return new String(decrypted, "UTF-8");
    }
}
