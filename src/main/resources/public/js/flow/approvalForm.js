(function ($) {
    $('#submitFlow').click(function () {
        var flow = getFlow();
        $.ajax({
            url: '/oa/api/flow/approval',
            data: JSON.stringify(flow),
            dataType: 'json',
            type: 'post',
            contentType: 'application/json;charset=utf-8',
            success: function (data) {
                alert("提交成功");
                //loadHtml("/oa/main");
            },
            error: function (data) {

            }
        });
    });
    
    function getFlow() {
        var flow = {};
        flow.flowName = $("#flowName").val();
        flow.flowType = $("#flowType").val();
        flow.flowId = $("#flowId").val();

        if($("#car").val() != null){
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
        flow.opinion = $("#opinion option:selected").val();
        flow.note = $("#note").val();
        flow.startTime = $("#startTime").val();
        flow.endTime = $("#endTime").val();
        return flow;
    }
})(jQuery);