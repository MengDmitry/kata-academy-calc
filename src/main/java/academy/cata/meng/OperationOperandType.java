package academy.cata.meng;

/**
 * @author Dmitry Meng
 * @since 1.0
 */
enum OperationOperandType {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/");
    final String pattern;

    OperationOperandType(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
