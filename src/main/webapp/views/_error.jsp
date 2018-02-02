<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MaxSt
  Date: 02.02.2018
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<head>
    <%--<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">--%>
</head>
<div style="background: lightcoral; text-align: left; padding: 5px; margin-top: 15px; font-size: medium; font-weight: 600">
    <c:out value="${errorMessage}"></c:out>
    <%--<span onclick="this.parentElement.style.display='none'" style="background: #009688; padding: 2px; text-align: center">×</span>--%>
</div>
