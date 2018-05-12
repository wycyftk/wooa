(function ($) {
    $('#submitRole').click(function () {
        var role = getRole();
        if(role.id){
            $.ajax({
                url: '/oa/api/role/update',
                data: JSON.stringify(role),
                dataType: 'json',
                type: 'put',
                contentType: 'application/json;charset=utf-8',
                success: function (data) {
                    alert("编辑成功");
                    loadHtml('/oa/role/list', {pageSize: 10, currentPage: 1});
                },
                error: function (data) {

                }
            });
        }else {
            $.ajax({
                url: '/oa/api/role/add',
                data: JSON.stringify(role),
                dataType: 'json',
                type: 'post',
                contentType: 'application/json;charset=utf-8',
                success: function (data) {
                    alert("新增成功");
                    loadHtml('/oa/role/list', {pageSize: 10, currentPage: 1});
                },
                error: function (data) {

                }
            });
        }
    });
    
    function getRole() {
        var role = {};
        role.id = $("#id").val();
        role.roleName = $("#roleName").val();
        role.roleCode = $('#roleCode').val();
        return role;
    }
})(jQuery);