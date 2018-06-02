var delRole = function (id) {
    $.ajax({
       url: '/oa/api/flow/delFlow?id=' + id,
       type: 'delete',
       dataType: 'json',
       success: function (data) {
            console.log(data);
            alert(data.message)
       },
        error: function (data) {

        }
    });
}

$("#search").click(function () {
    var key = $("#key").val();
    loadHtml('/oa/flow/list', {key: key, pageSize: 10, currentPage: 1});
});