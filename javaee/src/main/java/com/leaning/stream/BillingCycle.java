

package com.leaning.stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author huangchangke
 * 结算周期
 */

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BillingCycle {
    /**
     *  结算周期    D0实时
     * */
    D0("D0", "D0实时"),
    /**
     *  结算周期    D1结算
     * */
    D1("D1", "D1结算"),
    /**
     *  结算周期    T1结算
     * */
    T1("T1", "T1结算"),
    /**
     *  结算周期    D0定点 netting RealRefund
     * */
    DD("DD", "D0定点"),
    ;

    private final String code;
    private final String name;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static BillingCycle getInstance(String code) {
        if (code == null) {
            return null;
        }
        return Arrays.stream(BillingCycle.values()).filter(stairType -> Objects.equals(stairType.getCode(), code)).findAny().orElse(null);
    }
}
