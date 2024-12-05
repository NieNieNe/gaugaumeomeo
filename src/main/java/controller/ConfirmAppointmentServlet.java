package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ConfirmAppointmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ request
        String clientName = request.getParameter("clientName");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String petName = request.getParameter("petName");
        String service = request.getParameter("service");

        // Đưa dữ liệu vào request để gửi tới JSP
        request.setAttribute("clientName", clientName);
        request.setAttribute("phoneNumber", phoneNumber);
        request.setAttribute("email", email);
        request.setAttribute("petName", petName);
        request.setAttribute("service", service);

        // Chuyển tiếp sang JSP
        request.getRequestDispatcher("confirmAppointment.jsp").forward(request, response);
    }
}
