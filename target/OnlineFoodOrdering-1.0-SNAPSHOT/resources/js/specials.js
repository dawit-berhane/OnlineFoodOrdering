
function pageLoad (){
    "use strict"

    const one = document.getElementById('oneperson');
    one.onclick= oneprson ;
    const  two = document.getElementById("twopeople");
    two.onclick =twopeople
    const family = document.getElementById('family');
    family.onclick = familysize;
    const checkout = document.getElementById('btn_checkout');
    checkout.onclick = calcCoupon;
    const summary = document.getElementById('btnreceipt');
    summary.onclick = receipt;

}

function oneprson(){
    const subtotalElem = document.getElementById('subtotal');
    subtotalElem.value = 16 ;

}
function twopeople(){
    const subtotalElem = document.getElementById('subtotal');
    subtotalElem.value = 26.59 ;

}
function familysize(){
    const subtotalElem = document.getElementById('subtotal');
    subtotalElem.value = 44 ;

}



function calcCoupon() {
    const subtotalElem = document.getElementById('subtotal');
    const  couponElem = document.getElementById("coupon");
    const totalElem = document.getElementById('total');
    couponElem.value = 0.2 * subtotalElem.value;
    const num = parseFloat(subtotalElem.value);
    const coupon = parseFloat(couponElem.value);
    const total = num - coupon;
    const totalTip = (0.625 * total)+total ;
    totalElem.innerHTML = '$' + totalTip;
}

function receipt(){

    const subtotalElem = document.getElementById('subtotal');
    const  couponElem = document.getElementById("tip");
    const totalElem = document.getElementById('total');
    couponElem.value = 0.2 * subtotalElem.value;
    const num = parseFloat(subtotalElem.value);
    const coupon = parseFloat(couponElem.value);
    const total = num - coupon;
    const totalTip = (0.625 * total)+total ;
    totalElem.innerHTML = '$' + totalTip;

    const receipvalue = document.getElementById("receipt");
    receipvalue.style.visibility= 'visible';
    receipvalue.value = `Thank you for dining with us ! 
                          subtotal: ${subtotalElem.value} 
                           coupon applied : ${tipElem.value}
                            tax : 6.24 % 
                             total amount: ${totalTip}
                             
                       PLEASE COME AGAIN!`;

}

$(function () {

    $('.example-popover').popover({
        container: 'body'
    })
});

window.onload = pageLoad;