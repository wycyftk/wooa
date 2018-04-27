(function ($) {
    $('#submitOrg').click(function () {
        var info = getOrg();
        if(info.id){
            $.ajax({
                url: '/oa/api/info/update',
                data: JSON.stringify(info),
                dataType: 'json',
                type: 'put',
                contentType: 'application/json;charset=utf-8',
                success: function (data) {
                    console.log(data);
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