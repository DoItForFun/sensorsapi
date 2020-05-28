package com.api.sensorsapi.dao.mongodb;

import com.api.sensorsapi.entity.mongodb.PresetEntity;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public interface PresetDao {
    PresetEntity save(PresetEntity presetEntity);

    DeleteResult remove(Long id);

    UpdateResult update(PresetEntity presetEntity);

    PresetEntity findById(Long id);

    PresetEntity findByField(String field , String value);
}
