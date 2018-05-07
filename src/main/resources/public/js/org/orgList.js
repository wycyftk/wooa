var delOrg = function (id) {

    $.ajax({
       url: '/oa/api/org/del?id=' + id,
       type: 'delete',
       dataType: 'json',
       success: function (data) {
            alert(data.message);
       },
        error: function (data) {

        }
    });
}

$("#search").click(function () {
   var key = $("#key").val();
   loadHtml('/oa/org/list', {key: key, pageSize: 10, currentPage: 1});
});