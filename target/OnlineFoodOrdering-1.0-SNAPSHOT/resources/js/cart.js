$(function () {
    $('#btnChkout').click(toCart);
    $('#payBtn').click(showMessage);
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
    let td0=$('<td>').text(data.id);
    let td1 = $('<td>').text(data.name);
    let td2 = $('<td>').text(data.price);
    let tr = $('<tr>').append(td0).append(td1).append(td2);
    $('#checkoutTable > tbody').append(tr);
}

function showMessage() {
    $('#success_msg').text("payment done").css({
        'color': 'Green',
        'font-size': '16pt'
    });

}
