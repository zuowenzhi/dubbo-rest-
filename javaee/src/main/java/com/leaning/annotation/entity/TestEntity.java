package com.leaning.annotation.entity;

import com.leaning.annotation.annotation.DataTransFormClass;
import com.leaning.annotation.annotation.DataTransFormList;
import com.leaning.stream.User;
import lombok.Data;

import java.util.List;

/**
 * @author: zuowenzhi 2023/6/21 created
 * @Description: com.leaning
 * @version: 1.0
 */
@Data
public class TestEntity {

    @DataTransFormClass
    private UserInfo user;
    @DataTransFormList
    private List<MerchtInfo> merchtInfoList;

}


