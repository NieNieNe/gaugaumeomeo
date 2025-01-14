<%--
  Created by IntelliJ IDEA.
  User: FPT SHOP
  Date: 12/9/2024
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>



<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hồ sơ cá nhân - PetCare</title>
    <link rel="stylesheet" href="css/profile.css?v=1.0">
</head>
<body>
<div class="profile-container">
    <h1>Hồ sơ cá nhân</h1>

    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>

    <c:if test="${not empty user}">
        <div class="profile-details">
            <!-- Nút Đăng xuất -->
            <c:if test="${not empty user}">
                <div class="logout-container">
                    <a href="logout" class="logout-btn">Đăng xuất</a>
                </div>
            </c:if>
            <div class="profile-info">
                <h2>Thông tin cá nhân</h2>
                <p><strong>Tên người dùng:</strong> ${user.fullname}</p>

                <p><strong>Số điện thoại:</strong> ${user.phonenumber}</p>
                <p><strong>Ngày sinh:</strong> ${user.dateofBirth}</p>
                <p><strong>Số lượng thú cưng:</strong> ${user.petsCount}</p>
            </div>

            <!-- Nút Lịch sử đặt hẹn -->
            <div class="history-container">
                <a href="history.jsp" class="history-btn">Xem lịch sử đặt hẹn</a>
            </div>
        </div>
    </c:if>
</div>
</body>
</html>
