package com.api.sensorsapi.entity.mongodb;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Validated
@Document("SensorsPresetProperties")
public class PresetEntity {
    private String id;
    private String agent;
    private long createTime;
    @NotNull
    @NotBlank
    private String apiKey;
    @NotNull
    @NotBlank
    private String preInfo;
    private String userId;
    private long updateTime;
}
