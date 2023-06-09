package hu.nye.encryptor.service;

import hu.nye.encryptor.encryptors.Aes;
import hu.nye.encryptor.encryptors.Des;
import hu.nye.encryptor.encryptors.Own;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PageService {

    private Des des = new Des();
    private Aes aes = new Aes();
    private Own own = new Own();

    public String desEncryption(String input, String selected) {
        String encrypted;
        try {
            encrypted = des.desEncryptor(input, selected);
        } catch (Exception e) {
            encrypted = "Sikertelen";
            e.printStackTrace();
        }

        return encrypted;
    }

    public String desDecryption(String input, String selected) {
        String[] splitted;
        List<Byte> decrypted = new ArrayList<>();
        String result;
        try {
            splitted = input.split(" ");
            for (int i = 0; i < splitted.length; i++) {
                decrypted.add(Byte.parseByte(splitted[i]));
            }
            result = des.desDecryptor(decrypted, selected);
        } catch (Exception e) {
            result = "Sikertelen";
            e.printStackTrace();
        }
        return result;
    }

    public String aesEncryption(String input, String selected) {
        String encrypted;
        try {
            encrypted = aes.aesEncryptor(input, selected);
        } catch (Exception e) {
            encrypted = "Sikertelen";
            e.printStackTrace();
        }

        return encrypted;
    }

    public String aesDecryption(String input, String selected) {
        String[] splitted;
        List<Byte> decrypted = new ArrayList<>();
        String result;
        try {
            splitted = input.split(" ");
            for (int i = 0; i < splitted.length; i++) {
                decrypted.add(Byte.parseByte(splitted[i]));
            }
            result = aes.aesDecryptor(decrypted, selected);
        } catch (Exception e) {
            result = "Sikertelen";
            e.printStackTrace();
        }
        return result;
    }

    public String ownEncryption(String input, String character) {
        String encrypted;
        char c = ' ';
        if (character.isEmpty() || !character.matches("[0-9\\W]+")) {
            return "Sikertelen";
        } else {
            c = character.charAt(0);
        }
        encrypted = own.ownEncryptor(input, c);
        return encrypted;
    }

    public String ownDecryption(String input, String character) {
        String[] splitted;

        char c = ' ';
        if (character.isEmpty() || !character.matches("[0-9\\W]+")) {
            return "Sikertelen";
        } else {
            c = character.charAt(0);
        }

        String result;
        try {
            splitted = input.split(" ");
            byte[] decrypted = new byte[splitted.length];
            for (int i = 0; i < splitted.length; i++) {
                decrypted[i] = Byte.parseByte(splitted[i]);
            }
            result = own.ownDecryptor(decrypted, c);
        } catch (Exception e) {
            result = "Sikertelen";
            e.printStackTrace();
        }
        return result;
    }
}
