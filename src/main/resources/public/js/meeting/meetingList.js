$("#search").click(function () {
    var key = $("#key").val();
    loadHtml('/oa/meeting/list', {key: key, pageSize: 10, currentPage: 1});
});