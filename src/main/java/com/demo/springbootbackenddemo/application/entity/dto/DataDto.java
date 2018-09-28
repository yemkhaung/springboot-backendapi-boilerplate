package com.demo.springbootbackenddemo.application.entity.dto;

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
public class DataDto {
    private String id;
    private String dataId;
    private String title;
    private String description;
    private String createdAt;
    private String updatedAt;
}