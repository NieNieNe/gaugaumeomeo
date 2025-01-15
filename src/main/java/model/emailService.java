package model;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class emailService implements iJavaMail {
    @Override
    public boolean send(String to, String subject, String body) {
        if (to == null || to.trim().isEmpty()) {
            System.err.println("Recipient email address is null or empty");
            return false; // Hoặc ném IllegalArgumentException nếu cần
        }

        // Cấu hình thuộc tính SMTP
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", emailProperty.HOST_NAME);
        props.put("mail.smtp.socketFactory.port", emailProperty.SSL_PORT);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.port", emailProperty.SSL_PORT);

        // Tạo phiên làm việc với Gmail
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailProperty.APP_EMAIL, emailProperty.APP_PASSWORD);
            }
        });

        try {
            // Tạo email
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailProperty.APP_EMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setContent(body, "text/html; charset=UTF-8");

            // Gửi email
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

}
