import java.math.BigInteger;


public class Factorial {

    public static BigInteger factRecursion(int num) {
        BigInteger result;

        if (num == 1 || num == 0) {
            return BigInteger.ONE;
        } else {
            result = factRecursion(num - 1).multiply(BigInteger.valueOf(num));
        }
        return result;
    }
}
