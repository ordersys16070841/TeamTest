var unameVar;

$('#yes-btn').click(function () {
    $.ajax({
        type: 'POST',
        url: 'findPass',
        data:{uname:$.trim($('#acot').val()),uquest:$.trim($('#uquest').val()),uanswer:$.trim($('#uanswer').val())},
        dataType: 'html',
        timeout: 1000,
        success: function (result){
            if (result != "" && result == "success") {
                $('.formBox').addClass('level-forget').removeClass('level-reg');
            } else {
                $('#fog-msg').html("认证失败，密保答案错误");
            }
        }
    });
    unameVar=$('#acot').val();
    $('#acot').val('');
    $('#uanswer').val('');
});


$('#res-btn').click(function () {
    $.ajax({
        type: 'POST',
        url: 'reset',
        data:{uname:unameVar,upass:$.trim($('#upass').val())},
        dataType: 'html',
        timeout: 1000,
        success: function (result){
            if(result != "" && result == "success"){
                $('#res-div').html("重置密码成功<a href='homepage'>返回主页</a>");
            }else{
                $('#res-div').html("重置密码失败");
            }
        }
    });
    $('#upass').val('');
});