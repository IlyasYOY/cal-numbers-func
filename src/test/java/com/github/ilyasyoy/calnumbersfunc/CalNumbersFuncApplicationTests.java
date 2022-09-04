package com.github.ilyasyoy.calnumbersfunc;

import com.github.ilyasyoy.calnumbersfunc.base.Calculation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.github.ilyasyoy.calnumbersfunc.base.Calculation.seven;
import static com.github.ilyasyoy.calnumbersfunc.base.Calculation.six;
import static com.github.ilyasyoy.calnumbersfunc.operator.OperatorCalculation.minus;
import static com.github.ilyasyoy.calnumbersfunc.operator.OperatorCalculation.mul;
import static com.github.ilyasyoy.calnumbersfunc.operator.OperatorCalculation.plus;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CalNumbersFuncApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void shouldCreateNumbers() {
        Calculation calculation = seven();

        assertEquals(7, calculation.value());
    }

    @Test
    void shouldSupportAddOperation() {
        assertEquals(13, seven(plus(six())).value());
    }

    @Test
    void shouldSupportMulOperation() {
        assertEquals(42, seven(mul(six())).value());
    }

    @Test
    void shouldSupportMulTwoTimesOperation() {
        assertEquals(294, seven(mul(seven(mul(six())))).value());
    }

    @Test
    void shouldSupportMinusOperation() {
        assertEquals(1, seven(minus(six())).value());
    }

    @Test
    void shouldErrorMul() {
        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> mul(seven()).value());

        assertAll(
                () -> assertNull(illegalStateException.getCause()),
                () -> assertEquals("Cannot multiply nothing. Supply left operand", illegalStateException.getMessage())
        );
    }

    @Test
    void shouldErrorMinus() {
        Integer integer = assertDoesNotThrow(() -> minus(seven()).value());

        assertEquals(-7, integer);
    }

    @Test
    void shouldErrorPlus() {
        Integer integer = assertDoesNotThrow(() -> plus(seven()).value());

        assertEquals(7, integer);
    }
}
