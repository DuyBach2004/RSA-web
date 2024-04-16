package vn.titv.spring.helloworld.RSA;


import java.math.BigInteger;
import java.util.Random;

public class RSA {
    private final int VERSION1 = 64;
    private final int VERSION2 = 2048;

    private BigInteger p;
    private BigInteger q;
    private BigInteger n;
    private BigInteger phiN;
    private BigInteger d;
    private BigInteger C;
//    private final BigInteger e = new BigInteger("65537");
private BigInteger e;
    private String message;
    private String decrypted;
    private BigInteger privateKey;
    private BigInteger pulicKey;

    public void initialize(){
        p = BigInteger.probablePrime(VERSION2 / 2, new Random());
        q = BigInteger.probablePrime(VERSION2 / 2, new Random());
        n = p.multiply(q);
        phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        // Tạo một số nguyên tố ngẫu nhiên cho e
        do {// Đoạn mã này tạo ra một số nguyên lớn mới (BigInteger) có độ dài bit bằng phiN
            e = new BigInteger(phiN.bitLength(), new Random());
        } while (!e.gcd(phiN).equals(BigInteger.ONE) || e.compareTo(BigInteger.ONE) <= 0 || e.compareTo(phiN) >= 0);
        d = e.modInverse(phiN);
    }
    public RSA(BigInteger p, BigInteger q, BigInteger n, BigInteger phiN, BigInteger d, BigInteger c, String message, String decrypted, BigInteger privateKey, BigInteger pulicKey) {
        this.p = p;
        this.q = q;
        this.n = n;
        this.phiN = phiN;
        this.d = d;
        C = c;
        this.message = message;
        this.decrypted = decrypted;
        this.privateKey = privateKey;
        this.pulicKey = pulicKey;
    }


    public BigInteger encrypt(BigInteger message) {
        return message.modPow(e, n);
    }

    public BigInteger decrypt(BigInteger cipher) {
        return cipher.modPow(d, n);
    }
    public RSA() {
    }

    public BigInteger getP() {
        return p;
    }

    public void setP(BigInteger p) {
        this.p = p;
    }

    public BigInteger getQ() {
        return q;
    }

    public void setQ(BigInteger q) {
        this.q = q;
    }

    public BigInteger getN() {
        return n;
    }

    public void setN(BigInteger n) {
        this.n = n;
    }

    public BigInteger getPhiN() {
        return phiN;
    }

    public void setPhiN(BigInteger phiN) {
        this.phiN = phiN;
    }

    public BigInteger getD() {
        return d;
    }

    public void setD(BigInteger d) {
        this.d = d;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDecrypted() {
        return decrypted;
    }

    public void setDecrypted(String decrypted) {
        this.decrypted = decrypted;
    }

    public int getVERSION1() {
        return VERSION1;
    }

    public int getVERSION2() {
        return VERSION2;
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getC() {
        return C;
    }

    public void setC(BigInteger c) {
        C = c;
    }

    public BigInteger getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(BigInteger privateKey) {
        this.privateKey = privateKey;
    }

    public BigInteger getPulicKey() {
        return pulicKey;
    }

    public void setPulicKey(BigInteger pulicKey) {
        this.pulicKey = pulicKey;
    }
}
