package com.wo.ms.oa.web.api;

import com.wo.ms.oa.entity.OaInfo;
import com.wo.ms.oa.services.OaInfoService;
import com.wo.ms.oa.util.WebUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/oa/api/info")
public class OaInfoApi {
    @Resource
    private OaInfoService oaInfoService;

    @Resource
    private WebUtil webUtil;

    @PostMapping("/add")
    public Map<String, Object> addInfo(@RequestBody OaInfo oaInfo){
        Map<String, Object> result = new HashMap<>();
        Date now = new Date();
        oaInfo.setUpdateId(webUtil.getLoginId());
        oaInfo.setUpdateTime(now);
        oaInfo.setCreateId(webUtil.getLoginId());
        oaInfo.setCreateTime(now);
        oaInfo.setDelFlg(0);
        //todo 查询当前登录人的部门
        oaInfoService.insert(oaInfo);
        result.put("status", true);
        result.put("message", "信息发布成功");
        return result;
    }
}
