<%--
  Created by IntelliJ IDEA.
  User: VICTUS
  Date: 11/25/2024
  Time: 5:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>GauGauMeoMeo</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%

    String username = (String) session.getAttribute("username");

    if (username != null) { %>
<a href="profile.jsp" class="profile-button">Hồ sơ</a>
<%

    }
%>

<!-- Thanh điều hướng -->
<header>
    <nav class="navbar">
        <div class="logo">
            <img src="image/logo.png" alt="Animal Doctors">
        </div>
        <ul class="nav-links">
            <li><a href="#">Về Chúng Tôi</a></li>
            <li><a href="#">Các Dịch Vụ</a></li>
            <li><a href="outreach.html">Cộng Đồng</a></li>
            <li><a href="branches.html">Các Chi Nhánh</a></li>
            <li><a href="VIPet.jsp">VIPet</a></li>
        </ul>
        <button id="appointmentButton" class="appointment-button">Đặt Hẹn</button>
    </nav>
</header>

<!-- Phần nội dung chính -->
<main>

    <section class="service-description">
        <h1>Chăm sóc lông</h1>
        <p>Chăm sóc lông là điều cần thiết để giữ cho thú cưng của bạn trông xinh đẹp tuyệt vời...</p>
        <p>Đôi bên cùng có lợi, cho bạn và cho thú cưng của bạn.</p>
    </section>
    <div class="benefits">
        <div class="dog-head">
            <div class="label label-1">An toàn</div>
            <div class="label label-2">Chất lượng cao</div>
            <div class="label label-3">Sạch sẽ & Vệ sinh</div>
            <div class="label label-4">Tay nghề cao</div>
            <div class="label label-5">Thoải mái</div>
            <div class="label label-6">Sức khỏe là trên hết</div>
        </div>
    </div>

    <section class="container">
        <h1>Chăm sóc cho thú cưng từ đầu đến đuôi</h1>
        <div class="grid">
            <div class="card"><img src="image/cs1_trangchu.png" alt="Dog grooming"></div>
            <div class="card"><img src="image/cs2_trangchu.png" alt="Dog grooming"></div>
            <div class="card"><img src="image/cs3_trangchu.png" alt="Dog grooming"></div>
            <div class="card"><img src="image/cs4_trangchu.png" alt="Cat grooming"></div>
            <div class="card"><img src="image/cs5_trangchu.png" alt="Cat grooming"></div>
            <div class="card"><img src="image/cs6_trangchu.png" alt="Cat grooming"></div>
        </div>
    </section>

    <footer class="footer">
        <div class="newsletter">
            <p>Animal Doctors International</p>
            <button class="register-button"><a href="register.jsp">Đăng ký </a></button>
            <button class="login-button"><a href="login.jsp">Đăng nhập</a>Đăng</button>
        </div>

        <div class="footer-links">
            <div>
                <h4>Các Dịch Vụ</h4>
                <ul>
                    <li>Sức Khỏe Lâm Sàng</li>
                    <li>Triệt Sản</li>
                    <li>Chăm Sóc Lông – Grooming</li>
                    <li>Viện Phí</li>
                </ul>
            </div>
            <div>
                <h4>Blog</h4>
                <ul>
                    <li>Các sự kiện</li>
                    <li>Outreach</li>
                    <li>Các Câu Hỏi Thường Gặp – FAQs</li>
                </ul>
            </div>
            <div>
                <h4>Về Chúng Tôi</h4>
                <ul>
                    <li>Các Chi Nhánh</li>
                    <li>Việc Làm</li>
                    <li>VIPet</li>
                    <li>Các Chính Sách</li>
                    <li>Chính Sách Bảo Mật</li>
                </ul>
            </div>
        </div>

        <div class="footer-contact">
            <h4>VIỆT NAM</h4>
            <p>Hotline: 0366216414</p>
            <p>Email: 22130317@st.hcmuaf.edu.vn</p>
            <p>Giờ mở cửa: hum bt </p>
        </div>

        <div class="social-media">
            <a href="https://www.facebook.com/tuyen.tranthimy.52"><i class="fab fa-facebook-f"></i></a>
            <a href="https://www.instagram.com/river_t04/"><i class="fab fa-instagram"></i></a>
        </div>
    </footer>
</main>
<!-- Pop-up nêu lưu ý -->
<div id="appointmentPopup" class="modal">
    <div class="modal-content">
        <link rel="stylesheet" href="css/appointment-popup.css">
        <span class="close-button">&times;</span>
        <h2>Lưu ý trước khi đặt hẹn</h2>
        <ul>
            <li>Vui lòng điền đầy đủ thông tin cần thiết khi đặt hẹn.</li>
            <li>Đảm bảo thời gian đặt hẹn không trùng với các công việc khác.</li>
            <li>Thông tin dịch vụ sẽ được xác nhận qua email hoặc số điện thoại.</li>
        </ul>
        <button id="proceedToAppointment" class="confirm-button">Đặt Hẹn</button>
    </div>
</div>

<script>
    // Lấy các phần tử trong DOM
    const appointmentButton = document.getElementById('appointmentButton'); // Nút "Đặt Hẹn" trên trang chính
    const appointmentPopup = document.getElementById('appointmentPopup'); // Pop-up
    const closeButton = document.querySelector('.close-button'); // Nút đóng pop-up
    const proceedToAppointment = document.getElementById('proceedToAppointment'); // Nút "Đặt Hẹn" trong pop-up

    // Hiển thị pop-up khi bấm nút "Đặt Hẹn"
    appointmentButton.addEventListener('click', () => {
        appointmentPopup.style.display = 'block';
    });

    // Đóng pop-up khi bấm nút "X"
    closeButton.addEventListener('click', () => {
        appointmentPopup.style.display = 'none';
    });

    // Đóng pop-up khi bấm ra ngoài
    window.addEventListener('click', (event) => {
        if (event.target === appointmentPopup) {
            appointmentPopup.style.display = 'none';
        }
    });

    // Chuyển hướng đến trang "appointmentHaveAccount.jsp" khi bấm "Đặt Hẹn"
    proceedToAppointment.addEventListener('click', () => {
        window.location.href = 'appointment.jsp';
    });

</script>


</body>
</html>
