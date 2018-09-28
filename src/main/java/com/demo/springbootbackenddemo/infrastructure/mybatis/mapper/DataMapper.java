package com.demo.springbootbackenddemo.infrastructure.mybatis.mapper;


import java.util.List;

import com.demo.springbootbackenddemo.application.entity.domain.DataObject;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 
 * Sample MyBatis Mapper
 *   create a corresponding mapping.xml in 'resources'
 * 
 * @author yemkhaung
 */
@Component
@Mapper
public interface DataMapper {
    void insert(@Param("data") DataObject article);

    List<DataObject> index();

    DataObject findById(@Param("id") String id);

    DataObject findByTitle(@Param("title") String title);

    void update(@Param("data") DataObject article);

    void delete(@Param("id") String id);
}