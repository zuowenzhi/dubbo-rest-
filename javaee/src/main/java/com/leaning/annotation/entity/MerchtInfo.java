package com.leaning.annotation.entity;

import com.leaning.annotation.annotation.DataTransForm;
import com.leaning.annotation.strategy.BankCardStargy;
import lombok.Data;

/**
 * @author: zuowenzhi 2023/6/21 created
 * @Description: com.leaning.annotation.entity
 * @version: 1.0
 */
@Data
public class MerchtInfo {
    @DataTransForm(isDesensitize = true,isEncipher = true,encipherFieldName = "bankcardNoEnc",stargy = BankCardStargy.class)
    private String bankcardNo ;
}


