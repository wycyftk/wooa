var delMenu = function (id) {

    $.ajax({
       url: '/oa/api/menu/del?id=' + id,
       type: 'delete',
       dataType: 'json',
       success: function (data) {
           console.log(data);
           alert(data.message);
           loadHtml('/oa/menu/list', {key: '', pageSize: 10, currentPage: 1});
       },
        error: function (data) {

        }
    });
}

$("#search").click(function () {
    var key = $("#key").val();
    loadHtml('/oa/menu/list', {key: key, pageSize: 10, currentPage: 1});
});