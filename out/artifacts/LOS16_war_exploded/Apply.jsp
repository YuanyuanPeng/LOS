<%--
  Created by IntelliJ IDEA.
  User: Phyllis Peng
  Date: 5/23/2016
  Time: 9:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Apply New Load </title>
    <script src="script.js"></script>
</head>
<body>
    <h1> Apply New Load </h1>
    <c:choose>
        <c:when test="${user !=null}">
            <p>
                <a href="${logoutUrl}">sign out</a>
            </p>

        </c:when>
        <c:otherwise>
            <p>
                <a href="${loginUrl}">sign In</a>
            </p>
        </c:otherwise>

    </c:choose>

    <h4>Personal Info</h4>

    <div>
         Name <input type="text" name="name" id="name">
    </div>

    <div>
<c:choose>
    <c:when test="${user !=null}">
        <p>
            Email, ${user.email}
        </p>

    </c:when>

</c:choose>
    </div>
    <div>
        Address <input type="text" name="addr" id="addr">
    </div>
    <div>
        Salary <input type="number" name="salary" id="salary">
    </div>


    <div>
        <h4>Enter the Amount</h4>
    Amount <input type="number" name="amount" id="amount">
    </div>
    <div>
    <h4>Terms</h4>

    Term <input type="text" name="term" id="terms" >

    </div>


    <div>
        <input type="submit", value="Submit" onclick="submitmsg()">
    </div>

    <div>
        <h4>History</h4>
        <div id="history"></div>
    </div>



</body>
</html>
