package vn.titv.spring.helloworld.RsaService;
import org.springframework.stereotype.Service;
import vn.titv.spring.helloworld.RSA.RSA;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
@Service
public class RsaServiceImplment implements RsaService{
    @Override
    public List<Integer> timsonguyento(List<Integer> daySoNguyen) {
        return null;
    }

    @Override
    public BigInteger quyDoiChuSangSO2(String message) {
        BigInteger chuoiso= new BigInteger("0");
        String[] mangMessage= message.split("");
        for (String character : mangMessage) {
            // Chuyển ký tự thành số tương ứng (A=1, B=2, ..., Z=26)
            int soTuongUng = character.charAt(0) - 'a' + 1;
            chuoiso = chuoiso.multiply(BigInteger.valueOf(26)).add(BigInteger.valueOf(soTuongUng));
        }
        return chuoiso;
    }
    @Override
    public List<String> splitString(String str, int chunkSize) {
        int len = str.length();
        List<String> splitStrings = new ArrayList<>();
        for (int i = 0; i < len; i += chunkSize) {
            splitStrings.add(str.substring(i, Math.min(len, i + chunkSize)));
        }
        return splitStrings;
    }
    @Override
    public String joinStrings(List<String> strings) {
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();
    }
    @Override
public BigInteger quyDoiChuSangSO(String message) {
    BigInteger chuoiso= convertToBinaryWithSpaces(convertToNumbers(message));
    return chuoiso;
}
    @Override
    public String quySoChuSangChu2(BigInteger chuoiso) {
       String chuoi=convertFromBinary2(chuoiso);
        String ketqua=convertToChars(chuoi);
        return ketqua;
    }
    public static String convertFromBinary2(BigInteger input) {
        // Chuyển đổi BigInteger thành chuỗi
        String inputStr = input.toString(36);

        // Thay thế tất cả các chuỗi "T" bằng khoảng trắng
        String replacedInput = inputStr.replaceAll("t", " ");

        return replacedInput;
    }
    public static String convertToChars(String input) {
        StringBuilder sb = new StringBuilder();
        for (String numStr : input.split(" ")) {
            sb.append((char) Integer.parseInt(numStr));
        }
        return sb.toString();
    }
    public static BigInteger convertToBinaryWithSpaces(String input) {
        // Thay thế tất cả các khoảng trắng bằng chuỗi "T"
        String replacedInput = input.replaceAll(" ", "T");

        // Chuyển đổi chuỗi đã thay thế thành BigInteger
        BigInteger result = new BigInteger(replacedInput, 36);

        return result;
    }
    public static String convertToNumbers(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            sb.append((int) c).append(" ");
        }
        return sb.toString().trim();
    }

    @Override
    public String quySoChuSangChu(BigInteger chuoiso) {
        // Khởi tạo chuỗi kết quả
        String message = "";

        // Định nghĩa bảng chữ cái (A=1, B=2, ..., Z=26)
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        // Trong khi chuoiso lớn hơn 0
        while (chuoiso.compareTo(BigInteger.ZERO) > 0) {
            // Tính phần dư khi chia cho 26
            BigInteger remainder = chuoiso.mod(BigInteger.valueOf(26));

            // Nếu phần dư là 0, gán nó thành 26 (Z)
            if (remainder.equals(BigInteger.ZERO)) {
                remainder = BigInteger.valueOf(26);
            }

            // Thêm ký tự tương ứng vào chuỗi kết quả
            message = alphabet.charAt(remainder.intValue() - 1) + message;

            // Cập nhật chuoiso bằng cách chia cho 26
            chuoiso = chuoiso.subtract(remainder).divide(BigInteger.valueOf(26));
        }

        return message;
    }

