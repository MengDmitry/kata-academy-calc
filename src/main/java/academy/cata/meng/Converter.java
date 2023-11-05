package academy.cata.meng;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static academy.cata.meng.RomanCharacterType.*;


/**
 * @author Dmitry Meng
 * @since 1.0
 */
class Converter {
    private Converter() {
    }

    public static int romanToArabic(String input) {
        List<RomanCharacterType> chars = input.chars()
                .mapToObj(e -> getRomanChar((char) e)).collect(Collectors.toList());
        int value = 0;
        while (!chars.isEmpty()) {
            RomanCharacterType current = chars.remove(0);
            if (!chars.isEmpty() && current.shouldCombine(chars.get(0)))
                value += current.toInt(chars.remove(0));
            else
                value += current.toInt();
        }
        return value;
    }

    public static String arabicToRoman(int number) throws IllegalArgumentException {
        if (number <= 0) {
            throw new IllegalArgumentException("Invalid result value for roman numerals");
        }

        StringBuilder sb = new StringBuilder();
        Iterator<RomanCharacterType> iterator = Arrays.stream(values()).iterator();
        RomanCharacterType currentChar = iterator.next();
        while (number > 0) {
            if (currentChar.toInt() <= number) {
                sb.append(currentChar.name());
                number -= currentChar.toInt();
            } else {
                currentChar = iterator.next();
            }
        }
        return sb.toString();
    }

    private static RomanCharacterType getRomanChar(char e) throws IllegalStateException {
        return switch (e) {
            case 'I' -> I;
            case 'V' -> V;
            case 'X' -> X;
            case 'L' -> L;
            case 'C' -> C;
            case 'D' -> D;
            case 'M' -> M;
            default -> throw new IllegalStateException("Unexpected value: " + e);
        };
    }
}
