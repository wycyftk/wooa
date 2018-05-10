(function ($) {
    $('#submitCar').click(function () {
        var car = getCar();
        if(car.id){
            $.ajax({
                url: '/oa/api/car/update',
                data: JSON.stringify(car),
                dataType: 'json',
                type: 'put',
                contentType: 'application/json;charset=utf-8',
                success: function (data) {
                    alert("修改成功");
                    loadHtml('/oa/car/list', {pageSize: 10, currentPage: 1});
                },
                error: function (data) {

                }
            });
        }else {
            $.ajax({
                url: '/oa/api/car/add',
                data: JSON.stringify(car),
                dataType: 'json',
                type: 'post',
                contentType: 'application/json;charset=utf-8',
                success: function (data) {
                    alert("新增成功");

                },
                error: function (data) {

                }
            });
        }
    });

    
    function getCar() {
        var car = {};
        car.id = $("#id").val();
        car.carName = $("#carName").val();
        car.startTime = $('#startTime').val();
        car.endTime = $('#endTime').val();
        return car;
    }
})(jQuery);