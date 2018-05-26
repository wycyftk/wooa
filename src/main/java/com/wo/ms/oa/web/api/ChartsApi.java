package com.wo.ms.oa.web.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/oa/api/charts")
public class ChartsApi {
    @GetMapping("/data")
    public Map<String, Object> getChartsData() {
        Map<String, Object> result = new HashMap<>();
        return result;
    }
}
