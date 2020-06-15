$(function (){
<<<<<<< HEAD
    $('.btnOrder').click(addOrder);
||||||| merged common ancestors
    $('.btnOrder').click(menuSelected);
=======
    $('.btnOrder').click(menuSelected);
    $('.btnOrder').click(goToCart);
>>>>>>> 56340e32968ddcf4bf0691eba7ac2fafd3194155

    function addOrder(){
        let orderValue = $(this).val();
        createObject(orderValue);
        localStorage.setItem(orderValue,orderValue);
        console.log(localStorage);
        $.post('order',{order: JSON.stringify(orderValue)}, orderMeal, "json")
    }
})
<<<<<<< HEAD
let orderedItems = [];
function createObject(order){
    let item = {};
    item.order = order;
    orderedItems.push(item);
}

function orderMeal(data){
    //data = JSON.parse(data);
    var td0=$('<td>').text(data.id);
    var td1 = $('<td>').text(data.name);
    var td2 = $('<td>').text(data.price);
    var tr = $('<tr>').append(td0).append(td1).append(td2);
    $('#tbl_ordered>tbody').append(tr);
}
||||||| merged common ancestors
=======
let orderedItems = [];
function createObject(order){
    let item = {};
    item.order(order);
    orderedItems.push(item);
}

function goToCart() {
    $.post('ordered', {
        order: JSON.stringify(orderedItems)
    })
}
>>>>>>> 56340e32968ddcf4bf0691eba7ac2fafd3194155
