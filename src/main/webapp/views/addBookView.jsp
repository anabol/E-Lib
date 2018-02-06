<%--
  Created by IntelliJ IDEA.
  User: MaxSt
  Date: 06.02.2018
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddBook</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>
<form method="post">
    <p>Book Name:
    <input type="text" name="bookName"></p>
    <p>Book Author:
    <input type="text" name="bookAuth"></p>
    <p><b>Field for entering text:</b></p>
    <textarea name="book" cols="50" rows="15"></textarea>
    <p>
        <button type="submit">SUBMIT</button>
    </p>
</form>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
