package academy.cata.meng;

/**
 * @author Dmitry Meng
 * @since 1.0
 */
enum OperandType {
    ARABIC_DIGIT("\\d*"),
    ROMAN_DIGIT("[IVXLCDM]*"),
    OPERATOR("[\\+\\-\\*\\/]");
    final String pattern;

    OperandType(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
