package com.api.sensorsapi.service.impl;

import com.alibaba.fastjson.JSON;
import com.api.sensorsapi.entity.SensorsEntity;
import com.api.sensorsapi.service.SensorsService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
class SensorsServiceImpl implements SensorsService {
    @Resource
    private KafkaTemplate <String, Object> kafkaTemplate;
    @Async
    public void process(String topic , SensorsEntity sensorsVo) {
        //TODO 处理逻辑 写入队列
        String json = JSON.toJSONString(sensorsVo);
        kafkaTemplate.send(topic , json);
    }
}
