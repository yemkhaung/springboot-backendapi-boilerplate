package com.demo.springbootbackenddemo.application.repository;

import java.util.List;
import java.util.Optional;

import com.demo.springbootbackenddemo.application.entity.domain.DataObject;

/**
 * Sample Data Repository
 * 
 * @author yemkhaung
 */
public interface DataRepository {

    void save(DataObject data);

    List<DataObject> index();

    DataObject findById(String id);

    DataObject findByTitle(String title);

    void remove(DataObject data);
}