$(function (){
    $('.btnOrder').click(menuSelected);

    function menuSelected(){
        let orderValue = $(this).val();
        localStorage.setItem(orderValue,orderValue);
        console.log(localStorage);
    }
})
