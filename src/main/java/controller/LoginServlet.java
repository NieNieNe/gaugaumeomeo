package controller;
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

    UserManage userManage = new UserManage();
    List<User> users = userManage.getUsers();
    System.out.println("Loaded users: " + users); // Debug danh sách user

    User user = userManage.findUser(username);
    if (user != null ) {
        System.out.println("Found user: " + user.getUsername()); // Debug người dùng
        if (user.getPassword().equals(password)) {
            url = "/index.jsp";
            session.setAttribute("au", true);
            session.setAttribute("user", user);
            session.setAttribute("users", users);
        } else {
            error = "Sai mật khẩu";
        }
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
        doGet(request, response);
    }}





