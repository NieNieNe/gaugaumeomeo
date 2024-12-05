<%--
  Created by IntelliJ IDEA.
  User: FPT SHOP
  Date: 11/28/2024
  Time: 12:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập - PetCare</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<div class="login-container">
    <h2>Đăng nhập vào PetCare</h2>
    <form action="login" method="post">
        <c:if test="${not empty errorMessage}">
        <p style="color: red;">${errorMessage}</p>
        </c:if>
        <div class="form-group">

            <label for="username">Tên đăng nhập</label>
            <input type="text" id="username" name="username" placeholder="Nhập tên đăng nhập" required>
        </div>
        <div class="form-group">
            <label for="password">Mật khẩu</label>
            <input type="password" id="password" name="password" placeholder="Nhập mật khẩu" required>
        </div>
        <button type="submit">Đăng nhập</button>
    </form>
    <div class="footer">
        Chưa có tài khoản? <a href="register.jsp">Đăng ký ngay</a>
    </div>

</div>
</body>
</html>