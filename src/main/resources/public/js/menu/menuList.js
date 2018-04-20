var delMenu = function (id) {

    $.ajax({
       url: '/oa/api/menu/del?id=' + id,
       type: 'delete',
       dataType: 'json',
       success: function (data) {
            console.log(data);
       },
        error: function (data) {

        }
    });
}