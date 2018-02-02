<%--
  Created by IntelliJ IDEA.
  User: MaxSt
  Date: 02.02.2018
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="background: #87CEEB; height: 55px; padding: 5px;">
    <div style="float: left">
        <h1>E-LIB</h1>
    </div>

    <div style="float: right; padding: 10px; text-align: right;">

        <!-- User store in session with attribute: loginedUser -->
        Hello <b>${loginedUser.log}</b>
        <br/>
        Search <input name="search">

    </div>

</div>
