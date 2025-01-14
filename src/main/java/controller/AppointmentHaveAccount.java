package controller;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AppointmentHaveAccount extends HttpServlet {



        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // Lấy thông tin từ request
            String petType = request.getParameter("petType");
            String appointmentDate = request.getParameter("date");
            String appointmentTime = request.getParameter("appointment-time");
            String[] servicesArray = request.getParameterValues("service");

            // Gộp danh sách dịch vụ thành chuỗi
            String services = (servicesArray != null) ? String.join(",", servicesArray) : "";

            // Lấy username từ session
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");

            // Kiểm tra nếu username null (người dùng chưa đăng nhập)
            if (username == null) {
                response.sendRedirect("login.jsp"); // Chuyển hướng đến trang đăng nhập
                return;
            }

            // Lưu dữ liệu vào cơ sở dữ liệu
            try {
                JDBIConnector.getJdbi().useHandle(handle -> {
                    handle.createUpdate("INSERT INTO APPOINTMENTS (username, pet_type, appointment_date, appointment_time, services) VALUES (:username, :petType, :appointmentDate, :appointmentTime, :services)")
                            .bind("username", username)
                            .bind("petType", petType)
                            .bind("appointmentDate", Date.valueOf(appointmentDate))
                            .bind("appointmentTime", appointmentTime)
                            .bind("services", services)
                            .execute();
                });
                // Chuyển hướng đến trang xác nhận
                response.sendRedirect("confirmation.jsp");
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println("Error saving appointment: " + e.getMessage());
            }
        }
}







