$(function (){
    $('.btnOrder').click(addOrder);

    function addOrder(){
        let orderValue = $(this).val();
        createObject(orderValue);
        localStorage.setItem(orderValue,orderValue);
        console.log(localStorage);
        $.post('order',{order: JSON.stringify(orderValue)}, orderMeal, "json")
    }
})
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