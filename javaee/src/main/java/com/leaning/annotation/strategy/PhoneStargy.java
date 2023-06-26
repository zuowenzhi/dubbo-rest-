package com.leaning.annotation.strategy;

import com.leaning.annotation.util.DesensitizationUtil;
import org.springframework.stereotype.Component;

/**
 * @author:
 * @description: 手机号脱敏类 规则前3 后4 中间*
 */
@Component
public class PhoneStargy  implements TransformStargy<String> {

    @Override
    public String transFrom(String args) {
        return DesensitizationUtil.around(args,3,4);
    }
}
