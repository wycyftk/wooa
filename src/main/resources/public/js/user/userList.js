var roles = new Array();
var orgs = new Array();
var userId = 0;

var delUser = function (id) {
    $.ajax({
       url: '/oa/api/user/del?id=' + id,
       type: 'delete',
       dataType: 'json',
       success: function (data) {
           alert(data.message);
           loadHtml('/oa/user/list', {key: '', pageSize: 10, currentPage: 1});
       },
        error: function (data) {

        }
    });
}

var roleModalHtml = function (data) {
    var htmlStr = "";
    for(var i = 0; i < data.length; i++){
        if((i + 1) % 3 == 1){
            htmlStr += "<div class=\"row\"><div class=\"offset-sm-1 col-sm-4\">";
        } else if((i + 1) % 3 == 2){
            htmlStr += "<div class=\"col-sm-4\">";
        } else {
            htmlStr += "<div class=\"col-sm-3\">";
        }

        htmlStr += modalDiv('role', data[i].roleName, data[i].roleId, data[i].userId, i);
        htmlStr += "</div>";
        if((i + 1) % 3 == 0){
            htmlStr += "</div>";
        }
    }
    return htmlStr;
}

var orgModalHtml = function (data) {
    var htmlStr = "";
    for(var i = 0; i < data.length; i++){
        if((i + 1) % 3 == 1){
            htmlStr += "<div class=\"row\"><div class=\"offset-sm-1 col-sm-4\">";
        } else if((i + 1) % 3 == 2){
            htmlStr += "<div class=\"col-sm-4\">";
        } else {
            htmlStr += "<div class=\"col-sm-3\">";
        }

        htmlStr += modalDiv('org', data[i].orgName, data[i].orgId, data[i].userId, i);
        htmlStr += "</div>";
        if((i + 1) % 3 == 0){
            htmlStr += "</div>";
        }
    }
    return htmlStr;
}

function modalDiv(roleOrOrg, showName, roleId, userId, index) {
    var checked = userId ? 'checked' : '';
    var html = "<div class=\"form-check\">" +
        " <input data-type='" + roleOrOrg + "' class='form-check-input' " + checked + " type='checkbox' value='" + roleId + "' id='" + roleOrOrg + index + "'>" +
        " <label class='form-check-label' for='" + roleOrOrg + index + "'>" +
        showName +
        " </label>" +
        " </div>";
    return html;
}

$("#search").click(function () {
    var key = $("#key").val();
    loadHtml('/oa/user/list', {key: key, pageSize: 10, currentPage: 1});
});

$("span[data-userid-role]").each(function () {
    var _this = this;
    $(_this).click(function () {
        $("#roleList").empty();
        userId = $(_this).data('userid-role');
        $.ajax({
           url: '/oa/api/role/getRolesById?userId=' + userId,
           type: 'get',
           dataType: 'json',
           success: function (data) {
               if(data.status){
                   $("#roleList").append(roleModalHtml(data.data));
               }
           },
            error: function (data) {

            }
        });
    });
});
//分配组织
$("span[data-userid-org]").each(function () {
    var _this = this;
    $(_this).click(function () {
        $("#orgList").empty();
        userId = $(_this).data('userid-org');
        $.ajax({
            url: '/oa/api/org/getOrgsById?userId=' + userId,
            type: 'get',
            dataType: 'json',
            success: function (data) {
                if(data.status){
                    $("#orgList").append(orgModalHtml(data.data));
                }
            },
            error: function (data) {

            }
        });
    });
});

$("#assignRole").click(function () {
    roles.splice(0, roles.length);
    $("input[data-type=role]").each(function () {
       if(this.checked){
           roles.push({roleId: $(this).val(), userId: userId});
       }
    });

    $.ajax({
        url: '/oa/api/role/assginRole',
        data: JSON.stringify(roles),
        type: 'post',
        dateType: 'json',
        contentType: 'application/json;charset=utf-8',
        success: function (data) {
            alert(data.message);
            $(".close").click();
        }
    })
});

$("#assignOrg").click(function () {
    orgs.splice(0, orgs.length);
    $("input[data-type=org]").each(function () {
        if(this.checked){
            orgs.push({orgId: $(this).val(), userId: userId});
        }
    });

    $.ajax({
        url: '/oa/api/org/assginOrg',
        data: JSON.stringify(orgs),
        type: 'post',
        dateType: 'json',
        contentType: 'application/json;charset=utf-8',
        success: function (data) {
            alert(data.message);
            $(".close").click();
        }
    })
});