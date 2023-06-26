package com.leaning.annotation.strategy;

import com.leaning.annotation.util.DesensitizationUtil;
import org.springframework.stereotype.Component;

/**
 * @author:
 * @description: 姓名 规则 长度小于3位 前1 后面*，长度大于等于3 前1 后1 中间*
 */
@Component
public class IdNameStargy implements TransformStargy<String> {

    @Override
    public String transFrom(String args) {

        if (args.length() < 3) {
            return DesensitizationUtil.left(args, 1);
        } else {
            return DesensitizationUtil.around(args, 1, 1);
        }
    }
}
