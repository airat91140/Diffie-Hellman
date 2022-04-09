import java.math.BigInteger;
import java.util.Random;

public class Abonent {
    private BigInteger sideKey;
    private BigInteger prime; // p in algorithm from lection
    private BigInteger primitiveRoot; // g in algorithm from lection
    private BigInteger secretKey;
    private String name;

    public Abonent(BigInteger prime, BigInteger primitiveRoot, String name) {
        Random random = new Random();
        this.prime = prime;
        this.primitiveRoot = primitiveRoot;
        sideKey = new BigInteger(random.nextInt(64) + 8, random);
        this.name = name;
        System.out.println(name + " received p(" + prime + ") g(" + primitiveRoot + ") and generated side key " + sideKey);
    }

    public BigInteger sendOneSideFunction() {
        BigInteger result = primitiveRoot.modPow(sideKey, prime);
        System.out.println(name + " send result of function " + result);
        return result;
    }

    public void receiveOneSideFunction(BigInteger result) {
        secretKey = result.modPow(sideKey, prime);
        System.out.println(name + " received result of function " + result + " and generated secret key " + secretKey);
    }
}
