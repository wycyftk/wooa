var delInfo = function (id) {
    $.ajax({
       url: '/oa/api/info/del?id=' + id,
       type: 'delete',
       dataType: 'json',
       success: function (data) {
            console.log(data);
            updateReadInfoNum();
            loadHtml('/oa/info/list', {pageSize: 10, currentPage: 1});
            alert(data.message);
       },
        error: function (data) {

        }
    });
}

$("#search").click(function () {
    var key = $("#key").val();
    loadHtml('/oa/info/list', {key: key, pageSize: 10, currentPage: 1});
});