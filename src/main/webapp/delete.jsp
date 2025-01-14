<%--
  Created by IntelliJ IDEA.
  User: FPT SHOP
  Date: 1/14/2025
  Time: 11:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="controller.JDBIConnector" %>
<%@ page import="java.io.IOException" %>

<%
    String username = request.getParameter("username");
    if (username != null && !username.isEmpty()) {
        // Gọi phương thức xóa người dùng từ cơ sở dữ liệu
        JDBIConnector.deleteUser(username);
        // Chuyển hướng lại về trang adminDashboard.jsp sau khi xóa
        response.sendRedirect("adminDashboard.jsp");
    } else {
        // Nếu không có username, quay lại trang adminDashboard.jsp
        response.sendRedirect("adminDashboard.jsp");
    }
%>
