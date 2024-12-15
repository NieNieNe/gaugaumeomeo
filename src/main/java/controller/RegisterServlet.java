package controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        String dateofBirth = request.getParameter("dateofBirth");
        int petsCount = Integer.parseInt(request.getParameter("petsCount"));
        String phoneNumber = request.getParameter("phoneNumber");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        UserManage userManage = new UserManage();
        List<User> users = userManage.getUsers();
        System.out.println("Loaded users: " + users);
        // Lưu dữ liệu vào cơ sở dữ liệu
        JDBIConnector.getJdbi().useHandle(handle -> {
            handle.createUpdate("INSERT INTO USERS (fullname, dateofBirth, petsCount, phoneNumber, username, password) VALUES (:fullname, :dateofBirth, :petsCount, :phoneNumber, :username, :password)")
                    .bind("fullname", fullname)
                    .bind("dateofBirth", dateofBirth)
                    .bind("petsCount", petsCount)
                    .bind("phoneNumber", phoneNumber)
                    .bind("username", username)
                    .bind("password", password)
                    .execute();
        });

        // Chuyển hướng đến trang index
        response.sendRedirect("index.jsp");
    }
}