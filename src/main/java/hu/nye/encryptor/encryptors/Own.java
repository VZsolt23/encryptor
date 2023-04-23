package hu.nye.encryptor.encryptors;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Own {
    private int[] fibonacci = {3, 5, 8, 13, 21, 34, 55, 89};

    public String ownEncryptor(String text, char c) {
        String word = "";
        String base64Word;
        int n = text.length();
        char[] charArray = new char[n * 2 - 1];

        for (int i = 0; i < n; i++) {
            int j = i * 2;

            charArray[j] = text.charAt(i);
            if (i != n - 1) {
                charArray[j + 1] = c;
            }
        }

        for (int i = 0; i < charArray.length; i++) {
            int index = i % fibonacci.length;
            charArray[i] *= fibonacci[index];
        }

        word = String.valueOf(charArray);

        byte[] wordBytes = word.getBytes();

        for (int i = 0; i < wordBytes.length; i++) {
            wordBytes[i] += 5;
        }

        base64Word = Base64.getEncoder().encodeToString(wordBytes);

        wordBytes = base64Word.getBytes();

        String s = "";
        for (byte variable : wordBytes) {
            s += variable + " ";
        }
        s = s.trim();

        return s;
    }

    public String ownDecryptor(byte[] input, char c) {
        String base64Word;
        base64Word = new String(input, StandardCharsets.UTF_8);
        byte[] decodedBytes = Base64.getDecoder().decode(base64Word);

        String decodedString;

        for (int i = 0; i < decodedBytes.length; i++) {
            decodedBytes[i] -= 5;
        }

        decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
        char[] newCharArray = new char[decodedString.length()];

        for (int i = 0; i < decodedString.length(); i++) {
            newCharArray[i] = decodedString.charAt(i);
        }

        for (int i = newCharArray.length - 1; i >= 0; i--) {
            int index = i % fibonacci.length;
            newCharArray[i] /= fibonacci[index];
        }

        String result = String.valueOf(newCharArray);
        result = result.trim();

        result = result.replace(String.valueOf(c), "");

        return result;
    }
}
