<%--
  Created by IntelliJ IDEA.
  User: VICTUS
  Date: 12/4/2024
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: VICTUS
  Date: 12/4/2024
  Time: 8:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Nhập Lịch Hẹn</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
<h2>Nhập Thông Tin Lịch Hẹn</h2>
<form action="ConfirmAppointmentServlet" method="post">
  <label for="date">Chọn ngày:</label>
  <input type="date" id="date" name="date" required>

  <label for="time">Chọn giờ:</label>
  <input type="time" id="time" name="time" required>

  <label for="service">Chọn dịch vụ:</label>
  <select id="service" name="service">
    <option value="grooming">Chăm sóc lông</option>
    <option value="bathing">Tắm</option>
    <option value="nail">Cắt móng</option>
  </select>

  <button type="submit"><a href="confirmAppointment.jsp">Xác Nhận </a> </button>
</form>
</body>
</html>

