package com.demo.springbootbackenddemo.application.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.springbootbackenddemo.application.entity.domain.DataObject;
import com.demo.springbootbackenddemo.application.exception.ResourceNotFoundException;
import com.demo.springbootbackenddemo.application.service.DataQueryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sample API Controller
 * 
 * @author yemkhaung
 */
@RestController
@RequestMapping(path = "/data")
public class DataApi {

    private DataQueryService dataQueryService;

    @Autowired
    public DataApi(DataQueryService dataQuertService) {
        this.dataQueryService = dataQuertService;
    }

    @RequestMapping(path = "")
    public ResponseEntity<?> index() {
        return this.dataQueryService.index()
            .map(dataList -> ResponseEntity.ok(dataListResponse(dataList)))
            .orElseThrow(ResourceNotFoundException::new);
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<?> detail(@PathVariable("id") String id) {
        return this.dataQueryService.findById(id)
            .map(dataObj -> ResponseEntity.ok(dataResponse(dataObj)))
            .orElseThrow(ResourceNotFoundException::new);
    }

    private Map<String, Object> dataResponse(DataObject dataObj) {
        return new HashMap<String, Object>() {{
            put("data", dataObj);
        }};
    }

    private Map<String, Object> dataListResponse(List<DataObject> dataList) {
        return new HashMap<String, Object>() {{
            put("dataList", dataList);
        }};
    }

}