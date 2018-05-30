(function ($) {
    var isUsernameRight = false;
    var isPasswordRight = false;

    var loginPrompt = function (info) {
        $(".login-prompt").text(info);
        $(".login-prompt").show();
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
            loginPrompt("");
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
            loginPrompt("");
            isPasswordRight = true;
        }
    });

    $("#login").click(function () {
        var username = $("#username").val();
        var password = $("#password").val();
        var user = {};
        user.username = username;
        user.password = password;

        if (username && password) {
            isUsernameRight = true;
            isPasswordRight = true;
        }

        if(isUsernameRight && isPasswordRight){
            loginPrompt("");
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
                        $("#password").val("");
                        isUsernameRight = false;
                        isPasswordRight = false;
                    }
                }
            });
        } else {
            loginPrompt("请填写用户名和密码");
        }
    });

    $(document).keypress(function(e) {
        // 回车键事件
        if(e.which == 13) {
            $("#login").click();
        }
    });
})(jQuery);



