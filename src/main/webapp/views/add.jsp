<%--
  Created by IntelliJ IDEA.
  User: MaxSt
  Date: 28.12.2017
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Login page</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>

    <body class="w3-light-blue">
        <div class="w3-container w3-blue-gray w3-opacity w3-right-align">
            <h1>E-Lib</h1>
        </div>

        <div class="w3-container w3-padding">
            <%--<%--%>
                <%--if (request.getAttribute("log") != null) {--%>
                    <%--out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +--%>
                            <%--"   <span onclick=\"this.parentElement.style.display='none'\"\n" +--%>
                            <%--"   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +--%>
                            <%--"   <h5>User '" + request.getAttribute("log") + "' added!</h5>\n" +--%>
                            <%--"</div>");--%>
                <%--}--%>
            <%--%>--%>
                <%--<c:set value="${re}"--%>
            <c:if test="${log != null}">
                <div class="w3-panel w3-green w3-display-container w3-card-4 w3-round">
                   <span onclick="this.parentElement.style.display='none'" class="w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>
                   <h5>User ${log} added!</h5>
                </div>
            </c:if>
            <div class="w3-card-4">
               <div class="w3-container w3-center w3-green">
                   <h2>Add user</h2>
               </div>
               <form method="post" class="w3-section w3-light-grey w3-padding">
                   <label style="color: #f44336; font-style: italic;">Login:
                       <input type="text" name="log" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                   </label>

                   <label>Password:
                       <input type="password" name="password" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                   </label>
                   <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
               </form>
           </div>
        </div>

        <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
            <button class="w3-btn w3-round-xlarge w3-red" onclick="location.href='/'">Back to main</button>
        </div>
    </body>
</html>
