package academy.cata.meng;

/**
 * @author Dmitry Meng
 * @since 1.0
 */
enum RomanCharacterType {
    M(1000), CM(900), D(500), CD(400),
    C(100), XC(90), L(50), XL(40),
    X(10), IX(9), V(5), IV(4), I(1);

    private final int value;

    RomanCharacterType(int value) {
        this.value = value;
    }

    public int toInt() {
        return value;
    }

    public boolean shouldCombine(RomanCharacterType next) {
        return this.value < next.value;
    }

    public int toInt(RomanCharacterType next) {
        return next.value - this.value;
    }
}