package com.demo.springbootbackenddemo.infrastructure.mybatis.repository;

import java.util.List;

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
    public List<DataObject> index() {
        return this.dataMapper.index();
    }

    @Override
    @Transactional
    public void save(DataObject data) {
        if (this.dataMapper.findById(data.getId()) == null) {
            createNew(data);
        } else {
            this.dataMapper.update(data);
        }
    }

    private void createNew(DataObject data) {
        // addtional data preparation if necessary
        this.dataMapper.insert(data);
    }

    @Override
    public DataObject findById(String id) {
        return this.dataMapper.findById(id);
    }

    @Override
    public DataObject findByTitle(String title) {
        return this.dataMapper.findByTitle(title);
    }

    @Override
    public void remove(DataObject data) {
        this.dataMapper.delete(data.getId());
    }
}