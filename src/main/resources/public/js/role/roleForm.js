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
                    console.log(data);
                },
                error: function (data) {

                }
            });
        }else {
            $.ajax({
                url: '/oa/api/role/addRole',
                data: JSON.stringify(role),
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
    
    function getRole() {
        var role = {};
        role.id = $("#id").val();
        role.roleName = $("#roleName").val();
        role.roleCode = $('#roleCode').val();
        return role;
    }
})(jQuery);