package com.leaning.desensitized;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;

@Data
public class TestDTO implements Serializable {
    /**
     * 手机号
     */
    @JsonSerialize(using = TestJacksonSerialize.class)
    private String phone;
}