package com.github.ilyasyoy.calnumbersfunc.operator;

import com.github.ilyasyoy.calnumbersfunc.base.Calculation;
import lombok.NonNull;

public final class MinusCalculation extends BaseOperatorCalculation {

    public MinusCalculation(@NonNull Calculation right) {
        super(right);
    }

    @Override
    public int value() {
        Calculation left = getLeft();
        if (left == null) {
            return -getRight().value();
        }
        return left.value() - getRight().value();
    }
}
