(function ($) {
    $('#submitOrg').click(function () {
        var org = getOrg();
        if(org.id){
            $.ajax({
                url: '/oa/api/org/update',
                data: JSON.stringify(org),
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
                url: '/oa/api/org/add',
                data: JSON.stringify(org),
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

    $(".org-structure i").each(function () {
        var _this = this;
        $(_this).click(function () {
            debugger;
            $(_this).toggleClass("fa-minus-square-o");
            $(_this).toggleClass("fa-plus-square-o");
            var subOrg = $(_this).next().next();
            if(subOrg.length){
                subOrg.toggleClass("sub-hide");
            }else{
                adSsubOrg($(_this).parent(), $(_this).data('suborg'));
            }
            alert($(_this));
        });
    });

    function adSsubOrg(el, orgId) {
        $.ajax({
            url: '/oa/api/org/subOrg?id=' + orgId,
            dataType: 'json',
            type: 'get',
            success: function (res) {
                if(res.status){
                    el.append(res.data);
                }
            },
            error: function (data) {

            }
        });
    }

    function orgHtml(orgs) {
        var html = "<ul class=\"sub-structure sub-hide\">";
        for(var i = 0; i < orgs.length; i++){
            if(orgs[i].rightNode - orgs[i].leftNode > 1){
                html += "<li><a href=\"#\"><i class=\"fa fa-plus-square-o\" data-suborg=\"" + orgs[i].id + "\"></i>" + orgs[i].orgName + "</a></li>";
            }else{
                html += "<li><a href=\"#\">" + orgs[i].orgName + "</a></li>";
            }
        }
        html += "</ul>"
        return html;
    }
    
    function getOrg() {
        var org = {};
        org.id = $("#id").val();
        org.orgName = $("#roleName").val();
        org.descrition = $('#roleCode').val();
        return org;
    }
})(jQuery);