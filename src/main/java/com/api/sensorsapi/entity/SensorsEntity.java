package com.api.sensorsapi.entity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class SensorsEntity {

    @NotBlank
    @NotNull
    private String source;
    @NotNull
    @NotBlank
    @JSONField(name = "distinctId")
    private String distinctId;
    @NotNull
    @JSONField(name = "login")
    private Boolean login;
    @NotNull
    @JSONField(name = "properties")
    private JSONObject properties;
    @NotNull
    @NotBlank
    private String event;
}
