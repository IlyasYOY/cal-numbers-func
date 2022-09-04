package com.github.ilyasyoy.calnumbersfunc.base;

import com.github.ilyasyoy.calnumbersfunc.operator.OperatorCalculation;
import lombok.NonNull;

public interface Calculation {

    int value();

    static Calculation number(int number) {
        return new NumberCalculation(number);
    }

    static Calculation number(int number, @NonNull OperatorCalculation calculation) {
        return calculation.apply(number(number));
    }

    static Calculation seven() {
        return number(7);
    }

    static Calculation seven(@NonNull OperatorCalculation calculation) {
        return calculation.apply(seven());
    }

    static Calculation six() {
        return number(6);
    }

    static Calculation six(@NonNull OperatorCalculation calculation) {
        return calculation.apply(six());
    }

}
