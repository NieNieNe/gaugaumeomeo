<%--
  Created by IntelliJ IDEA.
  User: VICTUS
  Date: 12/4/2024
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Đặt Hẹn Không Có Tài Khoản</title>
    <link rel="stylesheet" href="css/appointmentNoAccount.css"> <!-- Đảm bảo file CSS đã được liên kết -->
</head>
<body>
<div class="appointment-form-container">
    <h2>Thông tin Đơn Hẹn:</h2>
    <form action="confirmAppointment.jsp" method="post">
        <!-- Họ và tên -->
        <label for="fullName">Họ và Tên:</label>
        <input type="text" id="fullName" name="fullName" required><br>

        <!-- Số điện thoại -->
        <label for="phone">Số điện thoại:</label>
        <input type="tel" id="phone" name="phone" required><br>

        <!-- Email -->
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <!-- Tên thú cưng -->
        <label for="petName">Tên thú cưng:</label>
        <input type="text" id="petName" name="petName" required>

        <!-- Loại thú cưng -->
        <label for="petType">Loại thú cưng:</label>
        <select id="petType" name="petType">
            <option value="dog">Chó</option>
            <option value="cat">Mèo</option>
            <option value="other">Khác</option>
        </select><br>

        <!-- Chọn ngày -->
        <label for="date">Chọn ngày:</label>
        <input type="date" id="date" name="date" required>

        <!-- Chọn giờ -->
        <label for="time">Chọn giờ:</label>
        <input type="time" id="time" name="time" required><br>

        <!-- Chọn dịch vụ -->
        <label>Chọn dịch vụ:</label><br>
        <input type="checkbox" name="service" value="grooming"> Chăm sóc lông
        <input type="checkbox" name="service" value="bathing"> Tắm
        <input type="checkbox" name="service" value="nails"> Cắt móng
        <input type="checkbox" name="service" value="deworm"> Sổ giun<br>

        <!-- Nút xác nhận -->
        <button type="submit" class="confirm-button">Xác nhận</button>
    </form>
</div>
</body>
</html>
