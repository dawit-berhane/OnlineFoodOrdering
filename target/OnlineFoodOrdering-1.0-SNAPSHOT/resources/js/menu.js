$(function (){
    $('.btnOrder').click(addOrder);

    function addOrder(){
        let orderValue = $(this).val();
        orderValue = createObject(orderValue);
        //localStorage.setItem(orderValue,orderValue);
        //console.log(localStorage);
        $.post('order',{order: JSON.stringify(orderValue)}, orderMeal, "json")
    }
})
let orderedItems = [];
function createObject(order){
    let item = {};
    item.order = order;
    return item;
}

function orderMeal(data){
    //data = JSON.parse(data);
    let td0=$('<td>').text(data.name);
    let td1 = $('<td>').text(data.description);
    let td2 = $('<td>').text('$'+ data.price);

    let button = $("<button>",{
        'text': 'Remove',
        'click': removeOrder
    })
    //let td3 = $('<td>').append(button)
    var tr = $('<tr>').append(td0).append(td1).append(td2).append(button);
    $('#orderTbl > tbody').append(tr);
}

function removeOrder() {
    $(this).parent().remove();

}