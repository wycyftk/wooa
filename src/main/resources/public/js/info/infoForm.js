(function ($) {
    $('#submitInfo').click(function () {
        var info = getInfo();
        if(info.id){
            $.ajax({
                url: '/oa/api/info/update',
                data: JSON.stringify(info),
                dataType: 'json',
                type: 'put',
                contentType: 'application/json;charset=utf-8',
                success: function (data) {
                    console.log(data);
                    alert("编辑成功");
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
                    alert("新增成功");
                    loadHtml('/oa/info/list', {pageSize: 10, currentPage: 1, key: ''});
                },
                error: function (data) {

                }
            });
        }
    });
    
    function getInfo() {
        var info = {};
        info.id = $("#id").val();
        info.infoTitle = $("#infoTitle").val();
        $("input[name=important]").each(function () {
           var _this = this;
           if(_this.checked){
               info.important = $(_this).val();
           }
        });
        $("input[name=orgId]").each(function () {
            var _this = this;
            if(_this.checked){
                info.orgId = $(_this).val();
            }
        });
        info.content = $("#content").val();
        return info;
    }
})(jQuery);