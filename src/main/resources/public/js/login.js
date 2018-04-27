(function ($) {
    var isUsernameRight = false;
    var isPasswordRight = false;

    var loginPrompt = function (info) {
        $(".login-prompt").text(info);
    }

    $("#username").on("input propertychange", function () {
        var username = $("#username").val();
        var usernameRegex = /^[a-z]|[A-Z]|[0-9]{1,16}$/;
        if(!username){
            loginPrompt("用户名不能为空");
            isUsernameRight = false;
        }else if(!usernameRegex.test(username)){
            loginPrompt("用户名只能为大小写字母与数字");
            isUsernameRight = false;
        }else {
            isUsernameRight = true;
        }
    });

    $("#password").on("input propertychange", function () {
        var password = $("#password").val();
        var passwordRegex = /^[a-z]|[A-Z]|[0-9]|\p{P}$/;//大小写字母，数字和标点符号

        if(!password){
            loginPrompt("密码不能为空");
            isPasswordRight = false;
        }else if(!passwordRegex.test(password)){
            loginPrompt("密码只能为大小写字母、数字和标点符号");
            isPasswordRight = false;
        }else{
            isPasswordRight = true;
        }
    });

    $("#login").click(function () {
        var username = $("#username").val();
        var password = $("#password").val();
        var user = {};
        user.username = username;
        user.password = password;
        if(isUsernameRight && isPasswordRight){
            $.ajax({
                url: '/oa/api/login/in',
                type: 'post',
                dataType: 'json',
                contentType: "application/json;charset=utf-8",
                data: JSON.stringify(user),
                success: function (data) {
                    if(data.status){
                        window.location.href = "/oa/home"
                    }else {
                        loginPrompt("用户名或密码错误");
                        isUsernameRight = false;
                        isPasswordRight = false;
                    }
                }
            });
        }
    });
})(jQuery);



