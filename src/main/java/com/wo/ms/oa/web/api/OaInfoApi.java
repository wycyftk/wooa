package com.wo.ms.oa.web.api;

import com.wo.ms.oa.entity.OaInfo;
import com.wo.ms.oa.entity.OaUser;
import com.wo.ms.oa.entity.UserAndInfo;
import com.wo.ms.oa.services.OaInfoService;
import com.wo.ms.oa.services.OaUserService;
import com.wo.ms.oa.util.WebUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("/oa/api/info")
public class OaInfoApi {
    @Resource
    private OaInfoService oaInfoService;

    @Resource
    private OaUserService oaUserService;

    @Resource
    private WebUtil webUtil;

    @PostMapping("/add")
    public Map<String, Object> addInfo(@RequestBody OaInfo oaInfo){
        Map<String, Object> result = new HashMap<>();
        Date now = new Date();
        List<UserAndInfo> userAndInfos = new ArrayList<>();
        List<Integer> userIds = new ArrayList<>();
        Integer orgId = 0;
        oaInfo.setUpdateId(webUtil.getLoginId());
        oaInfo.setUpdateTime(now);
        oaInfo.setCreateId(webUtil.getLoginId());
        oaInfo.setCreateTime(now);
        oaInfo.setDelFlg(0);
        if(oaInfo.getOrgId() == 1){
            orgId = oaUserService.selectOrgIdByUserId(webUtil.getLoginId());
            userIds = oaUserService.selectUserIdByOrgId(orgId);
        } else {
            userIds = oaUserService.selectAllUserId();
        }
        oaInfo.setOrgId(orgId);
        oaInfo.setPublishId(webUtil.getLoginId());
        oaInfo.setStatus(1);
        oaInfoService.publishInfo(oaInfo, userIds);
        result.put("status", true);
        result.put("message", "信息发布成功");
        return result;
    }

    @PutMapping("/update")
    public Map<String, Object> update(@RequestBody OaInfo oaInfo){
        Map<String, Object> result = new HashMap<>();
        Date now = new Date();
        oaInfo.setUpdateId(webUtil.getLoginId());
        oaInfo.setUpdateTime(now);
        if(oaInfo.getOrgId() == 1){
            Integer orgId = oaUserService.selectOrgIdByUserId(webUtil.getLoginId());
            oaInfo.setOrgId(orgId);
        }
        oaInfo.setPublishId(webUtil.getLoginId());
        oaInfo.setStatus(1);
        oaInfoService.updateByPrimaryKeySelective(oaInfo);
        result.put("status", true);
        result.put("message", "信息编辑成功");
        return result;
    }

    @DeleteMapping("/del")
    public Map<String, Object> delete(@RequestParam("id") Integer id){
        Map<String, Object> result = new HashMap<>();
        oaInfoService.deleteByPrimaryKey(id);
        result.put("status", true);
        result.put("message", "信息删除成功");
        return result;
    }
}
