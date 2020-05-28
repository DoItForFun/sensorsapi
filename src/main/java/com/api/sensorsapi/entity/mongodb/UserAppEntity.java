package com.api.sensorsapi.entity.mongodb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("userAppList")
public class UserAppEntity {
    private String id;
    private String app;
    private long createTime;
    private String equipmentId;
    private String deviceId;
    private String staffId;
    private long updateTime;
}
