package com.github.ilyasyoy.calnumbersfunc.operator;

import com.github.ilyasyoy.calnumbersfunc.base.Calculation;
import lombok.NonNull;
import org.springframework.lang.Nullable;

public abstract class BaseOperatorCalculation implements OperatorCalculation {

    @NonNull
    private final Calculation right;
    @Nullable
    private Calculation left;

    public BaseOperatorCalculation(@NonNull Calculation right) {
        this.right = right;
    }

    @Override
    public OperatorCalculation apply(Calculation calculation) {
        left = calculation;
        return this;
    }

    protected Calculation getRight() {
        return right;
    }

    protected Calculation getLeft() {
        return left;
    }
}
