package com.api.sensorsapi.controller;


import com.api.sensorsapi.config.baseResult.Result;
import com.api.sensorsapi.dao.mongodb.PresetDao;
import com.api.sensorsapi.dao.mongodb.UserAppListDao;
import com.api.sensorsapi.entity.mongodb.PresetEntity;
import com.api.sensorsapi.entity.SensorsEntity;
import com.api.sensorsapi.entity.mongodb.UserAppEntity;
import com.api.sensorsapi.service.SensorsService;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashMap;

@RestController
@Validated
@RequestMapping("/sensors")
@Slf4j
public class SensorsController {
    @Resource
    SensorsService sensorsService;
    @Resource
    PresetDao presetMongo;
    @Resource
    UserAppListDao userAppMongo;
    @PostMapping("/relevance")
    public Result <Object> relevance(@RequestBody SensorsEntity sensorsVo) {
        String topic = sensorsVo.getSource();
        topic += "_sensors";
        // 异步处理
        sensorsService.process(topic,sensorsVo);
        return Result.builder()
                .code(100)
                .msg("success")
                .data(topic)
                .success(true)
                .build();
    }

    @PostMapping("/pre_set")
    public Result<Object> preset(@RequestBody PresetEntity presetVo){
        String apiKey = presetVo.getApiKey();
        PresetEntity pre =  presetMongo.findByField("apiKey" , apiKey);
        System.out.println(pre);
        if(pre != null){
            presetVo.setId(pre.getId());
            presetMongo.update(presetVo);
        }else{
            presetVo.setCreateTime(new Date().getTime());
            presetMongo.save(presetVo);
        }
        return Result.builder()
                .code(100)
                .msg("success")
                .data(presetVo)
                .success(true)
                .build();
    }
    @PostMapping("/pre_get")
    public Result<Object> preGet(@NotBlank @NotNull String apiKey){
        PresetEntity presetInfo = presetMongo.findByField("apiKey" , apiKey);
        return Result.builder()
                .code(100)
                .msg("success")
                .data(presetInfo)
                .success(true)
                .build();
    }

    @PostMapping("/user_app")
    public Result<Object> userApp(@RequestBody UserAppEntity userAppVo){
        HashMap map = new HashMap();
        map.put("staffId",userAppVo.getStaffId());
        if(userAppVo.getEquipmentId() != null & !StringUtils.isBlank(userAppVo.getEquipmentId())){
            map.put("equipmentId" , userAppVo.getEquipmentId());
        }
        if(userAppVo.getDeviceId() != null & !StringUtils.isBlank(userAppVo.getDeviceId())){
            map.put("deviceId" , userAppVo.getDeviceId());
        }
        UserAppEntity appList = userAppMongo.findByField(map);
        System.out.println(appList);
        if(appList != null){
            userAppVo.setId(appList.getId());
            userAppMongo.update(userAppVo);
        }else{
            userAppMongo.save(userAppVo);
        }
        return Result.builder()
                .code(100)
                .msg("success")
                .data(appList)
                .success(true)
                .build();
    }
}
