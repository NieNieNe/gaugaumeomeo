package controller;

import Dao.AppointmentDAO;
import model.Appointment;
import model.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

    @WebServlet("/appointmentServlet")
    public class AppointmentServlet extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");

            try {
                // Lấy thông tin từ form
                String name = request.getParameter("name");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                String petType = request.getParameter("petType");
                String appointmentDate = request.getParameter("date");
                String appointmentTime = request.getParameter("appointment-time");
                String serviceName = request.getParameter("service"); // Chỉ lấy một dịch vụ

                // Kiểm tra thông tin bắt buộc
                if (name == null || name.trim().isEmpty() ||
                        phone == null || phone.trim().isEmpty() ||
                        email == null || email.trim().isEmpty() ||
                        petType == null || petType.trim().isEmpty() ||
                        appointmentDate == null || appointmentDate.trim().isEmpty() ||
                        appointmentTime == null || appointmentTime.trim().isEmpty() ||
                        serviceName == null || serviceName.trim().isEmpty()) {

                    response.sendRedirect("appointment.jsp?error=Vui lòng điền đầy đủ thông tin.");
                    return;
                }

                // Kiểm tra định dạng email
                if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    response.sendRedirect("appointment.jsp?error=Email không hợp lệ.");
                    return;
                }

                // Tạo đối tượng Appointment
                Appointment appointment = new Appointment();
                appointment.setIdAppoint(UUID.randomUUID().toString()); // Tạo UUID ngẫu nhiên
                appointment.setUserName(name);
                appointment.setSdt(phone);
                appointment.setEmail(email);
                appointment.setPet(petType);
                appointment.setDate(appointmentDate);
                appointment.setTime(appointmentTime);

                // Chỉ định dịch vụ đã chọn
                Service service = new Service();
                service.setNameService(serviceName); // Gắn tên dịch vụ
                appointment.setService(service);

                // Lưu dữ liệu vào cơ sở dữ liệu
                AppointmentDAO appointmentDAO = new AppointmentDAO();
//                boolean isSaved = appointmentDAO.addAppointment(appointment);

//                if (isSaved) {
//                    // Chuyển đến trang xác nhận
//                    request.setAttribute("name", name);
//                    request.setAttribute("phone", phone);
//                    request.setAttribute("email", email);
//                    request.setAttribute("date", appointmentDate);
//                    request.setAttribute("time", appointmentTime);
//                    request.setAttribute("service", serviceName);
//
//                    request.getRequestDispatcher("confirm.jsp").forward(request, response);
//                } else {
//                    response.sendRedirect("appointment.jsp?error=Không thể lưu thông tin đặt hẹn. Vui lòng thử lại.");
//                }
                boolean isSaved = appointmentDAO.addAppointment(appointment);
                if (isSaved) {
                    // Redirect đến admin dashboard sau khi lưu thành công
                    response.sendRedirect("adminDashboard.jsp");
                } else {
                    response.sendRedirect("appointment.jsp?error=Không thể lưu thông tin đặt hẹn. Vui lòng thử lại.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("appointment.jsp?error=Đã xảy ra lỗi trong quá trình xử lý. Vui lòng thử lại.");
            }
        }
    }


