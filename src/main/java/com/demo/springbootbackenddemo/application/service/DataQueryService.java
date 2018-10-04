package com.demo.springbootbackenddemo.application.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import com.demo.springbootbackenddemo.application.entity.domain.DataObject;
import com.demo.springbootbackenddemo.application.repository.DataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataQueryService {

    private DataRepository dataRepository;

    @Autowired
    public DataQueryService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public Optional<List<DataObject>> index() {
        List<DataObject> dataList = this.dataRepository.index()
            .stream()
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

        if (dataList.size() < 1) {
            return Optional.empty();
        } else {
            return Optional.of(dataList);
        }
    }

    public Optional<DataObject> findById(String id) {
        DataObject dataObj = this.dataRepository.findById(id);
        if (dataObj == null) {
            return Optional.empty();  
        } else {
            return Optional.of(dataObj);
        }
    }
}