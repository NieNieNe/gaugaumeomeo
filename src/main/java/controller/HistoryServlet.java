//package controller;
//import model.Appointment;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.sql.Date;
//import java.sql.Time;
//import java.util.List;
//public class HistoryServlet {
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Lấy username từ session
//        HttpSession session = request.getSession();
//        String username = (String) session.getAttribute("username");
//
//        // Kiểm tra nếu username null (người dùng chưa đăng nhập)
//        if (username == null) {
//            response.sendRedirect("login.jsp"); // Chuyển hướng đến trang đăng nhập nếu chưa đăng nhập
//            return;
//        }
//
//        // Lấy danh sách các cuộc hẹn của username từ cơ sở dữ liệu
//        try {
//            List<Appointment> appointments = JDBIConnector.getJdbi().withHandle(handle ->
//                    handle.createQuery("SELECT pet_type, appointment_date, appointment_time, services FROM appointment WHERE username = :username")
//                            .bind("username", username) // Truy vấn chỉ lấy các cuộc hẹn của người dùng này
//                            .mapToBean(Appointment.class) // Ánh xạ kết quả thành đối tượng Appointment
//                            .list() // Lấy danh sách các cuộc hẹn
//            );
//
//            // Kiểm tra nếu không tìm thấy cuộc hẹn nào cho username
//            if (appointments.isEmpty()) {
//                request.setAttribute("message", "Không có cuộc hẹn nào được tìm thấy.");
//            }
//
//            // Gửi danh sách cuộc hẹn đến trang JSP
//            request.setAttribute("appointments", appointments);
//            request.getRequestDispatcher("appointment.jsp").forward(request, response); // Chuyển hướng đến JSP để hiển thị
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.getWriter().println("Lỗi khi lấy dữ liệu cuộc hẹn: " + e.getMessage());
//        }
//    }
//}
//
