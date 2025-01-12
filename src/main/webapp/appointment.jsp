<%
  String name = (String) request.getAttribute("name");
  String email = (String) request.getAttribute("email");
  String phone = (String) request.getAttribute("phone");
%>
<!DOCTYPE html>
<html lang="vi">
<head>
  <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Đặt Hẹn</title>
  <link rel="stylesheet" href="css/appointment.css">
</head>
<body>
<div class="container">
  <h2>Thông tin đặt hẹn :</h2>
    <!-- Họ và Tên -->
    <label for="name">Họ và tên:</label>
    <input type="text" id="name" name="name" value="<%= name != null ? name : "" %>" placeholder="Nhập họ và tên" required>

    <!-- Số điện thoại -->
    <label for="phone">Số điện thoại:</label>
    <input type="text" id="phone" name="phone" value="<%= phone != null ? phone : "" %>" placeholder="Nhập số điện thoại" required>

    <!-- Email -->
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="<%= email != null ? email : "" %>" placeholder="Nhập email" required>

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

  <button type="button" class="btn-submit" id="showModal">Xác nhận</button>
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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">

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

<script>
  const modal = document.getElementById("confirmationModal");
  const closeButton = document.querySelector(".close-button");
  const showModal = document.getElementById("showModal");
  const confirmButton = document.getElementById("confirmButton");

  // Hiển thị modal khi nhấn nút "Xác nhận"
  showModal.addEventListener("click", function () {
    // Lấy dữ liệu từ form
    const name = document.getElementById("name").value;
    const phone = document.getElementById("phone").value;
    const email = document.getElementById("email").value;
    const time = document.getElementById("appointment-time").value;
    const services = Array.from(
            document.querySelectorAll('input[name="service"]:checked')
    )
            .map(service => service.value)
            .join(", ");

    // Điền thông tin vào modal
    document.getElementById("confirmName").innerText = name;
    document.getElementById("confirmPhone").innerText = phone;
    document.getElementById("confirmEmail").innerText = email;
    document.getElementById("confirmTime").innerText = time;
    document.getElementById("confirmService").innerText = services;

    // Hiển thị modal
    modal.style.display = "block";
  });

  // Đóng modal khi nhấn nút "x"
  closeButton.addEventListener("click", function () {
    modal.style.display = "none";
  });

  // Đóng modal khi nhấn bên ngoài modal
  window.addEventListener("click", function (event) {
    if (event.target === modal) {
      modal.style.display = "none";
    }
  });
  // Xử lý khi nhấn vào nút "Gửi"
  confirmButton.addEventListener("click", function () {
    alert("Đặt lịch thành công!");
    // Điều hướng về trang chủ
    window.location.href = "index.jsp";
    // Gửi form tới server
    document.querySelector("form").submit();
  });


</script>

</body>
</html>
