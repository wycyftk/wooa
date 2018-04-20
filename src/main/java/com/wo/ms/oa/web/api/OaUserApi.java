package com.wo.ms.oa.web.api;

import com.wo.ms.oa.entity.OaUser;
import com.wo.ms.oa.services.OaUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @PostMapping("/addUser")
    public Map<String, Object> addUser(@RequestBody OaUser oaUser){
        Map<String, Object> result = new HashMap<>();
        Date now = new Date();
        oaUser.setCreateId(1);
        oaUser.setCreateTime(now);
        oaUser.setUpdateId(1);
        oaUser.setUpdateTime(now);
        oaUser.setDelFlg(0);
        oaUserService.addOaUser(oaUser);
        result.put("status", true);
        result.put("message", "添加成功");
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
        oaUser.setUpdateId(1);
        oaUser.setUpdateTime(now);
        oaUserService.updateOaUser(oaUser);
        result.put("status", true);
        result.put("message", "修改成功");
        return result;
    }
}
