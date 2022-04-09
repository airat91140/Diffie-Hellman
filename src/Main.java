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

    public static void main(String[] args) {
        test(BigInteger.valueOf(23L), BigInteger.valueOf(5L));
        System.out.println();
        BigInteger prime = Service.generateRandomPrime();
        test(prime, Service.generatePrimitiveRoot(prime));
    }
}
