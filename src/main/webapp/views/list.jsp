
<%@ page import="java.util.List" %>
<%@ page import="ru.AccountLib.dao.UserEntity" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: MaxSt
  Date: 28.12.2017
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>Add new user</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>

    <body class="w3-light-grey">
    <div class="w3-container w3-blue-gray w3-opacity w3-right-align">
        <h1 style="font-weight: 600">E-Lib</h1>
    </div>

    <div class="w3-container w3-center w3-margin-bottom w3-padding">
        <div class="w3-card-4">
            <div class="w3-container w3-light-blue">
                <h2 style="font-weight: 500; color: white;">Users</h2>
            </div>
            <table class="w3-table w3-container">
                <tr class="w3-round-xlarge w3-green">
                    <td style="font-weight: 700" class="w3-center">LOG</td>
                    <td style="font-weight: 700" class="w3-center">PASSWORD</td>
                    <td style="font-weight: 700" class="w3-center">ACTION</td>
                </tr>
                <c:forEach items="${users}" var="user" varStatus="status">
                    <tr valign="top" class="w3-hover-sand">
                        <td class="w3-center">${user.log}</td>
                        <td class="w3-center">${user.password}</td>
                        <td class="w3-center">
                            <button class="w3-btn w3-round-xlarge w3-green w3-opacity" onclick="location.href='${pageContext.servletContext.contextPath}/edit?id=${user.id}'">Edit</button>
                            <button class="w3-btn w3-round-xlarge w3-red w3-opacity" onclick="location.href='${pageContext.servletContext.contextPath}/delete?id=${user.id}'">DELETE</button>
                                <%--<a href="${pageContext.servletContext.contextPath}/edit?id=${user.id}">Edit</a>--%>
                                <%--<a href="${pageContext.servletContext.contextPath}/delete?id=${user.id}">Delete</a>--%>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
            <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
            <button class="w3-btn w3-round-xlarge w3-red" onclick="location.href='/logout'">Logout</button>
        </div>
    </body>
</html>
