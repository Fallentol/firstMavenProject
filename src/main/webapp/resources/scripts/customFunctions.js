function sendLogInRequest() {
    console.log("Send Log in Request. Deployment test !! ");
    $.post("/indexJSP", {
            action: "logIn"
        }, function (resp) {
            console.log('Resp:' + resp);
        }
    );
}

function sendUserLogInRequest() {
    console.log("Send Log in Request");
    let userName = $("#userName").val();
    let userPassword = $("#userPassword").val();
    let userST = $("#userST").val();
    $.post("/indexJSP", {
            action: "logInWithPassword",
            userName: userName,
            userPassword: userPassword,
            userST: userST,
        }, function (resp) {
            console.log('Resp:' + resp);
        }
    );
}

function sendQueryRequest() {
    let req = $("#req").val();
    req = req.replace(/  /g, '+');
    req = req.replace(/ /g, '+');
    console.info("Send Query Request: " + req);

    $.post("/indexJSP", {
            query: req,
            action: "queryRequest"
        }, function (resp) {
            $("#answer").val(resp);
            let obj = JSON.parse(resp);
            let records = obj.records;
            let keys = Object.keys(records[0]);
            keys.shift();
            console.log("keys=" + keys);

            let table = $("<table></table>").addClass("slds-table slds-table_bordered slds-table_cell-buffer");
            let headTR = $("<tr></tr>");
            headTR.append("<td>#</td>").addClass("tableHeader");
            keys.forEach(function (key) {
                let t = $("<td>" + (key + 1) + "</td>").addClass("tableHeader");
                headTR.append(t);
            });
            table.append(headTR);

            records.forEach(function (item, index) {

                let tr = $("<tr></tr>");
                tr.append("<td>" + index + "</td>");
                keys.forEach(function (key) {
                    tr.append("<td>" + item[key] + "</td>");
                });

                table.append(tr);
            });

            $("#tablePlace").append(table);
        }
    );
}

function sendAnonymousRequest() {
    let req = $("#req").val();
    req = req.replace(/  /g, '+');
    req = req.replace(/ /g, '+');
    console.info("Send Query Request: " + req);

    $.post("/indexJSP", {
            query: req,
            action: "queryAnonymous"
        }, function (resp) {
            $("#answer").val(resp);
            let obj = JSON.parse(resp);
            let records = obj.records;
            let keys = Object.keys(records[0]);
            keys.shift();
            console.log("keys=" + keys);

            let table = $("<table></table>").addClass("slds-table slds-table_bordered slds-table_cell-buffer");
            let headTR = $("<tr></tr>");
            keys.forEach(function (key) {
                let t = $("<td>" + key + "</td>").addClass("tableHeader");
                headTR.append(t);
            });
            table.append(headTR);

            records.forEach(function (item) {
                let tr = $("<tr></tr>");
                keys.forEach(function (key) {
                    tr.append("<td>" + item[key] + "</td>");
                });

                table.append(tr);
            });

            $("#tablePlace").append(table);

        }
    );
}

function runTest() {
    console.log("Run test");
    $.post("/indexJSP", {
            action: "runTest"
        }, function (resp) {
            console.log("resp=" + resp);
        }
    );
}

function deleteOldTable() {
    $("#tablePlace").empty();
}