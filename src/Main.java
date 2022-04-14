import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {
    public static void test(BigInteger p, BigInteger g) {
        Abonent bob = new Abonent(p, g, "Bob");
        Abonent alice = new Abonent(p, g, "Alice");
        BigInteger bobFun = bob.sendOneSideFunction();
        BigInteger aliceFun = alice.sendOneSideFunction();
        bob.receiveOneSideFunction(aliceFun);
        alice.receiveOneSideFunction(bobFun);
    }

    public static void anotherTest(BigInteger p, BigInteger g) {
        Abonent bob = new Abonent(p, g, "Bob");
        Abonent alice = new Abonent(p, g, "Alice");
        bob.setSideKey(BigInteger.valueOf(3L));
        alice.setSideKey(BigInteger.valueOf(2L));
        BigInteger bobFun = bob.sendOneSideFunction(); // 5^3 mod23 = 10
        BigInteger aliceFun = alice.sendOneSideFunction(); // 5^2 mod23 = 2
        bob.receiveOneSideFunction(aliceFun); // 10 ^ 3 mod 23 = 8
        alice.receiveOneSideFunction(bobFun); // 2 ^ 3 mod 23 = 8
    }

    public static void main(String[] args) {
        test(BigInteger.valueOf(23L), BigInteger.valueOf(5L));
        System.out.println();
        BigInteger prime = Service.generateRandomPrime();
        test(prime, Service.generatePrimitiveRoot(prime));
        System.out.println();
        anotherTest(BigInteger.valueOf(23L), BigInteger.valueOf(5L));
    }
}
