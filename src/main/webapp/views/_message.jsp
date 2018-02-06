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
        <style>
            span.knopka {
                color: #fff;
                background: limegreen;
                padding: 1px;
                border-radius: 5px;
                border: 2px solid #FF8247;
            }
            span.knopka:hover {
                background: #FF6347;
            }
        </style>
        <style>
            div.knopka {
                color: #fff;
                background: aquamarine;
                padding: 5px;
                border-radius: 5px;
                border: 2px solid #FF8247;
            }
            div.knopka:hover {
                background: #ffc107;
            }
        </style>
</head>
<div style="text-align: center; color: limegreen; font-weight: bold" class="notification-bar; knopka">
    <c:out value="${message}"></c:out>
    <span  class="knopka" onclick="this.parentElement.style.display='none'">×</span>
</div>
