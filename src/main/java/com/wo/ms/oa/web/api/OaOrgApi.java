package com.wo.ms.oa.web.api;

import com.wo.ms.oa.entity.OaOrg;
import com.wo.ms.oa.entity.OaRole;
import com.wo.ms.oa.services.OaOrgService;
import com.wo.ms.oa.services.OaRoleService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/oa/api/org")
public class OaOrgApi {
    @Resource
    private OaOrgService oaOrgService;

    @PostMapping("/add")
    public Map<String, Object> addOrg(@RequestBody OaOrg oaOrg){
        Date now = new Date();
        Map<String, Object> result = new HashMap<>();

        oaOrg.setCreateId(1);
        oaOrg.setCreateTime(now);
        oaOrg.setUpdateId(1);
        oaOrg.setUpdateTime(now);
        oaOrg.setDelFlg(0);
        oaOrgService.insert(oaOrg);
        result.put("status", true);
        result.put("message", "新增组织成功");
        return result;
    }

    @PutMapping("/update")
    public Map<String, Object> updateRole(@RequestBody OaOrg org){
        Map<String, Object> result = new HashMap<>();
        org.setUpdateId(1);
        org.setUpdateTime(new Date());
        oaOrgService.updateByPrimaryKeySelective(org);
        result.put("status", true);
        result.put("message", "修改组织成功");
        return result;
    }

    @Delete("/delete")
    public Map<String, Object> deleteRole(Integer id){
        Map<String, Object> result = new HashMap<>();
        oaOrgService.deleteByPrimaryKey(id);
        result.put("status", true);
        result.put("message", "删除组织成功");
        return result;
    }

    @GetMapping("/subOrg")
    public Map<String, Object> selectSubOrg(Integer id){
        Map<String, Object> result = new HashMap<>();
        List<OaOrg> orgList = oaOrgService.selectSubOrg(id);
        result.put("status", true);
        result.put("message", "查找子组织成功");
        result.put("data", orgList);
        return result;
    }
}
