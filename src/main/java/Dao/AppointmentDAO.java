package Dao;

import model.Appointment;
import model.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    // Thêm một bản ghi Appointment vào cơ sở dữ liệu
    public boolean addAppointment(Appointment appointment) {
        String sql = "INSERT INTO Appointment (idAppoint, userName, sdt, email, pet, date, time, service) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Kiểm tra dữ liệu đầu vào
            if (appointment == null ||
                    appointment.getUserName() == null ||
                    appointment.getSdt() == null ||
                    appointment.getEmail() == null ||
                    appointment.getPet() == null ||
                    appointment.getDate() == null ||
                    appointment.getTime() == null ||
                    appointment.getService() == null) {
                throw new IllegalArgumentException("Appointment details are incomplete.");
            }

            // Tạo idAppoint ngẫu nhiên
            String randomId = java.util.UUID.randomUUID().toString();

            // Thiết lập các giá trị tham số
            statement.setString(1, randomId); // ID cuộc hẹn
            statement.setString(2, appointment.getUserName()); // Tên người dùng
            statement.setString(3, appointment.getSdt()); // Số điện thoại
            statement.setString(4, appointment.getEmail()); // Email
            statement.setString(5, appointment.getPet()); // Tên thú cưng
            statement.setDate(6, Date.valueOf(appointment.getDate())); // Ngày hẹn

            // Xử lý định dạng thời gian
            try {
                String[] timeParts = appointment.getTime().split(":");
                Time sqlTime = Time.valueOf(timeParts[0] + ":" + timeParts[1] + ":00");
                statement.setTime(7, sqlTime);
            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid time format. Use HH:mm.");
            }

            // Lưu trường service dưới dạng chuỗi
            statement.setString(8, appointment.getService().getNameService());

            // Thực thi câu lệnh SQL
            statement.executeUpdate();
            appointment.setIdAppoint(randomId);
            return true;

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getSQLState() + " - " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Lấy danh sách tất cả các cuộc hẹn
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM Appointment";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Appointment appointment = new Appointment();

                // Lấy dữ liệu từ ResultSet
                appointment.setIdAppoint(resultSet.getString("idAppoint"));
                appointment.setUserName(resultSet.getString("userName"));
                appointment.setSdt(resultSet.getString("sdt"));
                appointment.setEmail(resultSet.getString("email"));
                appointment.setPet(resultSet.getString("pet"));
                appointment.setDate(resultSet.getDate("date").toString());
                appointment.setTime(resultSet.getTime("time").toString());

                // Khôi phục đối tượng service
                Service service = new Service();
                service.setNameService(resultSet.getString("service"));
                appointment.setService(service);

                appointments.add(appointment); // Thêm vào danh sách
            }
        } catch (SQLException e) {
            System.err.println("Error while retrieving appointments: " + e.getMessage());
            e.printStackTrace();
        }

        return appointments;
    }

    // Cập nhật thông tin cuộc hẹn
    public boolean updateAppointment(Appointment appointment) {
        String sql = "UPDATE Appointment SET userName = ?, sdt = ?, email = ?, pet = ?, date = ?, time = ?, service = ? WHERE idAppoint = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Kiểm tra dữ liệu đầu vào
            if (appointment == null ||
                    appointment.getUserName() == null ||
                    appointment.getSdt() == null ||
                    appointment.getEmail() == null ||
                    appointment.getPet() == null ||
                    appointment.getDate() == null ||
                    appointment.getTime() == null ||
                    appointment.getService() == null) {
                throw new IllegalArgumentException("Appointment details are incomplete.");
            }

            // Thiết lập các giá trị tham số
            statement.setString(1, appointment.getUserName());
            statement.setString(2, appointment.getSdt());
            statement.setString(3, appointment.getEmail());
            statement.setString(4, appointment.getPet());
            statement.setDate(5, Date.valueOf(appointment.getDate()));

            // Xử lý định dạng thời gian
            try {
                String[] timeParts = appointment.getTime().split(":");
                Time sqlTime = Time.valueOf(timeParts[0] + ":" + timeParts[1] + ":00");
                statement.setTime(6, sqlTime);
            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid time format. Use HH:mm.");
            }

            statement.setString(7, appointment.getService().getNameService());
            statement.setString(8, appointment.getIdAppoint());

            // Thực thi câu lệnh SQL
            statement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error while updating appointment: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Xóa một cuộc hẹn theo ID
    public boolean deleteAppointment(String idAppoint) {
        String sql = "DELETE FROM Appointment WHERE idAppoint = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Thiết lập tham số
            statement.setString(1, idAppoint);

            // Thực thi câu lệnh SQL
            statement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error while deleting appointment: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
