package com.github.ilyasyoy.calnumbersfunc.operator;

import com.github.ilyasyoy.calnumbersfunc.base.Calculation;
import lombok.NonNull;

public class PlusCalculation extends BaseOperatorCalculation {

    public PlusCalculation(@NonNull Calculation right) {
        super(right);
    }

    @Override
    public int value() {
        if (getLeft() == null) {
            return getRight().value();
        }
        return getLeft().value() + getRight().value();
    }
}
