(function ($) {
    function init() {
        $.ajax({
            url: '/oa/api/charts/data',
            type: 'get',
            dateType: 'json',
            success: function (data) {
                var meeting = dealData(data.meeting);
                var useCar = dealData(data.useCar);
                initCharts(meeting, useCar);
            },
            error: function (data) {

            }
        })
    }

    function dealData(data) {
        var dataArr = new Array();
        var i = 0;
        var fiveDayOver = 0;
        for ( i; i < 7; i++) {
            for (var j = 0; j < data.length; j++) {
                if (data[j].dd == i && i < 6) {
                    dataArr[i] = data[j].ct;
                } else if (data[j].dd > 5) {
                    fiveDayOver += data[j].ct;
                } else {
                    dataArr[i] = 0
                }
            }
        }
        dataArr.push(fiveDayOver);
        return dataArr;
    }

    function initCharts(meeting, useCar) {
        var myChart = echarts.init(document.getElementById('charts'));
        var option = {
            title : {
                text: '会议室与车辆使用情况统计',
            },
            tooltip : {
                trigger: 'axis'
            },
            legend: {
                data:['会议室','车辆']
            },
            toolbox: {
                show : true,
                feature : {
                    dataView : {show: true, readOnly: false},
                    magicType : {show: true, type: ['line', 'bar']},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            calculable : true,
            xAxis : [
                {
                    type : 'category',
                    data : ['1天内','1天','2天','3天','4天','5天','5天以上']
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'会议室',
                    type:'bar',
                    data:meeting,
                    markPoint : {
                        data : [
                            {type : 'max', name: '最大值'},
                            {type : 'min', name: '最小值'}
                        ]
                    }
                },
                {
                    name:'车辆',
                    type:'bar',
                    data:useCar,
                    markPoint : {
                        data : [
                            {type : 'max', name: '最大值'},
                            {type : 'min', name: '最小值'}
                        ]
                    }
                }
            ]
        };

        myChart.setOption(option);
    }

    init();
})(jQuery)