package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ConfirmAppointmentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ session hoặc request
        String clientName = (String) request.getSession().getAttribute("clientName");
        String phoneNumber = (String) request.getSession().getAttribute("phoneNumber");
        String email = (String) request.getSession().getAttribute("email");
        String petName = (String) request.getSession().getAttribute("petName");
        String service = request.getParameter("service");
        String date = request.getParameter("date");
        String time = request.getParameter("time");

        // Lưu thông tin vào database hoặc xử lý logic
        // ...

        // Thông báo thành công
        response.getWriter().println("<script>alert('Đặt hẹn thành công!');window.location='index.jsp';</script>");
    }
}