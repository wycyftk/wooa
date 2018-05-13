var delflow = function (type, id) {
    $.ajax({
       url: '/oa/api/flow/delFlow?type='+ type + '&id=' + id,
       type: 'delete',
       dataType: 'json',
       success: function (data) {
            console.log(data);
            alert(data.message);
       },
        error: function (data) {

        }
    });
}

$("#search").click(function () {
    var key = $("#key").val();
    loadHtml('/oa/flow/myWork', {key: key, pageSize: 10, currentPage: 1});
});