package com.leaning.annotation.entity;

import com.leaning.annotation.annotation.DataTransForm;
import com.leaning.annotation.strategy.IdCardStargy;
import com.leaning.annotation.strategy.IdNameStargy;
import com.leaning.annotation.strategy.PhoneStargy;
import lombok.Data;

/**
 * @author: zuowenzhi 2023/6/21 created
 * @Description: com.leaning.annotation.entity
 * @version: 1.0
 */
@Data
public class UserInfo {

    @DataTransForm(isDesensitize = true,isEncipher = true,encipherFieldName = "agentPersonEnc",stargy = IdNameStargy.class)
    private String username;

    private String password;

    @DataTransForm(isDesensitize = true,isEncipher = true,encipherFieldName = "agentIdNoEnc",stargy = IdCardStargy.class)
    private String idCard;


    @DataTransForm(isDesensitize = true,isEncipher = true,encipherFieldName = "agentMobileEnc",stargy = PhoneStargy.class)
    private String mobilePhone;
}


