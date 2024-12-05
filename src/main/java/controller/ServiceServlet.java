package controller;


import model.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ServiceServlet")
public class ServiceServlet extends HttpServlet {
    private List<Service> services = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Đưa danh sách dịch vụ vào request scope
        req.setAttribute("services", services);
        // Forward đến JSP để hiển thị danh sách
        RequestDispatcher dispatcher = req.getRequestDispatcher("services.jsp");
        dispatcher.forward(req, resp);
    }
}