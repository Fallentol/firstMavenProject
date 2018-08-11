    <%@ page import="ru.strava.Constants" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
        <title>CLOUD BUDGET</title>
        <link href="../resources/styles/mainPageStyle.css" rel="stylesheet" type="text/css">
        <link href="../resources/styles/salesforce-lightning-design-system.css" rel="stylesheet" type="text/css">
        <link href="../resources/styles/w3.css" rel="stylesheet" type="text/css">
        <link href="../resources/styles/mainPageStyle.css" rel="stylesheet" type="text/css">
        <link href="../resources/styles/w3.css" rel="stylesheet" type="text/css">
        </head>

        <body style="background-image: url(../resources/images/clouds.jpg); background-size: cover;">
        <div class="w3-container w3-blue-grey w3-opacity w3-left-align">
        <h1>CLOUD BUDGET NAVIGATION</h1>
        </div>
        <div class="centralDiv">

        <article class="slds-card" >
        <div class="slds-card__header slds-grid">
        <header class="slds-media slds-media_center slds-has-flexi-truncate">
        <div class="slds-media__figure">
        <span class="slds-icon_container slds-icon-standard-account" title="account">
        <span class="slds-assistive-text">Reports</span>
        </span>
        </div>
        <div class="slds-media__body">
        <div style="display: inline-block">
        <img src="../resources/images/icon.png" alt="icon" style="width:auto;">
        </div>
        <div style="display: inline-block">
        <h2 class="slds-card__header-title">
        <a href="javascript:void(0);" class="slds-card__header-link slds-truncate" title="Accounts">
        <span class="slds-text-heading_small">Reports</span>
        </a>
        </h2>
        </div>
        </div>
        <div class="slds-no-flex">
        <button class="slds-button slds-button--neutral">Edit</button>
        </div>
        </header>
        </div>
        <div class="slds-card__body slds-card__body_inner" style="padding-left: 15px;">
        <a class="txtlink" href="/reportservlet">Report page</a>
        </div>
        <footer class="slds-card__footer" style=" margin: auto; text-align: center;">
        <a class="txtlink" href="javascript:void(0);">View All
        <span class="slds-assistive-text">Reports</span>
        </a>
        </footer>
        </article>


        </div>

        </body>

        <script>

        </script>

        </html>
