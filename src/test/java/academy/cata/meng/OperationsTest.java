package academy.cata.meng;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Dmitry Meng
 * @since 1.0
 */
class OperationsTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1, 1, 2"

    })
    void sum_arabic_digits(int a, int b, int reference) {
        int result = Operations.add(a, b);
        assertEquals(reference, result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 1, 1"
    })
    void sub_arabic_digits(int a, int b, int reference) {
        int result = Operations.sub(a, b);
        assertEquals(reference, result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 2, 4"
    })
    void mul_arabic_digits(int a, int b, int reference) {
        int result = Operations.mul(a, b);
        assertEquals(reference, result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 2, 1"
    })
    void div_arabic_digits(int a, int b, int reference) {
        int result = Operations.div(a, b);
        assertEquals(reference, result);
    }
}