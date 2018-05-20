(function ($) {
    $('#submitMeetingRoom').click(function () {
        var meetingRoom = getMeeringRoom();
        if(meetingRoom.id){
            $.ajax({
                url: '/oa/api/meetingRoom/update',
                data: JSON.stringify(meetingRoom),
                dataType: 'json',
                type: 'put',
                contentType: 'application/json;charset=utf-8',
                success: function (data) {
                    alert("编辑成功");
                    loadHtml('/oa/meetingRoom/list', {pageSize: 10, currentPage: 1});
                },
                error: function (data) {

                }
            });
        }else {
            $.ajax({
                url: '/oa/api/meetingRoom/add',
                data: JSON.stringify(meetingRoom),
                dataType: 'json',
                type: 'post',
                contentType: 'application/json;charset=utf-8',
                success: function (data) {
                    alert("新增成功");
                    loadHtml('/oa/meetingRoom/list', {pageSize: 10, currentPage: 1});
                },
                error: function (data) {

                }
            });
        }
    });
    
    function getMeeringRoom() {
        var meetingRoom = {};
        meetingRoom.id = $("#id").val();
        meetingRoom.meetingRoom = $("#meetingRoom").val();
        meetingRoom.size = $("#size option:selected").val();
        return meetingRoom;
    }
})(jQuery);