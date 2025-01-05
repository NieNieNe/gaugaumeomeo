<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Xác Nhận Đặt Lịch</title>
</head>
<body>

<!-- Modal Xác Nhận -->
<div id="confirmationModal" class="modal">
    <link rel="stylesheet" type="text/css" href="css/confirmAppointment.css">
    <div class="modal-content">
        <span class="close-button">&times;</span>
        <h2>Xác Nhận Thông Tin</h2>
        <p>Họ và tên: <strong>${requestScope.clientName}</strong></p>
        <p>Số điện thoại: <strong>${requestScope.phoneNumber}</strong></p>
        <p>Email: <strong>${requestScope.email}</strong></p>
        <p>Tên thú cưng: <strong>${requestScope.petName}</strong></p>
        <p>Dịch vụ: <strong>${requestScope.service}</strong></p>
        <button id="confirmButton">Gửi</button>
    </div>
</div>

<script>
    // Lấy modal và các nút cần thao tác
    const confirmationModal = document.getElementById("confirmationModal");
    const closeButton = document.querySelector(".close-button");
    const confirmButton = document.getElementById("confirmButton");

    // Hiển thị modal khi trang được tải
    window.onload = function () {
        confirmationModal.style.display = "block";
    };

    // Đóng modal khi nhấn vào nút đóng
    closeButton.addEventListener("click", function () {
        confirmationModal.style.display = "none";
    });

    // Đóng modal khi nhấn bên ngoài modal
    window.addEventListener("click", function (event) {
        if (event.target === confirmationModal) {
            confirmationModal.style.display = "none";
        }
    });

    // Xử lý khi nhấn vào nút "Gửi"
    confirmButton.addEventListener("click", function () {
        alert("Đặt lịch thành công!");
        confirmationModal.style.display = "none";

        // Điều hướng về trang chủ
        window.location.href = "index.jsp";
    });
</script>
</body>
</html>
