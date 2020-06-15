$(function (){
    $('.btnOrder').click(menuSelected);
    $('.btnOrder').click(goToCart);

    function menuSelected(){
        let orderValue = $(this).val();
        createObject(orderValue);
        localStorage.setItem(orderValue,orderValue);
        console.log(localStorage);
    }
})
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