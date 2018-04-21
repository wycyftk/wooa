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
    
    function getOrg() {
        var org = {};
        org.id = $("#id").val();
        org.orgName = $("#roleName").val();
        org.descrition = $('#roleCode').val();
        return org;
    }
})(jQuery);