package com.wo.ms.oa.web.api;

import com.wo.ms.oa.entity.OaCar;
import com.wo.ms.oa.services.OaCarService;
import com.wo.ms.oa.util.WebUtil;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/oa/api/car")
public class OaCarApi {
    @Resource
    private OaCarService oaCarService;

    @Resource
    private WebUtil webUtil;

    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody OaCar oaCar){
        Map<String, Object> result = new HashMap<>();
        Date now = new Date();
        oaCar.setCreateId(webUtil.getLoginId());
        oaCar.setUpdateId(webUtil.getLoginId());
        oaCar.setStatus(0);
        oaCar.setCreateTime(now);
        oaCar.setUpdateTime(now);
        try{
            oaCarService.insert(oaCar);
            result.put("status", true);
            result.put("message", "新增车辆成功");
        }catch (Exception e){
            e.printStackTrace();
            result.put("status", false);
            result.put("message", "系统发生错误");
        }
        return result;
    }

    @PutMapping("/update")
    public Map<String, Object> update(@RequestBody OaCar oaCar) {
        Map<String, Object> result = new HashMap<>();
        Date now = new Date();
        oaCar.setUpdateTime(now);
        oaCar.setUpdateId(webUtil.getLoginId());
        try{
            oaCarService.updateByPrimaryKeySelective(oaCar);
            result.put("status", true);
            result.put("message", "修改车辆信息成功");
        } catch (Exception e){
            e.printStackTrace();
            result.put("status", false);
            result.put("message", "修改失败");
        }
        return result;
    }

    @DeleteMapping("/del")
    public Map<String, Object> del(@RequestParam Integer id) {
        Map<String, Object> result = new HashMap<>();
        Date now = new Date();
        try{
            oaCarService.deleteByPrimaryKey(id);
            result.put("status", true);
            result.put("message", "删除车辆信息成功");
        } catch (Exception e){
            e.printStackTrace();
            result.put("status", false);
            result.put("message", "删除失败");
        }
        return result;
    }

    @GetMapping("/carList")
    public Map<String, Object> carList(){
        Map<String, Object> result = new HashMap<>();
        List<OaCar> carList = oaCarService.selectCanUseCar();
        if(carList.size() > 0){
            result.put("status", true);
            result.put("data", carList);
        } else {
            result.put("status", false);
            result.put("message", "没有可用车辆");
        }
        return result;
    }
}
