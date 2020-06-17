$(function () {
    $('#btnChkout').click(toCart);

    function toCart() {
        let orders = "";
        let row = $('#orderTbl td:first-child').each(function () {
            orders += " " + $(this).text();

        });
        let order = process(orders);
        $.post('checkout',{checkout: JSON.stringify(order)}, checkout, "json");
    }
})


function process(order) {
    let ord = [];
    ord = order.split(" ");
    console.log(ord);
    let orders = Object.assign({},ord);
    return orders;
}

function createObject(order){
    let item = {};
    item.order = order;
    return item;
}

function checkout(data) {
    var td0=$('<td>').text(data.id);
    var td1 = $('<td>').text(data.name);
    var td2 = $('<td>').text(data.price);
    var tr = $('<tr>').append(td0).append(td1).append(td2);
    $('#checkoutTable > tbody').append(tr);
}
