package com.leaning.annotation.strategy;

import com.leaning.annotation.util.DesensitizationUtil;
import org.springframework.stereotype.Component;

/**
 * @author:
 * @description: 银行卡脱敏类 规则前6 后4 中间*
 */
@Component
public class BankCardStargy implements TransformStargy<String> {
    @Override
    public String transFrom(String args) {
        return DesensitizationUtil.around(args, 6, 4);
    }
}
