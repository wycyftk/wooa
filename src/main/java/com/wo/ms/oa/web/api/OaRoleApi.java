package com.wo.ms.oa.web.api;

import com.wo.ms.oa.entity.OaRole;
import com.wo.ms.oa.entity.UserRole;
import com.wo.ms.oa.services.OaRoleService;
import com.wo.ms.oa.util.WebUtil;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/oa/api/role")
public class OaRoleApi {
    @Resource
    private OaRoleService oaRoleService;

    @Resource
    private WebUtil webUtil;

    @PostMapping("/add")
    public Map<String, Object> addRole(@RequestBody OaRole role){
        Date now = new Date();
        Map<String, Object> result = new HashMap<>();

        role.setCreateId(webUtil.getLoginId());
        role.setCreateTime(now);
        role.setUpdateId(webUtil.getLoginId());
        role.setUpdateTime(now);
        oaRoleService.insert(role);
        result.put("status", true);
        result.put("message", "新增角色成功");
        return result;
    }

    @PutMapping("/update")
    public Map<String, Object> updateRole(@RequestBody OaRole role){
        Map<String, Object> result = new HashMap<>();
        role.setUpdateId(webUtil.getLoginId());
        role.setUpdateTime(new Date());
        oaRoleService.updateByPrimaryKeySelective(role);
        result.put("status", true);
        result.put("message", "修改角色成功");
        return result;
    }

    @DeleteMapping("/del")
    public Map<String, Object> deleteRole(Integer id){
        Map<String, Object> result = new HashMap<>();
        oaRoleService.deleteByPrimaryKey(id);
        result.put("status", true);
        result.put("message", "删除角色成功");
        return result;
    }

    @GetMapping("/getRolesById")
    public Map<String, Object> getRoleList(Integer userId){
        Map<String, Object> result = new HashMap<>();
        try{
            List<Map<String, Object>> roleList = oaRoleService.selectUserRole(userId);
            result.put("status", true);
            result.put("data", roleList);
        } catch (Exception e){
            e.printStackTrace();
            result.put("status", false);
            result.put("message", "查询角色出错");
        }
        return result;
    }

    @PostMapping("/assginRole")
    public Map<String, Object> assginRole(@RequestBody List<UserRole> userRoles){
        Map<String, Object> result = new HashMap<>();
        try{
            if(userRoles.size() > 0){
                oaRoleService.delUserRole(userRoles.get(0).getUserId());
                for(UserRole userRole : userRoles){
                    oaRoleService.assginRole(userRole);
                }
            }
            result.put("status", true);
            result.put("message", "角色分配成功");
        } catch (Exception e){
            e.printStackTrace();
            result.put("status", false);
            result.put("message", "角色分配出错");
        }
        return result;
    }
}
