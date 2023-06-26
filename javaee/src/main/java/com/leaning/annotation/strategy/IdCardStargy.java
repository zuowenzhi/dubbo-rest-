
package com.leaning.annotation.strategy;

import com.leaning.annotation.util.DesensitizationUtil;
import org.springframework.stereotype.Component;

/**
 * @author:
 * @description: 身份证脱敏类 规则前1 后1 中间*
 */
@Component
public class IdCardStargy implements TransformStargy<String> {
    @Override
    public String transFrom(String args) {
        return DesensitizationUtil.around(args,1,1);
    }
}
