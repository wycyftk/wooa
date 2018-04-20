var delOrg = function (id) {

    $.ajax({
       url: '/oa/api/org/del?id=' + id,
       type: 'delete',
       dataType: 'json',
       success: function (data) {
            console.log(data);
       },
        error: function (data) {

        }
    });
}