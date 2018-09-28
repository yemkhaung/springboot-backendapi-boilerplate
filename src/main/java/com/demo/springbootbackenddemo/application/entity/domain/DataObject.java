package com.demo.springbootbackenddemo.application.entity.domain;

import org.joda.time.DateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Sample Data object
 * 
 * @author yemkhaung
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataObject {
    private String id;
    private String dataId;
    private String title;
    private String description;
    private DateTime createdAt;
    private DateTime updatedAt;
}