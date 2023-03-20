package hu.nye.encryptor.service;

import java.util.HashMap;
import java.util.Map;

public class KeyInputHandler {
    // -----DES-----
    private byte[] desAlphaBytes = {
            0x01, 0x23, 0x45, 0x67,
            (byte) 0x89, (byte) 0xab, (byte) 0xcd, (byte) 0xef
    };
    private byte[] desBetaBytes = {
            (byte) 0xA4, (byte) 0xD7, (byte) 0xDD, (byte) 0xCF,
            (byte) 0xEB, (byte) 0x5C, (byte) 0xD6, (byte) 0xC4
    };
    private byte[] desGammaBytes = {
            (byte) 0x28, (byte) 0xAA, (byte) 0xDF, (byte) 0xBD,
            (byte) 0x3C, (byte) 0x85, (byte) 0x07, (byte) 0x66
    };
    private byte[] desDeltaBytes = {
            (byte) 0xF1, (byte) 0xF5, (byte) 0xB4, (byte) 0x78,
            (byte) 0xE4, (byte) 0xFB, (byte) 0xFF, (byte) 0xF3
    };

    // -----AES-----
    private byte[] aesAlphaBytes = {
            0x00, 0x01, 0x02,
            0x03, 0x04, 0x05,
            0x06, 0x07, 0x08,
            0x09, 0x0A, 0x0B,
            0x0C, 0x0D, 0x0E,
            0x0F
    };

    private byte[] aesBetaBytes = {
            (byte) 0x2b, (byte) 0x7e, (byte) 0x15, (byte) 0x16,
            (byte) 0x28, (byte) 0xae, (byte) 0xd2, (byte) 0xa6,
            (byte) 0xab, (byte) 0xf7, (byte) 0x15, (byte) 0x88,
            (byte) 0x09, (byte) 0xcf, (byte) 0x4f, (byte) 0x3c
    };

    private byte[] aesGammaBytes = {
            (byte) 0x8a, (byte) 0x84, (byte) 0x90, (byte) 0xc7,
            (byte) 0x1a, (byte) 0xd1, (byte) 0xc8, (byte) 0x2c,
            (byte) 0xab, (byte) 0x54, (byte) 0x69, (byte) 0x34,
            (byte) 0x2b, (byte) 0x29, (byte) 0x6e, (byte) 0x3e
    };

    private byte[] aesDeltaBytes = {
            (byte) 0xd6, (byte) 0xa2, (byte) 0x80, (byte) 0x7f,
            (byte) 0x0e, (byte) 0x11, (byte) 0xf3, (byte) 0xcc,
            (byte) 0xb7, (byte) 0x71, (byte) 0x3d, (byte) 0x60,
            (byte) 0x9c, (byte) 0x41, (byte) 0xac, (byte) 0x0f
    };

    private final Map<String, byte[]> keys = new HashMap<>();

    public byte[] desInputHandler(String inputKey) {
        keys.put("alpha", desAlphaBytes);
        keys.put("beta", desBetaBytes);
        keys.put("gamma", desGammaBytes);
        keys.put("delta", desDeltaBytes);

        return keys.get(inputKey);
    }

    public byte[] aesInputHandler(String inputKey) {
        keys.put("alpha", aesAlphaBytes);
        keys.put("beta", aesBetaBytes);
        keys.put("gamma", aesGammaBytes);
        keys.put("delta", aesDeltaBytes);

        return keys.get(inputKey);
    }
}
