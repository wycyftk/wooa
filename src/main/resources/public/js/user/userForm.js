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
                    alert("编辑成功");
                    loadHtml('/oa/user/list', {pageSize: 10, currentPage: 1});
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
                        loadHtml('/oa/user/list', {pageSize: 10, currentPage: 1});
                    }
                },
                error: function (data) {

                }
            });
        }
    });

    $(document).ready(function () {
        var date = $("#birthday").val();

        $("#birthday").datetimepicker({
            minView: "month",
            language:  'zh-CN',
            format: 'Y-m-d',
            autoclose: true,
            todayBtn: true,
            yearStart: 1900,
            yearEnd: 2018,
            timepicker: false,
            value: date ? date : ''
        });
    })

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
