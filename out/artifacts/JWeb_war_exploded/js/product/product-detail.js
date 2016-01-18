$(document).ready(function(){
    $('#login-submit').click(function(){
       sendLogin();
    });

    $(document).keypress(function(event){
        if (!$('#loginModal').is(":hidden")){
            if (event.keyCode == 13){
                sendLogin();
            }
        }
    });
    function sendLogin(){
        $.ajax({
            type:"GET",
            url:"/JWeb/servlet/LoginServlet",
            data:{username:$('#username').val(),password:$('#password').val()},
            success: function(data){
                var result = JSON.parse(data);
                if (parseInt(result.msg)){
                    window.location.reload();
                }else {
                    $('.modal-body-msg').text("用户名或密码错误");
                }

            }
        })
    }

});
