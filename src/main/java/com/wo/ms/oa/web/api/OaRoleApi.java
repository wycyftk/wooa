package com.wo.ms.oa.web.api;

import com.wo.ms.oa.entity.OaRole;
import com.wo.ms.oa.services.OaRoleService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/oa/api/role")
public class OaRoleApi {
    @Resource
    private OaRoleService oaRoleService;

    @PostMapping("/add")
    public Map<String, Object> addRole(@RequestBody OaRole role){
        Date now = new Date();
        Map<String, Object> result = new HashMap<>();

        role.setCreateId(1);
        role.setCreateTime(now);
        role.setUpdateId(1);
        role.setUpdateTime(now);
        oaRoleService.insert(role);
        result.put("status", true);
        result.put("message", "新增角色成功");
        return result;
    }

    @PutMapping("/update")
    public Map<String, Object> updateRole(@RequestBody OaRole role){
        Map<String, Object> result = new HashMap<>();
        role.setUpdateId(1);
        role.setUpdateTime(new Date());
        oaRoleService.updateByPrimaryKeySelective(role);
        result.put("status", true);
        result.put("message", "修改角色成功");
        return result;
    }

    @Delete("/delete")
    public Map<String, Object> deleteRole(Integer id){
        Map<String, Object> result = new HashMap<>();
        oaRoleService.deleteByPrimaryKey(id);
        result.put("status", true);
        result.put("message", "删除角色成功");
        return result;
    }
}
