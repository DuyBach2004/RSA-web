package vn.titv.spring.helloworld.RsaDto;

import java.math.BigInteger;

public class RsaDto {
    private String message;
    private String decrypted;
    private String privateKey;
    private String pulicKey;
    private String n;

    public RsaDto(String message, String decrypted, String privateKey, String pulicKey, String n) {
        this.message = message;
        this.decrypted = decrypted;
        this.privateKey = privateKey;
        this.pulicKey = pulicKey;
        this.n = n;
    }

    public RsaDto() {
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

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPulicKey() {
        return pulicKey;
    }

    public void setPulicKey(String pulicKey) {
        this.pulicKey = pulicKey;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }
}
