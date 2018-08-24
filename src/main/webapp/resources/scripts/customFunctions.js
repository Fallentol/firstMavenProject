function sendLogInRequest() {
    console.log("Send Log in Request");
    $.post("/indexJSP", {
            action: "logIn"
        }, function (resp) {
            console.log('Resp:' + resp);
        }
    );
}

function sendQueryRequest() {
    var req = $("#req").val();
    req = req.replace(/  /g, '+');
    req = req.replace(/ /g, '+');
    console.info("Send Query Request: " + req);

    $.post("/indexJSP", {
            query: req,
            action: "queryRequest"
        }, function (resp) {
            $("#answer").val(resp);
            var obj = JSON.parse(resp);
            var records = obj.records;
            var keys = Object.keys(records[0]);
            keys.shift();
            console.log("keys=" + keys);

            var table = $("<table></table>").addClass("slds-table slds-table_bordered slds-table_cell-buffer");
            var headTR = $("<tr></tr>");
            keys.forEach(function (key) {
                var t = $("<td>"+key+"</td>").addClass("tableHeader");
                headTR.append(t);
            });
            table.append(headTR);

            records.forEach(function (item) {

                var tr = $("<tr></tr>");
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
    var req = $("#req").val();
    req = req.replace(/  /g, '+');
    req = req.replace(/ /g, '+');
    console.info("Send Query Request: " + req);

    $.post("/indexJSP", {
            query: req,
            action: "queryAnonymous"
        }, function (resp) {
            $("#answer").val(resp);
            var obj = JSON.parse(resp);
            var records = obj.records;
            var keys = Object.keys(records[0]);
            keys.shift();
            console.log("keys=" + keys);

            var table = $("<table></table>").addClass("slds-table slds-table_bordered slds-table_cell-buffer");
            var headTR = $("<tr></tr>");
            keys.forEach(function (key) {
                var t = $("<td>"+key+"</td>").addClass("tableHeader");
                headTR.append(t);
            });
            table.append(headTR);

            records.forEach(function (item) {
                var tr = $("<tr></tr>");
                keys.forEach(function (key) {
                    tr.append("<td>" + item[key] + "</td>");
                });

                table.append(tr);
            });

            $("#tablePlace").append(table);

        }
    );
}

function deleteOldTable() {
    $("#tablePlace").empty();
}