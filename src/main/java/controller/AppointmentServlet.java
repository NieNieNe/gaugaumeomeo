package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppointmentServlet")
public class AppointmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String service = request.getParameter("service");

        // Xử lý logic lưu thông tin đặt hẹn
        request.setAttribute("message", "Bạn đã đặt lịch hẹn thành công! Chúng tôi sẽ liên hệ với bạn sớm.");

        // Chuyển hướng đến trang xác nhận (confirmAppointment.jsp)
        request.getRequestDispatcher("confirmAppointment.jsp").forward(request, response);
    }
}

