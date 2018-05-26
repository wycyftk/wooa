package com.wo.ms.oa.web.api;

import com.wo.ms.oa.entity.OaInfo;
import com.wo.ms.oa.entity.OaUser;
import com.wo.ms.oa.entity.UserAndInfo;
import com.wo.ms.oa.services.OaInfoService;
import com.wo.ms.oa.services.OaUserService;
import com.wo.ms.oa.util.WebUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    public Map<String, Object> addInfo(@RequestBody OaInfo oaInfo, HttpServletRequest request){
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
        if("部门消息".equals(oaInfo.getInfoType())){
            userIds = oaUserService.selectUserIdByOrgId(oaInfo.getOrgId());
            orgId = oaInfo.getOrgId();
        } else {
            userIds = oaUserService.selectAllUserId();
            oaInfo.setOrgId(0);
        }
        oaInfo.setPublishId(webUtil.getLoginId());
        oaInfoService.publishInfo(oaInfo, userIds);
        result.put("status", true);
        if(oaInfo.getStatus() == 0){
            result.put("message", "信息已保存");
        } else {
            result.put("message", "信息发布成功");
        }
        return result;
    }

    @PutMapping("/update")
    public Map<String, Object> update(@RequestBody OaInfo oaInfo){
        Map<String, Object> result = new HashMap<>();
        Date now = new Date();
        oaInfo.setUpdateId(webUtil.getLoginId());
        oaInfo.setUpdateTime(now);
        oaInfo.setPublishId(webUtil.getLoginId());
        oaInfoService.updateByPrimaryKeySelective(oaInfo);
        result.put("status", true);
        result.put("message", "信息编辑成功");
        return result;
    }

    @PutMapping("/read")
    public Map<String, Object> read(@RequestParam("infoId") Integer infoId){
        Map<String, Object> result = new HashMap<>();
        Integer loginId = webUtil.getLoginId();
        Integer hasRead = oaInfoService.hasRead(infoId, loginId);
        if(hasRead > 0) {
            result.put("status", true);
            result.put("message", "用户读取消息");
        } else {
            result.put("status", false);
            result.put("message", "该消息已读");
        }
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
