function sendLogInRequest() {
    console.log("Send Log in Request");
    $.post("/indexJSP", {
            //testParam: "HelloWorld",
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

            var table = $("<table></table>").addClass("slds-table");
            var headTR = $("<tr></tr>").append("<td>ID</td>").append("<td>Name</td>");
            table.append(headTR);

            records.forEach(function (item) {
                var attr = item.attributes;
                var Name = item.Name;
                var Id = item.Id;
                //console.log("Name=" + Name);
                var tr = $("<tr></tr>").append("<td>" + Id + "</td>").append("<td>" + Name + "</td>");
                table.append(tr);
            });

            $("#tablePlace").append(table);

        }
    );
}

function deleteOldTable() {
    $("#tablePlace").empty();
}