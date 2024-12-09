package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve username and password from request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        // Simple authentication logic (to be replaced with real authentication)
        if ("admin".equals(username) && "password123".equals(password)) {

            session.setAttribute("username", username); // Lưu tên người dùng
            request.setAttribute("username", username);
            session.setAttribute("au", true);
            response.sendRedirect("index.jsp");

        } else {
            // Set error message as request attribute
            request.setAttribute("errorMessage", "Invalid username or password!");
            // Forward the request back to the login page
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }


}


