var delRole = function (id) {

    $.ajax({
       url: '/oa/api/role/del?id=' + id,
       type: 'delete',
       dataType: 'json',
       success: function (data) {
            console.log(data);
       },
        error: function (data) {

        }
    });
}