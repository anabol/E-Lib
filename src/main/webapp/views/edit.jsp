<%--
  Created by IntelliJ IDEA.
  User: MaxSt
  Date: 09.01.2018
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
EDIT
</body>
<form method="post">
    <label>Login:
        <input type="text" name="log" value="${user.log}"><br />
    </label>

    <label>Password:
        <input type="text" name="password" value="${user.password}"><br />
    </label>
    <button type="submit">Submit</button>
    <button onclick="location.href='/'">Back</button>
</form>
</html>
