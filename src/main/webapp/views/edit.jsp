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
    <table>
        <tr>
            <td>Login:</td>
            <td><input type="text" name="log" value="${user.log}"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="text" name="password" value="${user.password}"><br /></td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td>
                <input type="radio" checked name="gender" value ="M"> Male
                <input type="radio" name="gender" value="F"> Female
            </td>
        </tr>
        <tr>
            <td>Role:</td>
            <td>
                <input type="radio" name="role" value ="ADMIN"> ADMIN
                <input type="radio" checked name="role" value="USER"> USER
            </td>
        </tr>
        <tr>
            <td><button type="submit">Submit</button></td>
            <td><button onclick="location.href='/adminEdit'">Back</button></td>
        </tr>
    </table>
</form>
</html>
