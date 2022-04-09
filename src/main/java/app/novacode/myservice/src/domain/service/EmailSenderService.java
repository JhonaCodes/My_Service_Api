package app.novacode.myservice.src.domain.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    // Enviar email simple
    public void sendSimpleEmail(String email, String body, String subject){

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("password-recovery-no-reply@novacode.app");
        message.setTo(email);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);

    }


    // Enviar email con un archivo
    public void sendEmailWithAttachment(String toEmail, String body, String subject, String attachment) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("password-recovery-no-reply@novacode.app");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
        mailSender.send(mimeMessage);
    }
}
