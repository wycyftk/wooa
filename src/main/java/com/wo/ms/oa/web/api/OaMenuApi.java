package com.wo.ms.oa.web.api;

import com.wo.ms.oa.dto.OaMenuDto;
import com.wo.ms.oa.entity.OaMenu;
import com.wo.ms.oa.entity.OaOrg;
import com.wo.ms.oa.services.OaMenuService;
import com.wo.ms.oa.services.OaOrgService;
import com.wo.ms.oa.util.WebUtil;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/oa/api/menu")
public class OaMenuApi {
    @Resource
    private OaMenuService oaMenuService;

    @Resource
    private WebUtil webUtil;

    @PostMapping("/add")
    public Map<String, Object> addOrg(@RequestBody OaMenuDto oaMenu){
        Date now = new Date();
        Map<String, Object> result = new HashMap<>();

        //如果没有选择父节点，默认选中根节点，并作为其子节点
        if(oaMenu.getChooseMenuId() == null){
            oaMenu.setChooseMenuId(oaMenuService.selectRootMenu().getId());
            oaMenu.setRelation(3);
        }
        oaMenu.setCreateId(webUtil.getLoginId());
        oaMenu.setCreateTime(now);
        oaMenu.setUpdateId(webUtil.getLoginId());
        oaMenu.setUpdateTime(now);
        oaMenu.setDelFlg(0);
        oaMenuService.insertMenu(oaMenu);
        result.put("status", true);
        result.put("message", "新增菜单成功");
        return result;
    }

    @PutMapping("/update")
    public Map<String, Object> updateMenu(@RequestBody OaMenu oaMenu){
        Map<String, Object> result = new HashMap<>();
        oaMenu.setUpdateId(webUtil.getLoginId());
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

    @GetMapping("/subMenu")
    public Map<String, Object> selectSubOrg(Integer id){
        Map<String, Object> result = new HashMap<>();
        List<OaMenu> oaMenuList = oaMenuService.selectSubMenu(id);
        result.put("status", true);
        result.put("message", "查找子菜单成功");
        result.put("data", oaMenuList);
        return result;
    }
}
