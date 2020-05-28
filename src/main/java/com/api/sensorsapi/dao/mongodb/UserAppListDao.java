package com.api.sensorsapi.dao.mongodb;


import com.api.sensorsapi.entity.mongodb.PresetEntity;
import com.api.sensorsapi.entity.mongodb.UserAppEntity;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import java.util.HashMap;

public interface UserAppListDao {
    UserAppEntity save(UserAppEntity userAppEntity);

    DeleteResult remove(Long id);

    UpdateResult update(UserAppEntity userAppEntity);

    UserAppEntity findById(Long id);

    UserAppEntity findByField(String field , String value);

    UserAppEntity findByField(HashMap<String , String> map);
}
