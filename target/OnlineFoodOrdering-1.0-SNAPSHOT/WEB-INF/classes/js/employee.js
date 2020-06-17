$(function() {
    "use strict";
    const url = "http://localhost:8080/newProject_war";
    let indexOfEditedItem;
    let listOfEmployee = [];
    $("#check").hide();
    $("#form").submit(function(event){
        event.preventDefault();
        let firstname = $("#name1").val();
        let lastname = $("#des1").val();
        let salary = $("#price1").val();
        let employeeType = $("#mealType").val();
        const employee = {
            "foodId": -1,
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
//


        $("#check").hide();
        $("#name1").val("");
        $("#des1").val("");
        $("#price1").val("");
        $("#mealType").val("");
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
        $("#food_list").html(tableBody);
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

        let foodItem = listOfEmployee[index];
        $("#food_item_name").val(foodItem.name);
        $("#food_item_description").val(foodItem.description);
        $("#food_item_price").val(foodItem.price);
        $("#food_item_type").val(foodItem.mealType);
    })
}

    $("#update_button").on("click", function(event) {
        event.preventDefault();
        let name = $("#food_item_name").val();
        let description = $("#food_item_description").val();
        let price = $("#food_item_price").val();
        let mealType = $("#food_item_type").val();
        const food = {
            "foodId": indexOfEditedItem,
            "name" : name,
            "description" : description,
            "price" : price,
            "mealType": mealType
        }
        fetch(url + "/add-food", {
            method: "put",
            body: JSON.stringify(food),
            headers: {
                "Content-Type": "application/json"
            }
        }).then(response => {
            if (response.ok) {
                return response.json();
            } else {
                return Promise.reject({ status: response.status, statusText: status.statusText})
            }
        }).then(foodItems => {
            $("#save_food_button").show();
            $(".update").hide();
            prepareTable(foodItems);
        }).catch(err => {
            console.log(err.statusText);
        })

        $("#check").hide();
        clearForm();
    })
    $("#cancel_update_button").on("click", function(event) {
        event.preventDefault();
        $("#save_food_button").show();
        $(".update").hide();
        clearForm();
    })

    function clearForm() {
        $("#food_item_name").val("");
        $("#food_item_description").val("");
        $("#food_item_price").val("");
        $("#food_item_type").val("");
    }
})