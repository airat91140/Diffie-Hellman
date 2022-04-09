import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Service { // class that provides service functions for Diffie-Hellman algorithm
    public static BigInteger generateRandomPrime() {
        Random random = new Random();
        BigInteger result;
        do {
            try {
                result = BigInteger.probablePrime(random.nextInt(32) + 8, random);
                break;
            } catch (ArithmeticException ignored) {
                System.out.println("oops, random prime did not generated, trying again");
            }
        } while (true);
        return result;
    }

    private static List<BigInteger> getDivisors(BigInteger n) {
        List<BigInteger> result = new LinkedList<>();
        BigInteger i;
        for (i = BigInteger.TWO; i.compareTo(n.divide(BigInteger.TWO)) <= 0; i = i.add(BigInteger.ONE)) {
            if (n.mod(i).equals(BigInteger.ZERO))
                result.add(i);
        }
        return result;
    }

    public static BigInteger generatePrimitiveRoot(BigInteger prime) {
        List<BigInteger> divisors = getDivisors(prime.subtract(BigInteger.ONE));
        for (BigInteger i = BigInteger.TWO; i.compareTo(prime) < 0; i = i.add(BigInteger.ONE)) {
            BigInteger finalI = i;
            if (divisors.parallelStream().noneMatch(j -> finalI.pow(j.intValue()).subtract(BigInteger.ONE).mod(prime).equals(BigInteger.ZERO))) {
                return i;
            }
        }
        return null;
    }
}
