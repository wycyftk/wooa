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
                    alert("编辑成功");
                    loadHtml('/oa/menu/list', {pageSize: 10, currentPage: 1, key: ''})
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
                    alert("新增成功");
                    loadHtml('/oa/menu/list', {pageSize: 10, currentPage: 1, key: ''})
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
        menu.description = $('#description').val();
        menu.menuUrl = $('#menuUrl').val();
        $("input[name=relation]").each(function () {
            if(this.checked){
                menu.relation = $(this).val();
            }
        });
        if($("#chooseMenuId").val()){
            menu.chooseMenuId = $("#chooseMenuId").val();
        }
        return menu;
    }

    var registerIcon = function () {
        $(".menu-structure i").each(function () {
            var _this = this;
            var clickSub = function () {
                $(_this).toggleClass("fa-minus-square-o");
                $(_this).toggleClass("fa-plus-square-o");
                var subMenu = $(_this).next().next();
                if(subMenu.length){
                    subMenu.toggleClass("sub-hide");
                }else{
                    addSubMenu($(_this).parent(), $(_this).data('submenu'));
                }
            }
            $(_this).unbind("click", clickSub);
            $(_this).click(clickSub);
        });
    }

    var register = function(){
        $(".menu-structure span").each(function () {
            var _this = this;
            var chooseMenu = function () {
                $("#chooseMenuName").val($(_this).text());
                $("#chooseMenuId").val($(_this).data('menuid'));
            }
            $(_this).unbind("click", chooseMenu);
            $(_this).click(chooseMenu);
        });
    }

    function addSubMenu(el, menuId) {
        $.ajax({
            url: '/oa/api/menu/subMenu?id=' + menuId,
            dataType: 'json',
            type: 'get',
            success: function (res) {
                if(res.status){
                    el.append(menuHtml(res.data));
                    register();
                    registerIcon();
                }
            },
            error: function (data) {

            }
        });
    }

    function menuHtml(menus) {
        var html = "<ul class=\"sub-structure\">";
        for(var i = 0; i < menus.length; i++){
            if(menus[i].rightNode - menus[i].leftNode > 1){
                html += "<li><i class=\"fa fa-plus-square-o\" data-submenu=\"" + menus[i].id + "\"></i><span data-menuId='" + menus[i].id + "'>" + menus[i].menuName + "</span></li>";
            }else{
                html += "<li><span data-menuId='" + menus[i].id + "'>" + menus[i].menuName + "</span></li>";
            }
        }
        html += "</ul>"
        return html;
    }

    register();
    registerIcon();
})(jQuery);