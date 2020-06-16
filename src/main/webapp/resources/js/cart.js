$(function () {
    $('#btnChkout').click(toCart);

    function toCart() {
        let order = "";
        let row = $('#orderTbl td:first-child').each(function () {
            order += " " + $(this).text();
            console.log(order);

        });
        $.post('checkout',{checkout: JSON.stringify(order)}, checkout, "json");
    }
})



function createObject(order){
    let item = {};
    item.order = order;
    return item;
}

function checkout() {
    var td0=$('<td>').text(data.id);
    var td1 = $('<td>').text(data.name);
    var td2 = $('<td>').text(data.price);
    var tr = $('<tr>').append(td0).append(td1).append(td2);
    $('#checkoutTable>tbody').append(tr);
}
