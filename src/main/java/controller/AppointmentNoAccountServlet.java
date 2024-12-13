package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AppointmentNoAccountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String petName = request.getParameter("petName");
        String petType = request.getParameter("petType");

        // Lưu thông tin vào session
        HttpSession session = request.getSession();
        session.setAttribute("clientName", name);
        session.setAttribute("phoneNumber", phoneNumber);
        session.setAttribute("email", email);
        session.setAttribute("petName", petName);
        session.setAttribute("petType", petType);
    }
}