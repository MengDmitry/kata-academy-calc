package academy.cata.meng;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Dmitry Meng
 * @since 1.0
 */
class ConverterTest {

    @ParameterizedTest
    @CsvSource(value = {
            "X, 10",
            "XI, 11",
            "IXX, 19",
            "XXI, 21",
            "XXVIII, 28",
            "XL, 40",
            "LXXX, 80",
            "DCCC, 800",
    })
    void roman_to_arabic_convert_test(String input, int expected) {
        assertEquals(expected, Converter.romanToArabic(input));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "10, X",
            "11, XI",
            "19, XIX",
            "21, XXI",
            "28, XXVIII",
            "40, XL",
            "80, LXXX",
            "800, DCCC"
    })
    void arabic_to_roman_convert_test(int input, String expected) {
        try {
            assertEquals(expected, Converter.arabicToRoman(input));
        } catch (Exception ex) {
            assertEquals(expected, "Ex");
        }
    }
}