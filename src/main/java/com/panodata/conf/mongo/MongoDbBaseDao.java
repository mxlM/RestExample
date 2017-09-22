package com.panodata.conf.mongo;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Repository 这个注解和 service  controller 等效，只不过Repository一般用作持久层
 * @param <T>
 */
@Repository
public class MongoDbBaseDao<T> {
    @Resource
    private MongoTemplate mongoTemplate;

    //集合,相当于数据库表
    //insert添加 如果有一个相同的_ID时，就会新增失败
    public void insert(T object, String collectionName) {
        mongoTemplate.insert(object, collectionName);
    }

    // save添加 如果有一个相同_ID的文档时，会覆盖原来的
    public void save(T object, String collectionName) {
        mongoTemplate.save(object, collectionName);
    }

    //批量添加
    public void insertAll(List<T> object) {
        mongoTemplate.insertAll(object);
    }

    //根据条件删除
    public void remove(Query query, Class<T> entityClass, String collectionName) {
        mongoTemplate.remove(query, entityClass, collectionName);
    }

    //根据条件删除
    public void removeAll(String collectionName) {
        mongoTemplate.dropCollection(collectionName);
    }

    //删除集合（相当于删除表轻易不要搞）
    public void dropCollection(String collectionName) {
        mongoTemplate.dropCollection(collectionName);
    }

    //根据条件查询该方法返回第一个文档
    public T findOne(Query query, Class<T> entityClass, String collectionName) {
        return mongoTemplate.findOne(query, entityClass, collectionName);
    }

    //根据条件查询
    public List<T> find(Query query, Class<T> entityClass, String collectionName) {
        return mongoTemplate.find(query, entityClass, collectionName);
    }

    List<T> findAll(Class<T> entityClass, String collectionName) {
        return mongoTemplate.findAll(entityClass, collectionName);
    }

    //updateFirst 修改符合条件第一条记录
    public void updateFirst(Query query, Update update, Class<T> entityClass, String collectionName) {
        mongoTemplate.updateFirst(query, update, entityClass, collectionName);
    }

    //updateMulti修改符合条件的所有
    public void updateMulti(Query query, Update update, Class<T> entityClass, String collectionName) {
        mongoTemplate.updateMulti(query, update, entityClass, collectionName);
    }

    //upsert 修改符合条件时如果不存在则添加
    public void upsert(Query query, Update update, String collectionName) {
        mongoTemplate.upsert(query, update, collectionName);
    }
}
