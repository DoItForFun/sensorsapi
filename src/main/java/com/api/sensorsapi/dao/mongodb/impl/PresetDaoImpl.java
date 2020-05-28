package com.api.sensorsapi.dao.mongodb.impl;

import com.api.sensorsapi.dao.mongodb.PresetDao;
import com.api.sensorsapi.entity.mongodb.PresetEntity;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class PresetDaoImpl implements PresetDao {
    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public PresetEntity save(PresetEntity presetEntity) {
        return mongoTemplate.save(presetEntity);
    }

    @Override
    public DeleteResult remove(Long id) {
        return mongoTemplate.remove(id);
    }

    @Override
    public UpdateResult update(PresetEntity presetEntity) {
        Query query = new Query(Criteria.where("id").is(presetEntity.getId()));

        Update update = new Update();
        update.set("updateTime", new Date().getTime());
        update.set("preInfo", presetEntity.getPreInfo());
        return mongoTemplate.updateFirst(query, update, PresetEntity.class);
    }

    @Override
    public PresetEntity findById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, PresetEntity.class);
    }

    @Override
    public PresetEntity findByField(String field, String value) {
        Query query = new Query(Criteria.where(field).is(value));
        return mongoTemplate.findOne(query, PresetEntity.class);
    }
}
