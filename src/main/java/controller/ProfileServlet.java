
    package controller;

import model.User;
import model.UserManage;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

    @WebServlet("/profile")
    public class ProfileServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user"); // Lấy thông tin người dùng từ session



            // Lấy thông tin từ database
            UserManage userManage = new UserManage();
            User fullUserInfo = userManage.findUser(user.getUsername());

            if (fullUserInfo != null) {
                // Truyền dữ liệu vào JSP
                request.setAttribute("user", fullUserInfo);

            } else {
                // Nếu không tìm thấy user, hiển thị lỗi
                request.setAttribute("error", "Không tìm thấy thông tin người dùng.");
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
            dispatcher.forward(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
        }
    }

