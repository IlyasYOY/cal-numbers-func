package com.github.ilyasyoy.calnumbersfunc.operator;

import com.github.ilyasyoy.calnumbersfunc.base.Calculation;

public interface OperatorCalculation extends Calculation {
    OperatorCalculation apply(Calculation calculation);

    static OperatorCalculation plus(Calculation calculation) {
        return new PlusCalculation(calculation);
    }

    static OperatorCalculation mul(Calculation calculation) {
        return new MulCalculation(calculation);
    }

    static OperatorCalculation minus(Calculation calculation) {
        return new MinusCalculation(calculation);
    }
}
