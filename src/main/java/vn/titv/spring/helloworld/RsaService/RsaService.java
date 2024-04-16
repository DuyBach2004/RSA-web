package vn.titv.spring.helloworld.RsaService;

import java.math.BigInteger;
import java.util.List;

public interface RsaService {
    public List<Integer> timsonguyento(List<Integer> daySoNguyen);
    public BigInteger quyDoiChuSangSO(String message);
    public String quySoChuSangChu(BigInteger chuoiso);
    public BigInteger timD(BigInteger n,BigInteger e);
    public boolean checkLaSoNguyen(int n);
    public int uocChungLonNhat(int a,int b);
    public boolean checkLaSoNguyenToCungNhau(int n);
    public BigInteger khoaCongKhai();
    public BigInteger khoaBiMat();
    public BigInteger encrypt(BigInteger mesage, BigInteger N,BigInteger publicKey);
    public BigInteger decrypt(BigInteger mesageEncrypted, BigInteger N,BigInteger d);
    public String quySoChuSangChu2(BigInteger chuoiso);
    public BigInteger quyDoiChuSangSO2(String message);
    public List<String> splitString(String str, int chunkSize);
    public String joinStrings(List<String> strings);
    public BigInteger stringToBigInteger(String message);
    public String bigIntegerToString(BigInteger message);
}
