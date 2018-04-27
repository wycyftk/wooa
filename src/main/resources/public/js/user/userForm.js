(function ($) {
    $('#submitUser').click(function () {
        var user = getUser();
        if(user.id){
            $.ajax({
                url: '/oa/api/user/update',
                data: JSON.stringify(user),
                dataType: 'json',
                type: 'put',
                contentType: 'application/json;charset=utf-8',
                success: function (data) {
                    alert("修改成功");
                    loadHtml('/oa/user/list');
                },
                error: function (data) {

                }
            });
        }else {
            $.ajax({
                url: '/oa/api/user/addUser',
                data: JSON.stringify(user),
                dataType: 'json',
                type: 'post',
                contentType: 'application/json;charset=utf-8',
                success: function (data) {
                    if(data.status){
                        alert("新增成功");
                        $("#name").val('');
                        $('#username').val('');
                        $('#email').val('');
                        $('#birthday').val('');
                        $('#mobile').val('');
                    }
                },
                error: function (data) {

                }
            });
        }
    });
    
    function getUser() {
        var user = {};
        user.id = $("#id").val();
        user.name = $("#name").val();
        user.username = $('#username').val();
        user.password = $('#password').val();
        user.email = $('#email').val();
        $('input[name=sex]').each(function () {
            if(this.checked){
                user.sex = $(this).data('sex');
            }
        });
        user.birthday = $('#birthday').val();
        user.mobile = $('#mobile').val();
        return user;
    }
})(jQuery);