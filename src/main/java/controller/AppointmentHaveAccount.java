package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

    public class AppointmentHaveAccount  extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            Integer userId = (Integer) session.getAttribute("userId");

            String name = "", email = "", phone = "";

            if (userId != null) {
                try {
                    // Kết nối CSDL
           //         Class.forName("");
                    Connection conn = DriverManager.getConnection("", "username", "password");

                    // Truy vấn dữ liệu khách hàng
                    String sql = "SELECT name, email, phone_number FROM users WHERE id= ?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, userId);

                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        name = rs.getString("name");
                        email = rs.getString("email");
                        phone = rs.getString("phone_number");
                    }
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // Gửi dữ liệu đến JSP
            request.setAttribute("name", name);
            request.setAttribute("email", email);
            request.setAttribute("phone", phone);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customerForm.jsp");
            dispatcher.forward(request, response);
        }
    }


