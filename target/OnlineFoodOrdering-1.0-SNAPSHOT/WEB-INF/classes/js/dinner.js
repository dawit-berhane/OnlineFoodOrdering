$(function(){
    "use strict";


    const url = "http://localhost:8080/newProject_war";

    fetch(url + "/food?type=dinner" ).then(response => {
        if (response.ok) {
            return response.json();
        } else {
            return Promise.reject({ status: response.status, statusText: status.statusText})
        }
    }).then(foodItems => {
        prepareTable(foodItems);
    }).catch(err => {
        console.log(err.statusText);
    })

    function prepareTable(foodItems) {
        let tableBody = "";
        for (let item of foodItems) {

            tableBody += `<tr><td>${item.name}</td><td>${item.description}</td><td>${item.price}</td><td>${item.mealType}</td></tr>
                                // <button id="${item.foodId}delete" class="delete">delete</button>
                                // <button id="${item.foodId}edite" class="edite">edite</button></td></tr>`

        }

        $("#food_list").html(tableBody);
    }
})