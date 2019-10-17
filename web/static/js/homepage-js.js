
$('#regModal').on('hidden.bs.modal',function () {
    $('#regModal input').val('');
    $('#reg-msg').html("");
});

$('#loginModal').on('hidden.bs.modal',function () {
    $('#loginModal input').val('');
    $('#login-msg').html("");
});



//------------- Ajax --------------------

//--------------- My ----------------------

$('#login-btn').click(function () {
    $.ajax({
        type: 'POST',
        url: 'user/login',
        data: {account: $.trim($('#inputTel').val()),password:$.trim($('#inputPassword').val())},
        dataType: 'html',
        timeout: 1000,
        success: function (result) {
            if (result != "" && result == "success") {
                window.location.href = 'homepage';
            } else {
                $('#login-msg').html("登录失败，账号或密码错误");
            }
        }
    });
    $('#loginModal input').val('');
});


$('#reg-btn').click(function(){

     $.ajax({
         type:'POST',
         url:'user/register',
         data:{uacot:$.trim($('#uacot').val()),uname:$.trim($('#uname').val()),upass:$.trim($('#upass').val()),
         uquest:$.trim($('#uquest').val()),uanswer:$.trim($('#uanswer').val())},
         dataType:'html',
         timeout:1000,
         success:function(result){
             if (result != "" && result == "success") {
                 $('#reg-msg').html("用户注册成功");
             }else if(result=="uacot_rep"){
                 $('#reg-msg').html("注册失败，此用户账号已被注册");
             }else if(result=="uname_rep"){
                 $('#reg-msg').html("注册失败，此用户名已被注册");
             }else{
                 $('#reg-msg').html("注册失败");
             }
         }
     });
    $('#regModal input').val('');
});


function dislike(ele) {
    $.ajax({
        type:'POST',
        url:'dislike',
        data:{mid:$.trim($(ele).val())},
        dataType:'html',
        timeout:1000,
        success:function(result){
            var v=$(ele).parent().parent().find(".dislike-input").val();
            $(ele).parent().parent().find(".dislike-input").val(++v);
        }
    });
}

function like(ele){
    $.ajax({
        type:'POST',
        url:'like',
        data:{mid:$.trim($(ele).val())},
        dataType:'html',
        timeout:1000,
        success:function(result){
            var v=$(ele).parent().parent().find(".like-input").val();
            $(ele).parent().parent().find(".like-input").val(++v);
        }
    });
}

function download(ele) {
    $.ajax({
        type:'POST',
        url:'like',
        data:{mid:$.trim($(ele).val())},
    })
}
