//    public String quySoChuSangChu(BigInteger chuoiso) {
//        // Khởi tạo chuỗi kết quả
//        String message = "";
//
//        // Định nghĩa bảng chữ cái (A=1, B=2, ..., Z=26)
//        String alphabet = "abcdefghijklmnopqrstuvwxyz";
//
//        // Trong khi chuoiso lớn hơn 0
//        while (chuoiso.compareTo(BigInteger.ZERO) > 0) {
//            // Tính phần dư khi chia cho 26
//            BigInteger remainder = chuoiso.mod(BigInteger.valueOf(26));
//
//            // Nếu phần dư là 0, gán nó thành 26 (Z)
//            if (remainder.equals(BigInteger.ZERO)) {
//                remainder = BigInteger.valueOf(26);
//            }
//
//            // Thêm ký tự tương ứng vào chuỗi kết quả
//            message = alphabet.charAt(remainder.intValue() - 1) + message;
//
//            // Cập nhật chuoiso bằng cách chia cho 26
//            chuoiso = chuoiso.subtract(remainder).divide(BigInteger.valueOf(26));
//        }
//
//        return message;
//    }
//    public BigInteger quyDoiChuSangSO2(String message) {
//        BigInteger chuoiso= new BigInteger("0");
//        String[] mangMessage= message.split("");
//        String chuoiChuCaiTiengViet = "abcdefghijklmnopqrstuvwxyzáàảãạăắằẳẵặâấầẩẫậéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđ";
//        String[] chuoiChuCaiTiengViets=chuoiChuCaiTiengViet.split("");
//        System.out.println();
//
//    }
    @Override
    public BigInteger timD(BigInteger n, BigInteger e) {
        BigInteger d=new BigInteger("0");
        for (int i=1;i<100000;i++){
            BigInteger[] check=n.multiply(BigInteger.valueOf(i)).add(BigInteger.ONE).divideAndRemainder(e);
            BigInteger quotient1 = check[0]; // Kết quả chia
            BigInteger remainder2 = check[1]; // Phần dư
            if (remainder2.equals(BigInteger.ZERO)) {
//                    System.out.println(i + " chia hết cho e. Phần dư: " + remainder2+" ketqua: "+quotient1);
                d= quotient1;
                break;
            } else {
//                    System.out.println(i + " không chia hết cho e. Phần dư: " + remainder2);
            }
        }
        return d;
    }
    @Override
    public BigInteger stringToBigInteger(String message) {
        return new BigInteger(message.getBytes());
    }
    @Override
    public String bigIntegerToString(BigInteger message) {
        return new String(message.toByteArray());
    }
//    @Override
//    public BigInteger encrypt(BigInteger mesage, BigInteger N){
//        RSA rsa=new RSA();
//        rsa.initialize();
//        return mesage.modPow(rsa.getE(),N);
//    }
@Override
public BigInteger encrypt(BigInteger mesage, BigInteger N,BigInteger e){
    return mesage.modPow(e,N);
}
    @Override
    public BigInteger decrypt(BigInteger mesageEncrypted, BigInteger N,BigInteger d){
        return mesageEncrypted.modPow(d,N);
    }
    @Override
    public boolean checkLaSoNguyen(int n) {
        if (n<=1){
            return false;
        }
        for (int i=2;i<=Math.sqrt(n);i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }

    @Override
    public int uocChungLonNhat(int a, int b) {
        if (b==0){
            return a;
        }
        return uocChungLonNhat(b,a%b);
    }

    @Override
    public boolean checkLaSoNguyenToCungNhau(int n) {
        if(n<=1){
            return false;
        }
        for (int i=2;i<n;i++){
            if (uocChungLonNhat(n,i)!=1){
                return false;
            }
        }
        return true;
    }
    @Override
    public BigInteger khoaCongKhai(){
        RSA rsa=new RSA();
        rsa.initialize();
        BigInteger Ku= rsa.getE();
        return Ku;
    }
    @Override
    public BigInteger khoaBiMat(){
        RSA rsa=new RSA();
        rsa.initialize();
        BigInteger Kn=rsa.getD();
        return Kn;
    }



}
