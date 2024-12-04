package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve username and password from request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Simple authentication logic (to be replaced with real authentication)
        if ("admin".equals(username) && "password123".equals(password)) {
            // Redirect to index page on successful login
            response.sendRedirect("index.jsp");
        } else {
            // Set error message as request attribute
            request.setAttribute("errorMessage", "Invalid username or password!");
            // Forward the request back to the login page
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect GET requests to the login page
        response.sendRedirect("login.jsp");
    }
}


