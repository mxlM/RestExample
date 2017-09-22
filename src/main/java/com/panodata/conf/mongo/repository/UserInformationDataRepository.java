package com.panodata.conf.mongo.repository;

import com.panodata.conf.mongo.model.UserInformationData;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * 每一个Repository 的类，对应mongodb中的一个 collection  (表)
 *
 * MongoRepository<UserInformationData, String> 中的 UserInformationData类表示该表中存储数据的结构
 *
 * 当然这个只是封装的，如果有个性化的需求，也欢迎直接使用原生的MongoTemplate
 * Created by wp_sp on 2017/3/29.
 */
public interface UserInformationDataRepository extends MongoRepository<UserInformationData, String> {

}
