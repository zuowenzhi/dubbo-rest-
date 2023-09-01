
package com.leaning.stream;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * @author
 * 卡状态
 */
public enum CardStatus {
    /**PRE_SALE:预个人化*/
    PRE_SALE("PRE_SALE","预个人化"),
    /**CARD_SALED:已售出*/
    CARD_SALED("CARD_SALED","已售出"),
    /**NORMAL:正常*/
    NORMAL("NORMAL","正常"),
    /**CARD_CHANGED:已换卡*/
    CARD_CHANGED("CARD_CHANGED","已换卡"),
    /**CARD_LOST:已挂失*/
    CARD_LOST("CARD_LOST","已挂失"),
    /**CARD_CANCEL:已注销*/
    CARD_CANCEL("CARD_CANCEL","已注销"),
    /**CARD_DAMAGED:损卡*/
    CARD_DAMAGED("CARD_DAMAGED","损卡"),
    ;

    @EnumValue
    @JsonValue
    private String value;
    private String desc;

    private CardStatus(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }

    public static CardStatus valuesOf(String value) {
        return Arrays.stream(CardStatus.values()).filter(s->s.value == value).findFirst().get();
    }
}
