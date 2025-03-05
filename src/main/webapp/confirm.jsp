<%--
  Created by IntelliJ IDEA.
  User: VICTUS
  Date: 1/16/2025
  Time: 3:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xác nhận thông tin đặt hẹn</title>
</head>
<body>
<h2>Xác nhận thông tin đặt hẹn</h2>
<p>Họ và tên: <%= request.getAttribute("name") %></p>
<p>Số điện thoại: <%= request.getAttribute("phone") %></p>
<p>Email: <%= request.getAttribute("email") %></p>
<p>Ngày: <%= request.getAttribute("date") %></p>
<p>Thời gian: <%= request.getAttribute("time") %></p>
<p>Dịch vụ: <%= request.getAttribute("services") %></p>

<form action="sendEmailServlet" method="post">
    <input type="hidden" name="name" value="<%= request.getAttribute("name") %>">
    <input type="hidden" name="phone" value="<%= request.getAttribute("phone") %>">
    <input type="hidden" name="email" value="<%= request.getAttribute("email") %>">
    <input type="hidden" name="date" value="<%= request.getAttribute("date") %>">
    <input type="hidden" name="time" value="<%= request.getAttribute("time") %>">
    <input type="hidden" name="services" value="<%= request.getAttribute("services") %>">
    <button type="submit">Gửi Email</button>
</form>
</body>
</html>
