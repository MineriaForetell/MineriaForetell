function addRow() {

    var mycheck = document.getElementById("mycheck");
//    var age = document.getElementById("age");
    var points = document.getElementById("points");
    var table = document.getElementById("myTableData");

    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);
   
    row.insertCell(0).innerHTML = rowCount.value;
    row.insertCell(1).innerHTML = rowCount.value;
    row.insertCell(2).innerHTML = mycheck.value;
    row.insertCell(3).innerHTML = '<input type="button" class="fa fa-times" onClick="Javacsript:deleteRow(this)">';

}

function deleteRow(obj) {
    var index = obj.parentNode.parentNode.rowIndex;
    var table = document.getElementById("myTableData");
    table.deleteRow(index);

}

function deletePoint(obj) {
    var index = obj.parentNode.parentNode.rowIndex;
    var table = document.getElementById("point_table");
    table.deleteRow(index);

}

function addToPoints() {
    var rows = "";
    var point = document.getElementById("assign-pt").value;
    var location = document.getElementById("location").value;
    rows = "<tr><td>" + point + "</td><td>" + location + "</td><td>" + '<a href="#" onClick="Javacscript:deletePoint(this)"><i class="fa fa-times"></i></a>' + "</td></tr>";
    $(rows).appendTo("#point_table");
}

function addToTasks() {
    var rows = "";
    var task = "";
    var points = "";
    var DRO = "";
    rows = "<tr><td>" + task + "</td><td>" + points + "</td><td>" + DRO + "</td></tr>";
    $(rows).appendTo("#point_table");
}
