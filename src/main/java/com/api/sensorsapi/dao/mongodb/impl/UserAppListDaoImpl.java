package com.api.sensorsapi.dao.mongodb.impl;

import com.api.sensorsapi.dao.mongodb.UserAppListDao;
import com.api.sensorsapi.entity.mongodb.PresetEntity;
import com.api.sensorsapi.entity.mongodb.UserAppEntity;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserAppListDaoImpl implements UserAppListDao {
    @Resource
    private MongoTemplate mongoTemplate;

    public UserAppEntity save(UserAppEntity userAppEntity) {
        return mongoTemplate.save(userAppEntity);
    }

    @Override
    public DeleteResult remove(Long id) {
        return mongoTemplate.remove(id);
    }

    @Override
    public UpdateResult update(UserAppEntity userAppEntity) {
        Query query = new Query(Criteria.where("_id").is(userAppEntity.getId()));
        Update update = new Update();
        update.set("updateTime", new Date().getTime());
        update.set("app", userAppEntity.getApp());
        return mongoTemplate.updateFirst(query, update, UserAppEntity.class);
    }

    @Override
    public UserAppEntity findById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, UserAppEntity.class);
    }

    @Override
    public UserAppEntity findByField(String field, String value) {
        Query query = new Query(Criteria.where(field).is(value));
        return mongoTemplate.findOne(query, UserAppEntity.class);
    }

    @Override
    public UserAppEntity findByField(HashMap<String , String> map) {

        Criteria criteria = new Criteria();
        for(Map.Entry<String , String> entry : map.entrySet()){
            criteria.and(entry.getKey()).is(entry.getValue());
        }
        Query query = new Query(criteria);
        return mongoTemplate.findOne(query , UserAppEntity.class);
    }
}
