package controller;

import model.emailService;
import model.iJavaMail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sendEmail")
public class SendEmailServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String subject = "Xác nhận đặt lịch hẹn";
        String body = "<h1>Thông tin đặt lịch</h1>" +
                "<p>Họ và tên: " + name + "</p>" +
                "<p>Email: " + email + "</p>";

        // Gửi email
        iJavaMail emailService = new emailService();
        boolean result = emailService.send(email, subject, body);

        // Kiểm tra nếu gửi thành công
        if (result) {
            // Chuyển hướng về index.jsp
            response.sendRedirect("index.jsp");
        } else {
            // Hiển thị thông báo lỗi nếu gửi thất bại
            request.setAttribute("error", "Gửi email thất bại. Vui lòng thử lại!");
            request.getRequestDispatcher("appointment.jsp").forward(request, response);
        }
    }
}
