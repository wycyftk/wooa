(function ($) {
    $('#submitMenu').click(function () {
        var menu = getMenu();
        if(menu.id){
            $.ajax({
                url: '/oa/api/menu/update',
                data: JSON.stringify(menu),
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
                url: '/oa/api/menu/add',
                data: JSON.stringify(menu),
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
    
    function getMenu() {
        var menu = {};
        menu.id = $("#id").val();
        menu.menuName = $("#menuName").val();
        menu.descrition = $('#descrition').val();
        menu.menuUrl = $('#menuUrl').val();
        return menu;
    }
})(jQuery);