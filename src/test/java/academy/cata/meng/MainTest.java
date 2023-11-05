package academy.cata.meng;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Dmitry Meng
 * @since 1.0
 */
class MainTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1 + 2, 3",
            "VI / III, II",
            "I - II, Ex",
            "I + 1, Ex",
            "1, Ex",
            "1 + 2 + 3, Ex"
    })
    void calculate_test(String expression, String expected) {
        try {
            assertEquals(expected, Main.calc(expression));
        } catch (Exception ex) {
            assertEquals(expected, "Ex");
        }
    }
}