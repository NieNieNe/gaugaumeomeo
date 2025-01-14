package model;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class emailService implements iJavaMail {
    @Override
    public boolean send(String to, String subject, String body) {
        // Cấu hình các thuộc tính cho SMTP
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", emailProperty.HOST_NAME);
        props.put("mail.smtp.socketFactory.port", emailProperty.SSL_PORT);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.port", emailProperty.SSL_PORT);

        // Tạo phiên làm việc
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailProperty.APP_EMAIL, emailProperty.APP_PASSWORD);
            }
        });

        try {
            // Tạo tin nhắn email
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailProperty.APP_EMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setContent(body, "text/html; charset=UTF-8"); // Nội dung email dưới dạng HTML

            // Gửi email
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace(); // Log lỗi để kiểm tra
            return false;
        }
    }
}
