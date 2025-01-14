<%--
  Created by IntelliJ IDEA.
  User: FPT SHOP
  Date: 1/14/2025
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="controller.User" %>
<%@ page import="controller.JDBIConnector" %>
<%@ page import="java.net.URLEncoder" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="css/admin.css">
</head>
<body>
<h1>Admin Dashboard</h1>
<table>
    <thead>
    <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<User> users = JDBIConnector.getAllUsers();
        for (User user : users) {
    %>
    <tr>
        <td><%= user.getUsername() %></td>
        <td><%= user.getPassword() %></td>
        <td>
            <!-- Nút xóa tài khoản -->
            <form action="delete.jsp" method="post" onsubmit="return confirm('Bạn có chắc chắn muốn xóa tài khoản này?');">
                <input type="hidden" name="username" value="<%= user.getUsername() %>">
                <button type="submit">Xóa</button>
            </form>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
