var delcar = function (id) {
    $.ajax({
       url: '/oa/api/car/del?id=' + id,
       type: 'delete',
       dataType: 'json',
       success: function (data) {
           console.log(data);
           loadHtml('/oa/car/list', {key: '', pageSize: 10, currentPage: 1});
       },
        error: function (data) {

        }
    });
}

$("#search").click(function () {
    var key = $("#key").val();
    loadHtml('/oa/car/list', {key: key, pageSize: 10, currentPage: 1});
});