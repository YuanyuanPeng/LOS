<%--
  Created by IntelliJ IDEA.
  User: Phyllis Peng
  Date: 5/23/2016
  Time: 9:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>LOS</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>

    <script src="script.js"></script>

    <link type="text/css" rel="stylesheet" href="main.css"/>


    <!--<script>
      $(document).ready(function(){
        $("#options").hide();

        $("#applicant").click(function(){
          $("#loan").hide();
          $("#options").show();



        });
        $("#underwrite").click(function(){
          $("#options").show();

        });
      });
    </script>-->
  </head>
  <body>

  <h1>
   LOS
  </h1>

  <div>
    <c:choose>
      <c:when test="${user !=null}">
        <p>
          Welcome, ${user.email}!

          You can <a href="${logoutUrl}">sign out</a>.
        </p>

        <button id="applicant">Applicant</button> Or <button id="underwrite"> UnderWriter </button>
<div id="options">
        <p id="apply">
          Applying for new Load,
          <a href="Apply.jsp"  >Click Here</a>.


        </p>
        <p id="loan">
        <div>  To view all loans,
          <a href="Loan.jsp">Click Here</a> :).</div>
        </p>
</div>
      </c:when>
      <c:otherwise>
        <p>
          Welcome!
          <a href="${loginUrl}">Sign in or register</a> to customize.
        </p>
      </c:otherwise>
    </c:choose>

  </div>
  </body>
</html>
