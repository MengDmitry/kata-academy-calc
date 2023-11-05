package academy.cata.meng;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Dmitry Meng
 * @since 1.0
 */
public class Main {
    private static final String OPERATION_PATTERN = "(.*) ?([\\+\\-\\*\\/]) ?(.*)";

    public static void main(String[] args) throws IllegalArgumentException {
        boolean isInterrupted = false;
        while (!isInterrupted) {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            if (input.equals("end")) {
                isInterrupted = true;
            }
            System.out.println(calc(input));
        }
    }

    public static String calc(String input) throws IllegalArgumentException {
        input = input.replaceAll("\\s+", "");
        String a = getOperand(input, 1);
        String operator = getOperand(input, 2);
        String b = getOperand(input, 3);
        OperandType digitsType = Validator.validate(a, b, operator);
        int firstOperand;
        int secondOperand;
        switch (digitsType) {
            case ARABIC_DIGIT -> {
                firstOperand = Integer.parseInt(a);
                secondOperand = Integer.parseInt(b);

            }
            case ROMAN_DIGIT -> {
                firstOperand = Converter.romanToArabic(a);
                secondOperand = Converter.romanToArabic(b);
            }
            default -> throw new IllegalArgumentException("Wrong arguments type");
        }
        checkValue(firstOperand, digitsType);
        checkValue(secondOperand, digitsType);
        int result = calculate(operator, firstOperand, secondOperand);
        return digitsType.equals(OperandType.ROMAN_DIGIT) ? Converter.arabicToRoman(result) : String.valueOf(result);
    }

    private static void checkValue(int operand, OperandType type) {
        if (operand < 10) {
            if (type.equals(OperandType.ROMAN_DIGIT) && operand <= 0) {
                throw new IllegalArgumentException("Unsupported value");
            }
            return;
        }
        throw new IllegalArgumentException("Unsupported value");
    }

    private static int calculate(String operator, int firstOperator, int secondOperator) throws IllegalArgumentException {
        return switch (Validator.getOperationType(operator)) {
            case ADD -> Operations.add(firstOperator, secondOperator);
            case SUB -> Operations.sub(firstOperator, secondOperator);
            case MUL -> Operations.mul(firstOperator, secondOperator);
            case DIV -> Operations.div(firstOperator, secondOperator);
        };
    }

    private static String getOperand(String input, int position) throws IllegalArgumentException {
        Pattern p = Pattern.compile(OPERATION_PATTERN);
        Matcher m = p.matcher(input);
        if (m.groupCount() > 3)
            throw new IllegalArgumentException("Invalid operation");
        if (m.find())
            return m.group(position);
        throw new IllegalArgumentException("Operand not found");
    }

}
