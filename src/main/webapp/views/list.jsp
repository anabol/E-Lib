<%@ page import="java.util.List" %>
<%@ page import="ru.AccountLib.hibernate.dao.UserEntity" %>
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

    <body class="w3-light-blue">
    <div class="w3-container w3-blue-gray w3-opacity w3-right-align">
        <h1>E-Lib</h1>
    </div>
    <div class="w3-container w3-center w3-margin-bottom w3-padding">
        <div class="w3-card-4">
            <div class="w3-container w3-light-blue">
                <h2>Users</h2>
            </div>
            <table border="1">
                <tr>
                    <td>Log Password</td>
                    <td>Action</td>
                </tr>
                <c:forEach items="${users}" var="user" varStatus="status">
                    <tr valign="top">
                        <td>${user.log} ${user.password}</td>
                        <td>
                            <button class="w3-btn w3-round-xlarge w3-green" onclick="location.href='${pageContext.servletContext.contextPath}/edit?id=${user.id}'">Edit</button>
                            <button class="w3-btn w3-round-xlarge w3-red" onclick="location.href='${pageContext.servletContext.contextPath}/delete?id=${user.id}'">DELETE</button>
                                <%--<a href="${pageContext.servletContext.contextPath}/edit?id=${user.id}">Edit</a>--%>
                            <%--<a href="${pageContext.servletContext.contextPath}/delete?id=${user.id}">Delete</a>--%>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
        <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
            <button class="w3-btn w3-round-xlarge w3-red" onclick="location.href='/'">Back to main</button>
        </div>
    </body>
</html>
