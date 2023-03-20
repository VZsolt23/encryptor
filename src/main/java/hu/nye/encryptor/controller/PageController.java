package hu.nye.encryptor.controller;

import hu.nye.encryptor.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @Autowired
    private PageService pageService;

    @GetMapping
    public String index() {
        return "index.html";
    }

    @GetMapping("/des")
    public String desPage() {
        return "des.html";
    }

    @PostMapping("/des/encrypted")
    public String desEncryptText(@RequestParam("text-to-encrypt") String input, @RequestParam("encryptKey") String selected, Model model) {
        String encrypted = pageService.desEncryption(input, selected);
        model.addAttribute("desEncryptedText", encrypted);
        return "des.html";
    }

    @PostMapping("/des/decrypted")
    public String desDecryptSecret(@RequestParam("text-to-decrypt") String input, @RequestParam("decryptKey") String selected, Model model) {
        String secret = pageService.desDecryption(input, selected);
        model.addAttribute("desDecrypt", secret);
        return "des.html";
    }

    @GetMapping("/aes")
    public String aesPage() {
        return "aes.html";
    }

    @PostMapping("/aes/encrypted")
    public String aesEncryptText(@RequestParam("text-to-encrypt") String input, @RequestParam("encryptKey") String selected, Model model) {
        String encrypted = pageService.aesEncryption(input, selected);
        model.addAttribute("aesEncryptedText", encrypted);
        return "aes.html";
    }

    @PostMapping("/aes/decrypted")
    public String aesDecryptSecret(@RequestParam("text-to-decrypt") String input, @RequestParam("decryptKey") String selected, Model model) {
        String secret = pageService.aesDecryption(input, selected);
        model.addAttribute("aesDecrypt", secret);
        return "aes.html";
    }

}
