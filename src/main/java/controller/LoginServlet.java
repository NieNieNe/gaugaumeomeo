package controller;
import Dao.ClientDAO;
import model.Client;
import model.User;
import model.UserManage;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    HttpSession session = request.getSession();
    session.setAttribute("username", username);

    String url = "/login.jsp"; // Mặc định chuyển đến trang đăng nhập
    String error = null; // Biến để lưu thông báo lỗi

    ClientDAO clientDAO = new ClientDAO();
    Client user = clientDAO.login(username, password);

System.out.print(user);

    if (user != null ) {
        System.out.println("Found user: " + user.getName()); // Debug người dùng
            url = "/index.jsp";
            session.setAttribute("au", true);
            session.setAttribute("user", user);
            request.getRequestDispatcher(url).forward(request, response);
    } else {
        error = "Không tìm thấy username";
    }

    if (error != null) {
        System.out.println("Error: " + error); // Debug thông báo lỗi
        request.setAttribute("errorMessage", error);
    }

    RequestDispatcher rd = request.getServletContext().getRequestDispatcher(url);
    rd.forward(request, response);
}



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClientDAO clienDao = new ClientDAO();

        doGet(request, response);
    }}





