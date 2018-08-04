<%@ page import="ru.strava.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>CLOUD BUDGET</title>
    <link href="../resources/styles/mainPageStyle.css" rel="stylesheet" type="text/css">


</head>
<body style="background-image: url(../resources/images/clouds.jpg); background-size: cover;">
<div class="centralDiv">
    <h1>CLOUD BUDGET NAVIGATION</h1> <br/>
    <%! String str = Constants.anyVal;
        String test = "My test";
    %>
    Test 555 777
    <c:out value="${str}" default="default 12"/>
    <c:out value="${message}" default="default 2"/>
</div>

</body>

</html>
