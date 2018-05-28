(function ($) {
    (function () {
        var type = $("#infoType option:selected").val();
        if(type == "部门消息"){
            getOrg();
        }
    })()
    
    $("#infoType").change(function () {
        var _this = this;
        if($("#infoType option:selected").val() == "部门消息"){
            getOrg();
        } else {
            $(".chooseOrg").hide();
        }
    });

    updateReadInfoNum();
    
    function getInfo() {
        var info = {};
        info.id = $("#id").val();
        info.infoTitle = $("#infoTitle").val();
        info.important = $('#important option:selected').val();
        info.infoType = $('#infoType option:selected').val();
        info.orgId = $("#orgId option:selected").val();
        info.content = $("#content").val();
        return info;
    }
    
    function getOrg() {
        $.ajax({
            url: '/oa/api/org/getOrgNameAndId',
            type: 'get',
            dataType: 'json',
            success: function (data) {
                if(data.status){
                    $("#orgId").append(getOrgHtmlStr(data.data));
                    $(".chooseOrg").show();
                } else {
                    alert(data.message);
                }
            }
        })
    }

    function getOrgHtmlStr(org) {
        var htmlStr = "";
        var orgId = $("#orgId").val() == 0 ? null : $("#orgId").val();
        for(var i = 0; i < org.length; i++){
            if(orgId == org[i].id){
                htmlStr += "<option value='" + org[i].id + "' selected>" + org[i].org_name + "</option>"
            } else {
                htmlStr += "<option value='" + org[i].id + "'>" + org[i].org_name + "</option>"
            }
        }
        return htmlStr;
    }
})(jQuery);