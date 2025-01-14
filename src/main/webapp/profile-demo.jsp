<%--
  Created by IntelliJ IDEA.
  User: VICTUS
  Date: 1/13/2025
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Hồ sơ cá nhân - PetCare</title>
  <link rel="stylesheet" href="css/profiledemo.css?v=1.0">
</head>
<body>
<div class="profile-container">
  <h1>Hồ sơ cá nhân</h1>

  <!-- Hiển thị lỗi nếu có -->
  <c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
  </c:if>

  <!-- Hiển thị thông tin người dùng nếu có -->
  <c:if test="${not empty user}">
    <div class="profile-details">

      <!-- Ảnh đại diện -->
      <div class="avatar-container">
        <form action="uploadAvatar" method="post" enctype="multipart/form-data">
          <label for="avatar">
            <img src="${user.avatarUrl}" alt="Ảnh đại diện" class="avatar-image">
          </label>
          <input type="file" id="avatar" name="avatar" accept="image/*" style="display: none;">
          <button type="submit" class="upload-btn">Tải lên ảnh đại diện</button>
        </form>
      </div>

      <!-- Thông tin cá nhân -->
      <div class="profile-info">
        <h2>Thông tin cá nhân</h2>
        <p><strong>Tên người dùng:</strong> ${user.fullname}</p>
        <p><strong>Số điện thoại:</strong> ${user.phonenumber}</p>
        <p><strong>Ngày sinh:</strong> ${user.dateofBirth}</p>
        <p><strong>Số lượng thú cưng:</strong> ${user.petsCount}</p>
      </div>

      <!-- Danh sách các cuộc hẹn gần đây -->
      <div class="appointments">
        <h2>Cuộc hẹn gần đây</h2>
        <c:if test="${not empty appointments}">
          <ul>
            <c:forEach var="appointment" items="${appointments}">
              <li>
                <p><strong>Ngày:</strong> ${appointment.date}</p>
                <p><strong>Thời gian:</strong> ${appointment.time}</p>
                <p><strong>Ghi chú:</strong> ${appointment.note}</p>
              </li>
            </c:forEach>
          </ul>
        </c:if>
        <c:if test="${empty appointments}">
          <p>Chưa có cuộc hẹn nào.</p>
        </c:if>
      </div>
    </div>

    <!-- Nút đăng xuất -->
    <div class="logout-container">
      <a href="logout" class="logout-btn">Đăng xuất</a>
    </div>
  </c:if>
</div>
</body>
</html>