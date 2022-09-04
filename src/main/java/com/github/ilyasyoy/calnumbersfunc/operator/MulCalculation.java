package com.github.ilyasyoy.calnumbersfunc.operator;

import com.github.ilyasyoy.calnumbersfunc.base.Calculation;
import lombok.NonNull;

public class MulCalculation extends BaseOperatorCalculation {

    public MulCalculation(@NonNull Calculation right) {
        super(right);
    }

    @Override
    public int value() {
        Calculation left = getLeft();
        if (left == null) {
            throw new IllegalStateException("Cannot multiply nothing. Supply left operand");
        }
        return left.value() * getRight().value();
    }
}
