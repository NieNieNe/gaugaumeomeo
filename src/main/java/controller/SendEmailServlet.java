package controller;

import model.emailService;
import model.iJavaMail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.*;
import javax.mail.internet.*;

import java.io.IOException;
import java.util.Properties;

@WebServlet("/sendEmail")
public class SendEmailServlet extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String date = request.getParameter("date");
        String time = request.getParameter("appointment-time");
        String services = request.getParameter("service");

        iJavaMail emailService = new emailService();

        String subject = "Xác Nhận Đặt Lịch";
        String content = "<h1>Thông tin đặt lịch</h1>" +
                "<p><strong>Họ và tên:</strong> " + name + "</p>" +
                "<p><strong>Số điện thoại:</strong> " + phone + "</p>" +
                "<p><strong>Email:</strong> " + email + "</p>" +
                "<p><strong>Ngày:</strong> " + date + "</p>" +
                "<p><strong>Giờ:</strong> " + time + "</p>" +
                "<p><strong>Dịch vụ:</strong> " + services + "</p>";

        emailService.send(email, subject, content);


    }

}
