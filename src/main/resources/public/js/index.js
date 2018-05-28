var loadHtml = function () {
    var url = arguments[0];
    var urlParams = arguments.length > 1 ? arguments[1] : undefined;
    if(urlParams){
        url += "?";
        for(urlParam in urlParams){
            url += '&' + urlParam + "=" + urlParams[urlParam];
        }
    }

    url = url.replace(/&/, "");

    $('#content-page').load(url);
}

var messageAlert = function (type) {
    var message = "";
    switch (type){
        case 'd': message = "数据删除后将无法恢复";break;
        case 'i': message = "添加成功";break;
    }
    alert(message);
}

var logout = function () {
    $({
        url: '/oa/api/login/out',
        dataType: 'json',
        type: 'get',
        success: function (data) {
          alert(data.message);
        },
        error:function (data) {

        }
    });
}

var updateReadInfoNum = function () {
    $.ajax({
        url: '/oa/api/info/infoReadNum',
        type: 'get',
        dateType: 'json',
        success: function (data) {
            if (data.status) {
                var num = data.data == 0 ? '' : data.data;
                $(".info-num").text(num);
            }
        }
    })
}

$(".username").click(function () {
    $(".user-operation").toggleClass()
});

$.datetimepicker.setLocale('zh');

