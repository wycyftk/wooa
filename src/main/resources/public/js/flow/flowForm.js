(function ($) {
    var carOrMeeting = 'meeting';

    var loadSelector = function () {
        var carSelector = $("#car");
        var roomMeetingSelector = $("#meetingRoom");

        $.ajax({
            url: '/oa/api/car/carList',
            type: 'get',
            success: function (data) {
                if(data.status){
                    carSelector.append(htmlStr(data.data, 'car'));
                }
            },
            error: function (data) {

            }
        });

        $.ajax({
            url: '/oa/api/meetingRoom/meetingRoomList',
            type: 'get',
            success: function (data) {
                if(data.status){
                    roomMeetingSelector.append(htmlStr(data.data, 'meetingRoom'));
                }
            },
            error: function (data) {

            }
        });
    }

    function htmlStr(objs, type) {
        var html = "";
        var carId = $('#car').data('choose-car');
        var meetingRoomId = $('#meetingRoom').data('choose-room');
        var selected = ''

        if(type == 'car'){
            for(var i = 0;i < objs.length; i++){
                selected = carId == objs[i].carId ? 'selected' : '';
                html += "<option value='" + objs[i].id + "'" + selected + ">" + objs[i].carName + "</option>";
            }
        } else {
            for(var i = 0;i < objs.length; i++){
                selected = carId == objs[i].meetingRoomId ? 'selected' : '';
                html += "<option value='" + objs[i].id + "'" + selected + ">" + objs[i].meetingRoom + "</option>";
            }
        }
        return html;
    }

    $('#submitFlow').click(function () {
        var flow = getFlow();
        flow.status = 2;
        $.ajax({
            url: '/oa/api/flow/add',
            data: JSON.stringify(flow),
            dataType: 'json',
            type: 'post',
            contentType: 'application/json;charset=utf-8',
            success: function (data) {
                alert("提交成功");
                loadHtml("/oa/main");
            },
            error: function (data) {

            }
        });
    });

    $('#keepFlow').click(function () {
        var flow = getFlow();
        flow.status = 1;
        $.ajax({
            url: '/oa/api/flow/add',
            data: JSON.stringify(flow),
            dataType: 'json',
            type: 'post',
            contentType: 'application/json;charset=utf-8',
            success: function (data) {
                alert("保存成功");
            },
            error: function (data) {

            }
        });
    });

    $("#flowType").change(function () {
       var options = this.options;
       for(i in options) {
           if(options[i].selected) {
               if(options[i].value == 'car'){
                   $("#carBlock").removeClass('flow-car');
                   $("#meetingBlock").addClass('flow-meeting');
                   carOrMeeting = 'car';
               }

               if(options[i].value == 'meeting'){
                   $("#meetingBlock").removeClass('flow-meeting');
                   $("#carBlock").addClass('flow-car');
                   carOrMeeting = 'meeting';
               }
           }
        }
    });

    $(document).ready(function () {
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();

        $("#startTime").datetimepicker({
            language:  'zh-CN',
            format: 'Y-m-d',
            autoclose: true,
            todayBtn: true,
            yearStart: 1900,
            yearEnd: 2018,
            timepicker: false,
            value: startTime ? startTime : ''
        }).on('change',function(ev){
            var st = $("#startTime").val();
            var et = $("#endTime").val();
            if (st > et && et) {
                alert("开始时间不能大于结束时间");
                $("#startTime").val("")
            }
        });

        $("#endTime").datetimepicker({
            language:  'zh-CN',
            format: 'Y-m-d',
            autoclose: true,
            todayBtn: true,
            yearStart: 1980,
            yearEnd: 2050,
            timepicker: false,
            value: endTime ? endTime : ''
        }).on('change',function(ev){
            var st = $("#startTime").val();
            var et = $("#endTime").val();
            if (st > et && st) {
                alert("结束时间应该大于开始时间");
                $("#endTime").val(st)
            }
        });
    })
    
    function getFlow() {
        var flow = {};
        flow.flowName = $("#flowName").val();
        flow.flowType = carOrMeeting;
        flow.flowId = $("#flowId").val();
        if(carOrMeeting == 'car'){
            flow.carId = $("#car option:selected").val();
            flow.reason = $("#reason").val();
            flow.carName = $("#car option:selected").text();
            flow.useCarRecordId = $("#useCarRecordId").val();
            flow.meetingId = 0;
        } else {
            flow.meetingRoomId = $("#meetingRoom option:selected").val();
            flow.meetingName = $("#meetingName").val();
            flow.meetingRoom = $("#meetingRoom option:selected").text();
            flow.meetingId = $("#meetingId").val();
            flow.useCarRecordId = 0;
        }
        flow.startTime = $("#startTime").val();
        flow.endTime = $("#endTime").val();
        return flow;
    }
    loadSelector();
})(jQuery);