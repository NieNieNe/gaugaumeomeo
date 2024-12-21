<%--
  Created by IntelliJ IDEA.
  User: VICTUS
  Date: 12/13/2024
  Time: 10:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VIPet Membership</title>
    <link rel="stylesheet" href="css/VIPet.css">
</head>
<body>
<header>
    <nav class="navbar">
        <div class="logo">
            <img src="image/logo_trangchu.png" alt="Animal Doctors">
        </div>
        <ul class="nav-links">
            <li><a href="#">Về Chúng Tôi</a></li>
            <li><a href="#">Các Dịch Vụ</a></li>
            <li><a href="#">Cộng Đồng</a></li>
            <li><a href="branches.html">Các Chi Nhánh</a></li>
            <li><a href="VIPet.jsp">VIPet</a></li>
        </ul>
        <button id="appointmentButton" class="appointment-button">Đặt Hẹn</button>

    </nav>
</header>

<main>
    <section class="vipet-intro">
        <div class="intro-image">
            <img src="image/Vipet_img.png" alt="VIPet Membership">
        </div>
        <div class="intro-text">
            <h1>Thành viên VIPet</h1>
            <p>
                “Cha mẹ nào cũng muốn mang đến cho đứa con thân yêu của mình thật nhiều sức khỏe và hạnh
                Khi bạn đăng ký làm thành viên VIPet, Animal Doctors International sẽ dành cho thú cưng của bạn nhiều ưu đãi đặc biệt.
                Trở thành thành viên VIPet sẽ giúp thú cưng của bạn được chăm sóc điều trị, phòng ngừa bệnh tật suốt cả năm.
            </p>
            <p>
                Là thành viên VIPet, thú cưng của bạn sẽ được tư vấn miễn phí.
                Thú cưng sẽ nhận được những lời khuyên từ các bác sĩ thú y có kiến thức và có tâm bất cứ lúc nào
                mà không phải trả thêm phí và không giới hạn.
            </p>
            <p>
                Các thành viên VIPet và thú cưng của họ có cả một nhóm chăm sóc sức khỏe bên cạnh họ suốt cả năm.
                Nhưng dịch vụ VIPet thậm chí còn nhiều hơn thế. Bạn không chỉ tiết kiệm khi tham khảo ý kiến;
                bạn cũng tiết kiệm cho các dịch vụ chăm sóc thú cưng.
                Hãy để thú cưng của bạn trải nghiệm những điều tốt nhất cho sức khỏe của chúng với gói thành viên VIPet.”
            </p>
        </div>
    </section>

    <section class="vipet-benefits">
        <h2>Quyền lợi thành viên</h2>
        <div class="benefits-list">
            <div class="benefit">
                <h3>Hướng dẫn và hỗ trợ từ các chuyên gia</h3>
                <p>Thú cưng được chăm sóc tận tình và chuyên nghiệp.</p>
            </div>
            <div class="benefit">
                <h3>Gắn kết hơn</h3>
                <p>Tăng sự gắn bó giữa bạn và thú cưng.</p>
            </div>
            <div class="benefit">
                <h3>Tiết kiệm hơn</h3>
                <p>Được ưu đãi khi sử dụng dịch vụ.</p>
            </div>
            <div class="benefit">
                <h3>Grooming miễn phí</h3>
                <p>Dịch vụ tắm và làm đẹp miễn phí định kỳ.</p>
            </div>
        </div>
    </section>

    <section class="vipet-form">
        <h2>Join our pet-loving family</h2>
        <form action="<%= request.getContextPath() %>/VipetServlet" method="post">
            <label for="name">Your name*</label>
            <input type="text" id="name" name="name" required>

            <label for="email">Your email*</label>
            <input type="email" id="email" name="email" required>

            <label for="number">Your number*</label>
            <input type="text" id="number" name="number" required>

            <label for="remarks">Remarks</label>
            <textarea id="remarks" name="remarks"></textarea>

            <button type="submit" class="btn-submit">Submit</button>
        </form>
    </section>
</main>

<footer class="footer">
    <p>&copy; 2024 Animal Doctors International. All Rights Reserved.</p>
</footer>
</body>
</html>

