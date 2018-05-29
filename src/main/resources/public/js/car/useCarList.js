$("#search").click(function () {
    var key = $("#key").val();
    loadHtml('/oa/useCar/list', {key: key, pageSize: 10, currentPage: 1});
});