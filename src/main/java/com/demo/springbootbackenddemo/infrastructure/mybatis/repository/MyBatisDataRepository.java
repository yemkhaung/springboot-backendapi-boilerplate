package com.demo.springbootbackenddemo.infrastructure.mybatis.repository;

import java.util.Optional;

import com.demo.springbootbackenddemo.application.entity.domain.DataObject;
import com.demo.springbootbackenddemo.application.repository.DataRepository;
import com.demo.springbootbackenddemo.infrastructure.mybatis.mapper.DataMapper;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MyBatisDataRepository implements DataRepository {
    private DataMapper dataMapper;

    public MyBatisDataRepository(DataMapper articleMapper) {
        this.dataMapper = articleMapper;
    }

    @Override
    @Transactional
    public void save(DataObject data) {
        if (dataMapper.findById(data.getId()) == null) {
            createNew(data);
        } else {
            dataMapper.update(data);
        }
    }

    private void createNew(DataObject data) {
        // addtional data preparation if necessary
        dataMapper.insert(data);
    }

    @Override
    public DataObject findById(String id) {
        return dataMapper.findById(id);
    }

    @Override
    public DataObject findByTitle(String title) {
        return dataMapper.findByTitle(title);
    }

    @Override
    public void remove(DataObject data) {
        dataMapper.delete(data.getId());
    }
}