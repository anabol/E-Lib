<%--
  Created by IntelliJ IDEA.
  User: MaxSt
  Date: 02.02.2018
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<jsp:include page="_header.jsp"></jsp:include>
<body>
<form method="post">
    <table>
        <tr>
            <td>Login:</td>
            <td><input type="text" name="log" value=""></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="text" name="password" value=""><br /></td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td>
                <input type="radio" name="gender" value ="M"> Male
                <input type="radio" name="gender" value="F"> Female
            </td>
        </tr>
        <tr>
            <td><button type="submit">Submit</button></td>
            <td><button onclick="location.href='/login'">Back</button></td>
        </tr>
    </table>
</form>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
