package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Properties;

@WebServlet("/SendEmailServlet")
public class SendEmailServlet extends HttpServlet {
    private static final String HOST = "smtp.gmail.com";
    private static final String PORT = "587";
    private static final String USERNAME = "tranthimytuyenahh@gmail.com";
    private static final String PASSWORD = "qddz rqod xzvh qjtr";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thông tin từ form
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String time = request.getParameter("appointment-time");
        String[] servicesArray = request.getParameterValues("service");
        String services = servicesArray != null ? String.join(", ", servicesArray) : "Không có";

        if (email == null || email.trim().isEmpty()) {
            response.sendRedirect("appointment.jsp?error=Email is required.");
            return;
        }

        // Nội dung email
        String subject = "Xác nhận thông tin đặt hẹn";
        String messageText = "Xin chào " + name + ",\n\n"
                + "Cảm ơn bạn đã đặt hẹn với chúng tôi. Dưới đây là thông tin chi tiết:\n"
                + "- Số điện thoại: " + phone + "\n"
                + "- Email: " + email + "\n"
                + "- Thời gian: " + time + "\n"
                + "- Dịch vụ: " + services + "\n\n"
                + "Chúng tôi rất mong được phục vụ bạn.\n"
                + "Lưu ý: Sau khi nhân viên hoàn thành xong mọi dịch vụ bạn đã chọn chúng tôi sẽ liên hệ qua số điện thoại để thông báo.\n"
                +"Vui lòng để"
                + "Trân trọng,\n"
                + "Đội ngũ dịch vụ.";

        try {
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();

            // Cấu hình SMTP
            Properties properties = new Properties();
            properties.put("mail.smtp.host", HOST);
            properties.put("mail.smtp.port", PORT);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            // Xác thực tài khoản email
            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });

            // Tạo email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(subject);
            message.setText(messageText);
            message.setHeader("Content-Type", "text/html; charset=UTF-8");
            message.setHeader("Content-Transfer-Encoding", "8bit");

            // Gửi email
            Transport.send(message);

            // Trả về thành công
            response.sendRedirect("index.jsp");

        } catch (MessagingException e) {
            e.printStackTrace();
            response.sendRedirect("appointment.jsp?error=Failed to send email. Please try again.");
        }
    }
}

