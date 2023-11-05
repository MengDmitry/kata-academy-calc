package academy.cata.meng;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Dmitry Meng
 * @since 1.0
 */
class ValidatorTest {
    @ParameterizedTest
    @CsvSource(value = {
            "I, ROMAN_DIGIT",
            "II, ROMAN_DIGIT",
            "IV, ROMAN_DIGIT",
            "VI, ROMAN_DIGIT",
            "V, ROMAN_DIGIT",
            "MDCL, ROMAN_DIGIT",
            "M1DCL, Ex",
            "1, ARABIC_DIGIT",
            "0, ARABIC_DIGIT",
            "-1, Ex",
            "5, ARABIC_DIGIT",
            "11, ARABIC_DIGIT",
    })
    void validate_digits(String input, String type) {
        try {
            assertEquals(type, Validator.getOperandType(input).name());
        } catch (IllegalArgumentException e) {
            assertEquals(type, "Ex");
        }
    }
}