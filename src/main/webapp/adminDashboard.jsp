<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Appointment" %>
<%@ page import="Dao.AppointmentDAO" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="css/admin.css">
</head>
<body>
<h1>Danh sách cuộc hẹn</h1>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Họ và Tên</th>
        <th>Số Điện Thoại</th>
        <th>Email</th>
        <th>Thú Cưng</th>
        <th>Ngày</th>
        <th>Thời Gian</th>
        <th>Dịch Vụ</th>
    </tr>
    </thead>
    <tbody>
    <%
        // Lấy danh sách cuộc hẹn từ attribute
        List<Appointment> appointments = (List<Appointment>) request.getAttribute("appointments");

        if (appointments != null && !appointments.isEmpty()) {
            for (Appointment appointment : appointments) {
    %>
    <tr>
        <td><%= appointment.getIdAppoint() %></td>
        <td><%= appointment.getUserName() %></td>
        <td><%= appointment.getSdt() %></td>
        <td><%= appointment.getEmail() %></td>
        <td><%= appointment.getPet() %></td>
        <td><%= appointment.getDate() %></td>
        <td><%= appointment.getTime() %></td>
        <td><%= appointment.getService().getNameService() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="8">Không có cuộc hẹn nào.</td>
    </tr>
    <% } %>
    </tbody>
</table>

</body>
</html>
