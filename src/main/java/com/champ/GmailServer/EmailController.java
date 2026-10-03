package com.champ.GmailServer;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;
    private static Environment env;
    public EmailController(Environment environment){
        EmailController.env=environment;
    }
    @PostMapping("/send-email")
    public void sendEmail(@RequestBody EmailDto emailDto, HttpServletRequest request) throws Exception {
        String secret = request.getHeader("X-Mail-Service-Key");
        String envSecret = env.getProperty("SECRET_KEY");
        if(!secret.equals(envSecret)) return;
        emailService.sendConfirmationEmail(emailDto.getEmail(),emailDto.getPlayerName(),emailDto.getRegistrationId(),emailDto.getCategory(),emailDto.getProficiency());
    }

}
