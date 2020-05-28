package com.api.sensorsapi.service;

import com.api.sensorsapi.entity.SensorsEntity;

public interface SensorsService{
     void process(String topic , SensorsEntity sensorsVo);
}
