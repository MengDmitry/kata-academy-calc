package academy.cata.meng;

import java.util.regex.Pattern;

/**
 * @author Dmitry Meng
 * @since 1.0
 */
class Validator {
    private Validator() {
    }

    public static OperandType validate(String a, String b, String operator) throws IllegalArgumentException {
        OperandType firstOperandType = getOperandType(a);
        OperandType operationOperandType = getOperandType(operator);
        OperandType thirdOperandType = getOperandType(b);

        if (firstOperandType.equals(thirdOperandType)) {
            if (operationOperandType.equals(OperandType.OPERATOR)) {
                return firstOperandType;
            }
            throw new IllegalArgumentException("Operation not found");
        }
        throw new IllegalArgumentException("Operands is different");
    }

    public static OperandType getOperandType(String input) throws IllegalArgumentException {
        for (OperandType operandType : OperandType.values()) {
            boolean result = patternMatches(input, operandType.getPattern());
            if (result) {
                return operandType;
            }
        }
        throw new IllegalArgumentException("Invalid operation");
    }

    public static OperationOperandType getOperationType(String input) throws IllegalArgumentException {
        for (OperationOperandType operationType : OperationOperandType.values()) {
            boolean result = input.equals(operationType.getPattern());
            if (result) {
                return operationType;
            }
        }
        throw new IllegalArgumentException("Invalid operation type");
    }

    private static boolean patternMatches(String emailAddress, String pattern) {
        return Pattern.compile(pattern)
                .matcher(emailAddress)
                .matches();
    }
}
