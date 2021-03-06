<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <jsp:useBean id="date" class="java.util.Date" />
    <jsp:useBean id="test" class="auxiliary.BeanSimple" />
<html>


    <head>
        <title>CloudBudget2.0</title>
        <link href="../../resources/styles/mainPageStyle.css" rel="stylesheet" type="text/css">
        <link href="../../resources/styles/salesforce-lightning-design-system.css" rel="stylesheet" type="text/css">
        <link href="../../resources/styles/w3.css" rel="stylesheet" type="text/css">
        <link href="../../resources/styles/mainPageStyle.css" rel="stylesheet" type="text/css">
        <link href="../../resources/styles/w3.css" rel="stylesheet" type="text/css">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <script src="../../resources/scripts/customFunctions.js"></script>
    </head>

    <body style="background-image: url(../../resources/images/clouds.jpg); background-size: cover;">
        <div class="w3-container w3-blue-grey w3-opacity w3-left-align">
            <h1>CLOUD BUDGET NAVIGATION</h1>
            <c:out value="${date}"/>
            <c:out value="${test.name}"/>
        </div>
        <div class="centralDiv">

            <article class="slds-card">
                <div class="slds-card__header slds-grid">
                    <header class="slds-media slds-media_center slds-has-flexi-truncate">
                        <div class="slds-media__figure">
                            <span class="slds-icon_container slds-icon-standard-account" title="account">
                                <span class="slds-assistive-text">Console Log</span>
                            </span>
                        </div>
                        <div class="slds-media__body">
                            <div style="display: inline-block; width: 36px; height: 36px;
                                    background-image:url(../../resources/images/icon.jpg);">
                            </div>
                            <div style="display: inline-block">
                                <h2 class="slds-card__header-title">
                                    <a class="slds-card__header-link slds-truncate">
                                        <span class="slds-text-heading_small">Welcome Page 2.2</span>
                                    </a>
                                </h2>
                            </div>
                        </div>
                        <div class="slds-no-flex">
                            <input type="button" onclick="sendLogInRequest();"
                                   class="slds-button slds-button--neutral" value="Login 82th"/>
                            <input type="button" onclick="sendUserLogInRequest();"
                                   class="slds-button slds-button--neutral" value="Login to a custom org"/>
                            <input type="button" onclick="runTest();"
                                   class="slds-button slds-button--neutral" value="RunTest"/>
                            <input type="button" onclick="deleteOldTable(); sendQueryRequest(); "
                                   class="slds-button slds-button--neutral" value="Submit request"/>
                            <input type="button" onclick="deleteOldTable(); sendAnonymousRequest(); "
                                   class="slds-button slds-button--neutral" value="Submit Anonymous"/>
                        </div>
                    </header>
                </div>
                <div class="slds-card__body slds-card__body_inner" style="padding-left: 15px;">
                <div style="width: 500px;">
                    <div class="slds-form-element">
                        <label class="slds-form-element__label" >Username</label>
                        <div class="slds-form-element__control">
                            <input type="text" id="userName" class="slds-input" />
                        </div>
                            <label class="slds-form-element__label" >Password</label>
                            <div class="slds-form-element__control">
                                <input type="text" id="userPassword" class="slds-input"  />
                            </div>
                        <label class="slds-form-element__label" >ST</label>
                        <div class="slds-form-element__control">
                            <input type="text" id="userST" class="slds-input" />
                        </div>
                    </div>

                </div>

                    Query<br/>
                    (SELECT Id, Name, cb3__Q1__c FROM cb3__Line__c WHERE cb3__Entry__c != null)<br/>
                    (SELECT Name, Id,cb3__Entry__r.Id, cb3__Entry__r.Name, cb3__Q1__c, cb3__Q2__c, cb3__Q3__c  FROM cb3__Line__c LIMIT 2000)<br/>
                    <input type="text" id="req" class="slds-input"/>

                    Answer

                    <input type="text" id="answer" class="slds-input" style="font-size: smaller;" />

                    <div id="tablePlace"></div>
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

</html>
