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
            url: '/oa/api/meetingRoom/get',
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
        if(type == 'car'){
            for(var i = 0;i < objs.length; i++){
                html += "<option value='" + objs[i].id + "'>" + objs[i].carName + "</option>";
            }
        } else {
            for(var i = 0;i < objs.length; i++){
                html += "<option value='" + objs[i].id + "'>" + objs[i].meetingRoom + "</option>";
            }
        }
        return html;
    }

    $('#submitFlow').click(function () {
        var flow = getFlow();
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
    
    function getFlow() {
        var flow = {};
        flow.flowName = $("#flowName").val();
        flow.flowType = carOrMeeting;
        debugger;
        if(carOrMeeting == 'car'){
            flow.carId = $("#car option:selected").val();
            flow.reason = $("#reason").val();
            flow.carName = $("#car option:selected").text();
        } else {
            flow.meetingRoomId = $("#meetingRoom option:selected").val();
            flow.meetingName = $("#meetingName").val();
            flow.meetingRoom = $("#meetingRoom option:selected").text();
        }
        flow.startTime = $("#startTime").val();
        flow.endTime = $("#endTime").val();
        return flow;
    }
    loadSelector();
})(jQuery);