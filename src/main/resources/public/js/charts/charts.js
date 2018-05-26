(function ($) {
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
                data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
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
                data:[5, 10, 12, 23, 25, 20, 30, 40, 30, 10, 6, 10],
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
                data:[5, 10, 12, 23, 25, 20, 30, 40, 30, 10, 6, 10],
                markPoint : {
                    data : [
                        {name : '年最高', value : 182.2, xAxis: 7, yAxis: 183},
                        {name : '年最低', value : 2.3, xAxis: 11, yAxis: 3}
                    ]
                }
            }
        ]
    };

    myChart.setOption(option);
})(jQuery)