package com.wo.ms.oa.web.api;

import com.wo.ms.oa.entity.OaCar;
import com.wo.ms.oa.entity.OaMeetingRoom;
import com.wo.ms.oa.services.OaMeetingRoomService;
import com.wo.ms.oa.services.OaMeetingService;
import com.wo.ms.oa.util.WebUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/oa/api/meetingRoom")
public class OaMeetingRoomApi {
    @Resource
    private OaMeetingRoomService oaMeetingRoomService;

    @Resource
    private WebUtil webUtil;

    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody OaMeetingRoom oaMeetingRoom){
        Map<String, Object> result = new HashMap<>();
        try{
            Date now = new Date();
            oaMeetingRoom.setCreateId(webUtil.getLoginId());
            oaMeetingRoom.setCreateTime(now);
            oaMeetingRoom.setUpdateId(webUtil.getLoginId());
            oaMeetingRoom.setCreateTime(now);
            oaMeetingRoom.setStatus(0);
            oaMeetingRoomService.insert(oaMeetingRoom);
            result.put("status", true);
            result.put("message", "新增会议室成功");
        }catch (Exception e){
            e.printStackTrace();
            result.put("status", false);
            result.put("message", "新增会议室失败");
        }
        return result;
    }

    @PutMapping("/update")
    public Map<String, Object> update(@RequestBody OaMeetingRoom oaMeetingRoom){
        Map<String, Object> result = new HashMap<>();
        try{
            oaMeetingRoomService.updateByPrimaryKeySelective(oaMeetingRoom);
            result.put("status", true);
            result.put("message", "修改会议室成功");
        }catch (Exception e){
            e.printStackTrace();
            result.put("status", false);
            result.put("message", "修改会议室失败");
        }
        return result;
    }

    @DeleteMapping("/del")
    public Map<String, Object> delete(@RequestParam("id") Integer id){
        Map<String, Object> result = new HashMap<>();
        try{
            oaMeetingRoomService.deleteByPrimaryKey(id);
            result.put("status", true);
            result.put("message", "删除会议室成功");
        }catch (Exception e){
            e.printStackTrace();
            result.put("status", false);
            result.put("message", "删除会议室失败");
        }
        return result;
    }

    @GetMapping("/meetingRoomList")
    public Map<String, Object> meetingRoomList(){
        Map<String, Object> result = new HashMap<>();
        List<OaMeetingRoom> meetingRoomList = oaMeetingRoomService.selectCanUseMeetingRoom();
        if(meetingRoomList.size() > 0){
            result.put("status", true);
            result.put("data", meetingRoomList);
        } else {
            result.put("status", false);
            result.put("message", "没有可用车辆");
        }
        return result;
    }
}
