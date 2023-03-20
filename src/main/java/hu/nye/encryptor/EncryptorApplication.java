package hu.nye.encryptor;

import hu.nye.encryptor.encryptors.Des;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EncryptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(EncryptorApplication.class, args);
    }
}
