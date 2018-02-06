<%--
  Created by IntelliJ IDEA.
  User: MaxSt
  Date: 06.02.2018
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditBook</title>
</head>
<body>
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
    <form method="post">
        <p><b>Еhe window to edit the text:</b></p>
        <textarea name="book" cols="60" rows="17">${book.bookText}</textarea>
        <%--<p><input type="submit" value="Submit changes"></p>--%>
        <p>
            <button type="submit" name="bookId" value="${book.bookId}">SUBMIT</button>
        </p>
    </form>
    <jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
