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
                    if(data.status){
                        alert("编辑成功");
                        loadHtml('/oa/org/list', {pageSize: 10, currentPage: 1});
                    }
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
                    if(data.status){
                        alert("新增成功");
                        loadHtml('/oa/org/list', {pageSize: 10, currentPage: 1});
                    }
                },
                error: function (data) {

                }
            });
        }
    });

    $(".org-structure i").each(function () {
        var _this = this;
        $(_this).click(function () {
            $(_this).toggleClass("fa-minus-square-o");
            $(_this).toggleClass("fa-plus-square-o");
            var subOrg = $(_this).next().next();
            if(subOrg.length){
                subOrg.toggleClass("sub-hide");
            }else{
                addSubOrg($(_this).parent(), $(_this).data('suborg'));
            }
        });
    });

    var register = function(){
        $(".org-structure span").each(function () {
            var _this = this;
            var chooseOrg = function () {
                $("#chooseOrgName").val($(_this).text());
                $("#chooseOrgId").val($(_this).data('orgid'));
            }
            $(_this).unbind("click", chooseOrg);
            $(_this).click(chooseOrg);
        });
    }

    function addSubOrg(el, orgId) {
        $.ajax({
            url: '/oa/api/org/subOrg?id=' + orgId,
            dataType: 'json',
            type: 'get',
            success: function (res) {
                if(res.status){
                    el.append(orgHtml(res.data));
                    register();
                }
            },
            error: function (data) {

            }
        });
    }

    function orgHtml(orgs) {
        var html = "<ul class=\"sub-structure\">";
        for(var i = 0; i < orgs.length; i++){
            if(orgs[i].rightNode - orgs[i].leftNode > 1){
                html += "<li><i class=\"fa fa-plus-square-o\" data-suborg=\"" + orgs[i].id + "\"></i><span data-orgId='" + orgs[i].id + "'>" + orgs[i].orgName + "</span></li>";
            }else{
                html += "<li><span data-orgId='" + orgs[i].id + "'>" + orgs[i].orgName + "</span></li>";
            }
        }
        html += "</ul>"
        return html;
    }
    
    function getOrg() {
        var org = {};
        org.id = $("#id").val();
        org.orgName = $("#orgName").val();
        org.description = $('#description').val();
        $("input[name=relation]").each(function () {
           if(this.checked){
               org.relation = $(this).val();
           }
        });
        if($("#chooseOrgId").val()){
            org.chooseOrgId = $("#chooseOrgId").val();
        }
        return org;
    }

    register();
})(jQuery);