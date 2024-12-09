<%--
  Created by IntelliJ IDEA.
  User: FPT SHOP
  Date: 12/9/2024
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page session="true" %>
<%
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<html>
<head>
    <title>Hồ sơ cá nhân</title>
</head>
<body>
<h1>Thông tin cá nhân</h1>
<p>Tên người dùng: <%= username %></p>
<a href="index.jsp">Quay lại Trang chủ</a>
</body>
</html>
