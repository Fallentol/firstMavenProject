    <%@ page import="ru.strava.Constants" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
        <title>CLOUD BUDGET</title>
        <link href="../resources/styles/mainPageStyle.css" rel="stylesheet" type="text/css">
        <link href="../resources/styles/salesforce-lightning-design-system.css" rel="stylesheet" type="text/css">
        <link href="../resources/styles/w3.css" rel="stylesheet" type="text/css">
        </head>

        <body style="background-image: url(../resources/images/clouds.jpg); background-size: cover;">
        <div class="centralDiv">
        <div style="margin: auto !important; width: 50%;" class="slds-text-title_caps slds-text-align_center">CLOUD BUDGET NAVIGATION</div> <br/>

        Test net
        <c:if test="${userName != null}">
            <p><c:out value = "Hello ${userName}"/><p>
            <p><c:out value = " ${warningMessage}"/><p>
        </c:if>
        <c:out value="${message}" default="default 2"/>
        Counter : <c:out value="${counter}" default="default 2"/>
        <li><a href="/reportservlet">Report page</a></li>

        <form method="post">
        <label>Name:
        <input type="text" name="name" class="slds-input inputBar"><br />
        </label>

        <label>Password:
        <input type="password" name="pass" class="slds-input inputBar"><br />
        </label>
        <button type="submit" class="slds-button slds-button--neutral">Submit</button>
        </form>

        </div>

        </body>
        
        <script>
        
        </script>

        </html>
