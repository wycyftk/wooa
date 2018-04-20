var delUser = function (id) {

    $.ajax({
       url: '/oa/api/user/del?id=' + id,
       type: 'delete',
       dataType: 'json',
       success: function (data) {

       },
        error: function (data) {

        }
    });
}