package com.wo.ms.oa.web.api;

import com.wo.ms.oa.entity.OaMenu;
import com.wo.ms.oa.entity.OaOrg;
import com.wo.ms.oa.services.OaMenuService;
import com.wo.ms.oa.services.OaOrgService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/oa/api/menu")
public class OaMenuApi {
    @Resource
    private OaMenuService oaMenuService;

    @PostMapping("/add")
    public Map<String, Object> addOrg(@RequestBody OaMenu oaMenu){
        Date now = new Date();
        Map<String, Object> result = new HashMap<>();

        oaMenu.setCreateId(1);
        oaMenu.setCreateTime(now);
        oaMenu.setUpdateId(1);
        oaMenu.setUpdateTime(now);
        oaMenu.setDelFlg(0);
        oaMenuService.insert(oaMenu);
        result.put("status", true);
        result.put("message", "新增菜单成功");
        return result;
    }

    @PutMapping("/update")
    public Map<String, Object> updateMenu(@RequestBody OaMenu oaMenu){
        Map<String, Object> result = new HashMap<>();
        oaMenu.setUpdateId(1);
        oaMenu.setUpdateTime(new Date());
        oaMenuService.updateByPrimaryKeySelective(oaMenu);
        result.put("status", true);
        result.put("message", "修改菜单成功");
        return result;
    }

    @Delete("/delete")
    public Map<String, Object> deleteMenu(Integer id){
        Map<String, Object> result = new HashMap<>();
        oaMenuService.deleteByPrimaryKey(id);
        result.put("status", true);
        result.put("message", "删除菜单成功");
        return result;
    }
}
