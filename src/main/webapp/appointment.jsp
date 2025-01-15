<%
  String error = request.getParameter("error");
%>
<!DOCTYPE html>
<html lang="vi">
<head>
  <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Đặt Hẹn</title>
  <link rel="stylesheet" href="css/appointment.css?v=1.0">
</head>
<body>
<div class="container">
  <h2>Thông tin đặt hẹn</h2>

  <!-- Hiển thị lỗi nếu có -->
  <% if (error != null) { %>
  <p class="error" style="color: red;"><%= error %></p>
  <% } %>

  <form action="SendEmailServlet" method="post">
    <!-- Họ và Tên -->
    <label for="name">Họ và tên:</label>
    <input type="text" id="name" name="name" placeholder="Nhập họ và tên" required>

    <!-- Số điện thoại -->
    <label for="phone">Số điện thoại:</label>
    <input type="text" id="phone" name="phone" placeholder="Nhập số điện thoại" required>

    <!-- Email -->
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" placeholder="Nhập email" required>

    <!-- Loại thú cưng -->
    <label for="petType">Loại thú cưng:</label>
    <select id="petType" name="petType">
      <option value="dog">Chó</option>
      <option value="cat">Mèo</option>
      <option value="other">Khác</option>
    </select>

    <!-- Chọn ngày -->
    <label for="date">Chọn ngày:</label>
    <input type="date" id="date" name="date" required>

    <!-- Chọn thời gian -->
    <label for="appointment-time">Chọn thời gian:</label>
    <input type="text" id="appointment-time" name="appointment-time" required>
    <!-- Chọn dịch vụ -->
    <label>Chọn dịch vụ:</label>
    <input type="checkbox" name="service" value="grooming"> Chăm sóc lông
    <input type="checkbox" name="service" value="bathing"> Tắm
    <input type="checkbox" name="service" value="nails"> Cắt móng
    <input type="checkbox" name="service" value="deworm"> Sổ giun
    <button type="submit">Xác nhận</button>
  </form>

</div>
<div id="confirmationModal" class="modal">
  <div class="modal-content">
    <span class="close-button">&times;</span>
    <h2>Xác Nhận Thông Tin</h2>
    <p>Họ và tên: <strong id="confirmName"></strong></p>
    <p>Số điện thoại: <strong id="confirmPhone"></strong></p>
    <p>Email: <strong id="confirmEmail"></strong></p>
    <p>Thời gian: <strong id="confirmTime"></strong></p>
    <p>Dịch vụ: <strong id="confirmService"></strong></p>
    <button id="confirmButton">Gửi</button>
  </div>
</div>
<!-- Thêm JavaScript -->
<script>
  // Đặt giá trị ngày tối thiểu cho input date
  const today = new Date();
  const dateInput = document.getElementById("date");
  // Format ngày hiện tại theo chuẩn "YYYY-MM-DD"
  const formattedDate = today.toISOString().split('T')[0];
  dateInput.min = formattedDate; // Ngày tối thiểu là hôm nay
</script>
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script>
  flatpickr("#appointment-time", {
    enableTime: true, // Bật tính năng chọn giờ
    noCalendar: true, // Ẩn phần chọn ngày
    dateFormat: "H:i", // Định dạng giờ: phút
    minTime: "07:00", // Giờ tối thiểu
    maxTime: "17:00", // Giờ tối đa
    time_24hr: true,  // Hiển thị giờ 24h
    minuteIncrement: 30 // Tăng theo từng 30 phút
  });
</script>
<script>
   const form = document.querySelector("form");
   const modal = document.getElementById("confirmationModal");
   const closeButton = document.querySelector(".close-button");
   const confirmButton = document.getElementById("confirmButton");

   // Lấy các phần tử trong modal
   const confirmName = document.getElementById("confirmName");
   const confirmPhone = document.getElementById("confirmPhone");
   const confirmEmail = document.getElementById("confirmEmail");
   const confirmTime = document.getElementById("confirmTime");
   const confirmService = document.getElementById("confirmService");

   // Hiển thị modal khi nhấn nút xác nhận
   form.addEventListener("submit", (event) => {
     event.preventDefault(); // Ngăn form gửi ngay

     // Lấy dữ liệu từ các trường trong form
     confirmName.textContent = document.getElementById("name").value;
     confirmPhone.textContent = document.getElementById("phone").value;
     confirmEmail.textContent = document.getElementById("email").value;
     confirmTime.textContent = document.getElementById("appointment-time").value;

     const selectedServices = Array.from(document.querySelectorAll("input[name='service']:checked"))
             .map(service => service.value)
             .join(", ");
     confirmService.textContent = selectedServices || "Không chọn";

     modal.style.display = "block"; // Hiển thị modal
   });

   // Đóng modal khi nhấn nút đóng
   closeButton.addEventListener("click", () => {
     modal.style.display = "none";
   });

   // Gửi form khi nhấn nút xác nhận trong modal
   confirmButton.addEventListener("click", () => {
     modal.style.display = "none";
     form.submit(); // Gửi form
   });
</SCRIPT>

</body>
</html>
