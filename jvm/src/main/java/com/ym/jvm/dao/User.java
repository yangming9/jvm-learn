package com.ym.jvm.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String sex;
    private Integer score;
}
