package com.demo.springbootbackenddemo.application.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import com.demo.springbootbackenddemo.application.entity.domain.DataObject;
import com.demo.springbootbackenddemo.application.entity.dto.DataDto;
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

    public Optional<List<DataDto>> index() {
        List<DataDto> dataList = this.dataRepository.index()
            .stream()
            .filter(Objects::nonNull)
            .map(this::convertToDto)
            .collect(Collectors.toList());

        if (dataList.size() < 1) {
            return Optional.empty();
        } else {
            return Optional.of(dataList);
        }
    }

    public Optional<DataDto> findById(String id) {
        DataObject dataObj = this.dataRepository.findById(id);
        if (dataObj == null) {
            return Optional.empty();  
        } else {
            return Optional.of(convertToDto(dataObj));
        }
    }

    private DataDto convertToDto(DataObject dataObj) {
        return new DataDto(){{
            this.setId(dataObj.getId());
            this.setDataId(dataObj.getDataId());
            this.setTitle(dataObj.getTitle());
            this.setDescription(dataObj.getDescription());
            this.setCreatedAt(dataObj.getCreatedAt().toString("YYYY MMM dd, hh:mm a"));
            this.setUpdatedAt(dataObj.getUpdatedAt().toString("YYYY MMM dd, hh:mm a"));
        }};
    }
}