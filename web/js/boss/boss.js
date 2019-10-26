$(".price").blur(function () {
    // if(/[^\-?\d.]/g.test(this.value)) {
    //     alert('请正确输入价格');
    //     this.value=''
    // }
    // var val = $(this).val(); //获得输入值
    // if(val.charAt('0') == 0){ //如果第一个为'0'时
    //     val = val.replace(/\b(0+)/gi,""); //清除多余的'0'
    //     if(val.substr(0,1)=='.'){ //如果有小数点'.'时,前面加一个0
    //         $(this).val( "0" + val);
    //     }else{
    //         $(this).val(val);
    //     }
    // }
    var priceReg = /(^[1-9]\d*(\.\d{1,2})?$)|(^0(\.\d{1,2})?$)/;
    var price=$(this).val();
    if (!priceReg.test(price)){
        alert('请正确输入价格: 整数或者保留两位小数');
        this.value='';
    }
});

