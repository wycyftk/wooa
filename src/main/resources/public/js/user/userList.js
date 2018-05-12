var delUser = function (id) {

    $.ajax({
       url: '/oa/api/user/del?id=' + id,
       type: 'delete',
       dataType: 'json',
       success: function (data) {
           alert(data.message);
           loadHtml('/oa/user/list', {key: '', pageSize: 10, currentPage: 1});
       },
        error: function (data) {

        }
    });
}

$("#search").click(function () {
    var key = $("#key").val();
    loadHtml('/oa/user/list', {key: key, pageSize: 10, currentPage: 1});
});