package controller;


import Dao.AppointmentDAO;
import model.Appointment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminDashboard")
public class AdminDashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        // Lấy danh sách tất cả cuộc hẹn
        List<Appointment> appointments = appointmentDAO.getAllAppointments();

        // Đặt danh sách vào request attribute
        request.setAttribute("appointments", appointments);

        // Chuyển tiếp đến trang adminDashboard.jsp
        request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
    }
}
