(function ($) {
    $('#keepInfo').click(function () {
        var info = getInfo();
        info.status = 0;
        if(info.id){
            $.ajax({
                url: '/oa/api/info/update',
                data: JSON.stringify(info),
                dataType: 'json',
                type: 'put',
                contentType: 'application/json;charset=utf-8',
                success: function (data) {
                    console.log(data);
                    alert(data.message);
                    loadHtml('/oa/info/list', {pageSize: 10, currentPage: 1, key: ''});
                },
                error: function (data) {

                }
            });
        }else {
            $.ajax({
                url: '/oa/api/info/add',
                data: JSON.stringify(info),
                dataType: 'json',
                type: 'post',
                contentType: 'application/json;charset=utf-8',
                success: function (data) {
                    console.log(data);
                    alert(data.message);
                    loadHtml('/oa/info/list', {pageSize: 10, currentPage: 1, key: ''});
                },
                error: function (data) {

                }
            });
        }
    });

    $('#submitInfo').click(function () {
        var info = getInfo();
        info.status = 1;
        if(info.id){
            $.ajax({
                url: '/oa/api/info/update',
                data: JSON.stringify(info),
                dataType: 'json',
                type: 'put',
                contentType: 'application/json;charset=utf-8',
                success: function (data) {
                    console.log(data);
                    alert(data.message);
                    loadHtml('/oa/info/list', {pageSize: 10, currentPage: 1, key: ''});
                },
                error: function (data) {

                }
            });
        }else {
            $.ajax({
                url: '/oa/api/info/add',
                data: JSON.stringify(info),
                dataType: 'json',
                type: 'post',
                contentType: 'application/json;charset=utf-8',
                success: function (data) {
                    console.log(data);
                    alert(data.message);
                    loadHtml('/oa/info/list', {pageSize: 10, currentPage: 1, key: ''});
                },
                error: function (data) {

                }
            });
        }
    });

    (function () {
        var hasRead = $("#hasRead").val();
        if(hasRead){
            var num = $(".info-num").text();
            $(".info-num").text(num - 1);
        }
    })()
    
    function getInfo() {
        var info = {};
        info.id = $("#id").val();
        info.infoTitle = $("#infoTitle").val();
        info.important = $('#important option:selected').val();
        info.infoType = $('#infoType option:selected').val();
        info.content = $("#content").val();
        return info;
    }
})(jQuery);