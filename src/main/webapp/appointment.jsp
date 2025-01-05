<%
  String name = (String) request.getAttribute("name");
  String email = (String) request.getAttribute("email");
  String phone = (String) request.getAttribute("phone");
%>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Đặt Hẹn</title>
  <link rel="stylesheet" href="css/appointment.css">
</head>
<body>
<div class="container">
  <h2>Thông tin Đơn Hẹn:</h2>
  <form action="confirmAppointment.jsp" method="post">
    <!-- Họ và Tên -->
    <label for="name">Họ và tên:</label>
    <input type="text" id="name" name="name" value="<%= name != null ? name : "" %>" placeholder="Nhập họ và tên" required>
    <!-- Số điện thoại -->
    <label for="phone">Số điện thoại:</label>
    <input type="text" id="phone" name="phone" value="<%= phone != null ? phone : "" %>" placeholder="Nhập số điện thoại" required>
    <!-- Email -->
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="<%= email != null ? email : "" %>" placeholder="Nhập email" required>
    <label for="petType">Loại thú cưng:</label>
    <select id="petType" name="petType">
      <option value="dog">Chó</option>
      <option value="cat">Mèo</option>
      <option value="other">Khác</option>
    </select>

    <label for="date">Chọn ngày:</label>
    <input type="date" id="date" name="date" required>

    <label for="time">Chọn giờ:</label>
    <input type="time" id="time" name="time" required>

    <label>Chọn dịch vụ:</label>
    <input type="checkbox" name="service" value="grooming"> Chăm sóc lông
    <input type="checkbox" name="service" value="bathing"> Tắm
    <input type="checkbox" name="service" value="nails"> Cắt móng
    <input type="checkbox" name="service" value="deworm"> Sổ giun

    <button type="submit" class="btn-submit">Xác nhận</button>
  </form>
</div>
</body>
</html>

