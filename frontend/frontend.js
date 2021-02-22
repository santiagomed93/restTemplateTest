$(document).ready(function() {
    var urlBase = "http://localhost:8080/employees/";
    $("#formGetEmployee").submit(function (e) {
        e.preventDefault();
        $("tbody").empty();
        var employeeId = $("#employeeId").val();
        if(employeeId){
            $.get( urlBase+employeeId, function( data ) {
                $("tbody")
                    .append("<tr>" +
                    "<th scope='row'>"+data.id+"</th>" +
                    "<td>"+data.name+"</td>" +
                    "<td>"+data.contractTypeName+"</td>" +
                    "<td>"+data.roleId+"</td>" +
                    "<td>"+data.roleName+"</td>" +
                    "<td>"+data.roleDescription+"</td>" +
                    "<td>"+data.hourlySalary+"</td>" +
                    "<td>"+data.monthlySalary+"</td>" +
                    "<td>"+data.annualSalary+"</td>"
                    );
            });
        }else{
            $.get( urlBase, function( data ) {
                var rowTable = "";
                for(var i = 0; i < data.length; i++){
                    rowTable += "<tr>" +
                    "<th scope='row'>"+data[i].id+"</th>" +
                    "<td>"+data[i].name+"</td>" +
                    "<td>"+data[i].contractTypeName+"</td>" +
                    "<td>"+data[i].roleId+"</td>" +
                    "<td>"+data[i].roleName+"</td>" +
                    "<td>"+data[i].roleDescription+"</td>" +
                    "<td>"+data[i].hourlySalary+"</td>" +
                    "<td>"+data[i].monthlySalary+"</td>" +
                    "<td>"+data[i].annualSalary+"</td>"
                }
                $("tbody").append(rowTable);
            });
        }
        return true;

    });
});