package com.wo.ms.oa.web.api;

import com.wo.ms.oa.entity.OaUser;
import com.wo.ms.oa.services.OaUserService;
import com.wo.ms.oa.util.WebUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户数据接口
 */
@RestController
@RequestMapping("/oa/api/user")
public class OaUserApi {
    @Resource
    private OaUserService oaUserService;

    @Resource
    private WebUtil webUtil;

    /**
     * 新增用户
     * @param oaUser 用户
     * @param request
     * @return
     */
    @PostMapping("/addUser")
    public Map<String, Object> addUser(@RequestBody OaUser oaUser, HttpServletRequest request){
        Map<String, Object> result = new HashMap<>();
        Date now = new Date();
        Integer loginId = webUtil.getLoginId();

        oaUser.setCreateId(loginId);
        oaUser.setCreateTime(now);
        oaUser.setUpdateId(loginId);
        oaUser.setUpdateTime(now);
        oaUser.setDelFlg(0);
        int addNum = oaUserService.addOaUser(oaUser);
        if(addNum > 0){
            result.put("status", true);
            result.put("message", "添加成功");
        }else if(addNum == -1){
            result.put("status", false);
            result.put("message", "用户名重复");
        }else{
            result.put("status", false);
            result.put("message", "添加失败");
        }
        return result;
    }

    @DeleteMapping("/del")
    public Map<String, Object> delUser(Integer id){
        Map<String, Object> result = new HashMap<>();
        oaUserService.deleteOaUser(id);
        result.put("status", true);
        result.put("message", "删除成功");
        return result;
    }

    @PutMapping("/update")
    public Map<String, Object> updateUser(@RequestBody OaUser oaUser){
        Map<String, Object> result = new HashMap<>();
        Date now = new Date();
        oaUser.setUpdateId(webUtil.getLoginId());
        oaUser.setUpdateTime(now);
        oaUserService.updateOaUser(oaUser);
        result.put("status", true);
        result.put("message", "修改成功");
        return result;
    }
}
