package academy.cata.meng;

/**
 * @author Dmitry Meng
 * @since 1.0
 */
class Operations {
    private Operations() {
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static int mul(int a, int b) {
        return a * b;
    }

    public static int div(int a, int b) throws IllegalArgumentException {
        if (b == 0) {
            throw new IllegalArgumentException("Divided by 0");
        }
        return a / b;
    }
}
