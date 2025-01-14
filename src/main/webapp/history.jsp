<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lịch sử đặt hẹn - PetCare</title>
    <link rel="stylesheet" href="css/profile.css?v=1.0">
</head>
<body>
<div class="profile-container">
    <h1>Lịch sử đặt hẹn</h1>

    <!-- Hiển thị thông báo lỗi nếu có -->
    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>

    <!-- Hiển thị thông tin lịch sử đặt hẹn -->
    <c:if test="${not empty appointments}">
        <div class="appointments-info">
            <h2>Danh sách lịch sử đặt hẹn</h2>
            <table>
                <thead>
                <tr>
                    <th>Loại thú cưng : Chó </th>
                    <th>Ngày đặt hẹn : 15/01/2025</th>
                    <th>Thời gian đặt hẹn : 11:00</th>
                    <th>Dịch vụ : chăm sóc lông </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="appointment" items="${appointments}">
                    <tr>
                        <!-- Hiển thị loại thú cưng -->
                        <td>${appointment.petType}</td>
                        <!-- Hiển thị ngày đặt hẹn -->
                        <td>${appointment.appointmentDate}</td>
                        <!-- Hiển thị thời gian đặt hẹn -->
                        <td>${appointment.appointmentTime}</td>
                        <!-- Hiển thị dịch vụ -->
                        <td>${appointment.services}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>

    <!-- Nút quay lại trang hồ sơ cá nhân -->
    <div class="back-container">
        <a href="profile.jsp" class="back-btn">Quay lại hồ sơ cá nhân</a>
    </div>

    <!-- Nút Đăng xuất -->
    <div class="logout-container">
        <a href="logout" class="logout-btn">Đăng xuất</a>
    </div>
</div>
</body>
</html>
