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
    // Sử dụng biến session mặc định của JSP
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
            <img src="image/logo_trangchu.png" alt="Animal Doctors">
        </div>
        <ul class="nav-links">
            <li><a href="#">Về Chúng Tôi</a></li>
            <li><a href="#">Các Dịch Vụ</a></li>
            <li><a href="#">Cộng Đồng</a></li>
            <li><a href="#">Các Chi Nhánh</a></li>
            <li><a href="#">VIPet</a></li>
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

    <section class="benefits">
        <div class="benefit">
            <span class="number">1</span>
            <p>An toàn</p>
        </div>
        <div class="benefit">
            <span class="number">2</span>
            <p>Chất lượng cao</p>
        </div>
        <div class="benefit">
            <span class="number">3</span>
            <p>Sạch sẽ & Vệ sinh</p>
        </div>
        <div class="benefit">
            <span class="number">4</span>
            <p>Thoải mái</p>
        </div>
        <div class="benefit">
            <span class="number">5</span>
            <p>Sức khỏe là trên hết</p>
        </div>
        <img src="image/cho_trangchu.png" alt="Dog Image" class="dog-image">
    </section>

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

    <div id="appointmentChoiceModal" class="modal">
        <div class="modal-content">
            <span class="close-button">&times;</span>
            <h2>Bạn đã có tài khoản chưa?</h2>
            <button id="hasAccountButton">Đã có tài khoản</button>
            <button id="noAccountButton">Chưa có tài khoản</button>
        </div>
    </div>
</main>
<script>
    // JavaScript xử lý modal "Đặt Hẹn" // Hiện pop up
    const appointmentButton = document.getElementById('appointmentButton');
    const appointmentChoiceModal = document.getElementById('appointmentChoiceModal');
    const closeModalButtons = document.querySelectorAll('.close-button');
    const hasAccountButton = document.getElementById('hasAccountButton');
    const noAccountButton = document.getElementById('noAccountButton');

    appointmentButton.addEventListener('click', () => {
        appointmentChoiceModal.style.display = 'block';
    });

    closeModalButtons.forEach(button => {
        button.addEventListener('click', () => {
            appointmentChoiceModal.style.display = 'none';
        });
    });

    hasAccountButton.addEventListener('click', () => {
        window.location.href = 'login.jsp'; // Trang đăng nhập
    });

    noAccountButton.addEventListener('click', () => {
        window.location.href = 'appointmentNoAccount.jsp'; // Trang không có tài khoản
    });

    window.addEventListener('click', (event) => {
        if (event.target === appointmentChoiceModal) {
            appointmentChoiceModal.style.display = 'none';
        }
    });
</script>
</body>
</html>
