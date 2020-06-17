$(function() {
    "use strict";
    const url = "http://localhost:8080/newProject_war";
    let indexOfEditedItem;
    let listOfEmployee = [];
    $("#check").hide();
    $("#form").submit(function(event){
        event.preventDefault();
        let firstname = $("#fname").val();
        let lastname = $("#lname").val();
        let salary = $("#salary").val();
        let employeeType = $("#employeeType").val();
        const employee = {
            "employeeId": -1,
            "firstname" : firstname,
            "lastname" : lastname,
            "salary" : salary,
            "employeeType": employeeType
        }
        fetch(url + "/add-employee", {
            method: "post",
            body: JSON.stringify(employee),
            headers: {
                "Content-Type": "application/json"
            }
        }).then(response => {
            if (response.ok) {
                return response.json();
            } else {
                return Promise.reject({ status: response.status, statusText: status.statusText})
            }
        }).then(employeeItems => {
            prepareTable(employeeItems);
        }).catch(err => {
            console.log(err.statusText);
        })
        $("#check").hide();
        clearForm();

//


        $("#check").hide();
        $("#fname").val("");
        $("#lname").val("");
        $("#salary").val("");
        $("#employeetype").val("");
        //list.push(data);
        //refreshPage();
    })
////

    loadTable();
    function loadTable() {
        fetch(url + "/employee?type=all")
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    return Promise.reject({ status: response.status, statusText: status.statusText})
                }
            }).then(employeeItems => {
            prepareTable(employeeItems);
        }).catch(err => {
            console.log(err.statusText);
        })
    }
    function prepareTable(employeeItems) {
        let tableBody = "";
        for (let item of employeeItems) {

            tableBody += `<tr><td>${item.firstname}</td><td>${item.lastname}</td><td>${item.salary}</td><td>${item.employeeType}</td><td>
                                <button id="${item.employeeId}delete" class="delete">delete</button>
                                 <button id="${item.employeeId}edite" class="edite">edite</button></td></tr>`
        }
        $("#employee_list").html(tableBody);
        attachHandlers();
    }

//})
function attachHandlers(){
    $(".delete").on("click", function(evt){
        let button = evt.target;
        let index = parseInt($(button).attr("id"));
        fetch(`${url}/employee/delete/${index}`, {
            method: "delete"
        }).then(response => {
            if (response.ok) {
                loadTable();
                return Promise.resolve();
            } else {
                return Promise.reject({ status: response.status, statusText: status.statusText})
            }
        }).catch(err => {
            console.log(err.statusText);
        })
    })
    $(".edite").on("click", function(evt){
        let button = evt.target;
        let index = parseInt($(button).attr("id"));
        $("#save_employee_button").hide();
        $(".update").show();
        indexOfEditedItem = index;

        let employee = listOfEmployee[index];
        $("#fname").val(employee.firstname);
        $("#lname").val(employee.lastname);
        $("#salary").val(employee.salary);
        $("#employeeType").val(employee.employeeType);
    })
}

    $("#update_button").on("click", function(event) {
        event.preventDefault();
        let firstname = $("#fnmae").val();
        let lastname = $("#lname").val();
        let salary = $("#salary").val();
        let employeeType = $("#employeeType").val();
        const food = {
            "employeeId": indexOfEditedItem,
            "firstname" : firstname,
            "lastname" : lastname,
            "salary" : salary,
            "employeeType": employeeType
        }
        fetch(url + "/add-food", {
            method: "put",
            body: JSON.stringify(employee),
            headers: {
                "Content-Type": "application/json"
            }
        }).then(response => {
            if (response.ok) {
                return response.json();
            } else {
                return Promise.reject({ status: response.status, statusText: status.statusText})
            }
        }).then(employeeItems => {
            $("#save_employee_button").show();
            $(".update").hide();
            prepareTable(employeeItems);
        }).catch(err => {
            console.log(err.statusText);
        })

        $("#check").hide();
        clearForm();
    })
    $("#cancel_update_button").on("click", function(event) {
        event.preventDefault();
        $("#save_employee_button").show();
        $(".update").hide();
        clearForm();
    })

    function clearForm() {
        $("#fname").val("");
        $("#lname").val("");
        $("#salary").val("");
        $("#employeeType").val("");
    }
})