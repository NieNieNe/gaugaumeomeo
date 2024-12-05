package controller;

import model.Appointment;
import model.Booking;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StaffBookingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy danh sách booking từ cơ sở dữ liệu (mô phỏng)
        List<Booking> bookings = getAllBookingsFromDatabase();

        // Truyền danh sách booking vào request
        request.setAttribute("bookings", bookings);

        // Chuyển hướng đến trang JSP hiển thị
        request.getRequestDispatcher("staffBookings.jsp").forward(request, response);
    }

    private List<Booking> getAllBookingsFromDatabase() {
        // Giả lập dữ liệu booking (thay bằng logic thực tế)
        List<Booking> bookings = new ArrayList<>();
        Booking booking = new Booking();
        booking.setId(1L);
        Appointment appointment = new Appointment();
        appointment.setAppointment("Grooming");
        booking.setAppointment(appointment);
        booking.setDate(new java.util.Date());
        bookings.add(booking);
        return bookings;
    }
}
