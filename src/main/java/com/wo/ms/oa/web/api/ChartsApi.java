package com.wo.ms.oa.web.api;

import com.wo.ms.oa.services.OaMeetingService;
import com.wo.ms.oa.services.UseCarRecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/oa/api/charts")
public class ChartsApi {
    @Resource
    private OaMeetingService oaMeetingService;

    @Resource
    private UseCarRecordService useCarRecordService;

    @GetMapping("/data")
    public Map<String, Object> getChartsData(Date start, Date end) {
        Map<String, Object> result = new HashMap<>();
        List<Map<Integer, Integer>> meetingData = oaMeetingService.selectDayAndMeetingNum();
        List<Map<Integer, Integer>> useCarData = useCarRecordService.selectUseCarDayAndNum();
        result.put("meeting", meetingData);
        result.put("useCar", useCarData);
        result.put("status", true);
        return result;
    }
}
