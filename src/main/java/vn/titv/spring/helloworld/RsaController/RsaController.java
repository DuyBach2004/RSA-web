package vn.titv.spring.helloworld.RsaController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.titv.spring.helloworld.RSA.RSA;
import vn.titv.spring.helloworld.RsaDto.RsaDto;
import vn.titv.spring.helloworld.RsaService.RsaService;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/rsa")
@CrossOrigin(origins = "*", allowedHeaders = "*")  //Giup sua loi cros khi goi api
public class RsaController {
    private RsaService rsaService;
    @Autowired
    public RsaController(RsaService rsaService) {
        this.rsaService = rsaService;
    }
//    @PostMapping()
//    public RSA maHoa(@RequestParam("chuoicanmahoa") String message, @RequestParam("version") int version){
//        RSA rsa=new RSA();
//        if (version==64){
//            //tra ve so nguyen to co chiu dai là version chia 2
//            rsa.setQ(BigInteger.probablePrime(rsa.getVERSION1()/2,new Random()));
//            rsa.setP(BigInteger.probablePrime(rsa.getVERSION1()/2,new Random()));
//        } else if (version==1024) {
//            rsa.setQ(BigInteger.probablePrime(rsa.getVERSION2()/2,new Random()));
//            rsa.setP(BigInteger.probablePrime(rsa.getVERSION2()/2,new Random()));
//        }
//        rsa.setN(rsa.getQ().multiply(rsa.getP()));
//        rsa.setPhiN(rsa.getP().subtract(BigInteger.ONE).multiply(rsa.getQ().subtract(BigInteger.ONE)));
//        rsa.setD(rsaService.timD(rsa.getN(),rsa.getE()));
//        BigInteger chuoiso=rsaService.quyDoiChuSangSO(message);
//        rsa.setC(chuoiso.modPow(rsa.getE(),rsa.getN()));
//        rsa.setDecrypted(rsaService.quySoChuSangChu(rsa.getC().modPow(rsa.getD(),rsa.getN())));
//        return rsa;
//    }
//    @GetMapping("/key")
//    public RsaDto Key(){
//        RSA rsa=new RSA();
//        Random rand = new Random();
//        int randomNum = rand.nextInt(3) + 62;
//        rsa.initialize();
//        BigInteger publicKey= rsa.getE().pow(randomNum);
//        BigInteger privateKey= rsa.getD();
//        RsaDto rsaDto=new RsaDto();
//        rsaDto.setPulicKey(rsaService.quySoChuSangChu(publicKey));
//        rsaDto.setPrivateKey(rsaService.quySoChuSangChu(privateKey));
//        rsaDto.setN(String.valueOf(rsa.getN()));
//        return rsaDto;
//    }
//    @GetMapping("/encrypt")
//    public RsaDto Encrypt(@RequestParam("message")String message,@RequestParam("publicKey")String pulicKey,@RequestParam("N") String N){
//        BigInteger convertMessage=rsaService.quyDoiChuSangSO(message);
//        BigInteger cipher=rsaService.encrypt(convertMessage,rsaService.quyDoiChuSangSO2(N));
//        System.out.println(rsaService.quySoChuSangChu(cipher));
//        RsaDto rsaDto=new RsaDto();
//        rsaDto.setN(N);
//        rsaDto.setMessage(rsaService.quySoChuSangChu(cipher));
//        rsaDto.setPulicKey(pulicKey);
//        return rsaDto;
//    }
//@PostMapping("/encrypt")
//public RsaDto Encrypt(@RequestParam("message")String message,@RequestParam("publicKey")String publicKey,@RequestParam("N") String N){
//    // Chia nhỏ chuỗi đầu vào
//    List<String> splitMessage = rsaService.splitString(message, 10);// Sử dụng số 10 như là kích thước của từng phần. Bạn có thể thay đổi con số này tùy theo nhu cầu của bạn.
//    List<String> encryptedStrings = new ArrayList<>();
//    for (String part : splitMessage) {
//        BigInteger convertMessage=rsaService.quyDoiChuSangSO(part);
//        BigInteger cipher=rsaService.encrypt(convertMessage,rsaService.quyDoiChuSangSO2(N));
//        encryptedStrings.add(rsaService.quySoChuSangChu(cipher));
//    }
//
//    // Ghép các chuỗi đã mã hóa thành một chuỗi dài
//    String encryptedMessage = rsaService.joinStrings(encryptedStrings);
//    RsaDto rsaDto=new RsaDto();
//    rsaDto.setN(N);
//    rsaDto.setMessage(encryptedMessage);
//    rsaDto.setPulicKey(publicKey);
//    return rsaDto;
//}
//    @PostMapping("/decrypt")
//    public RsaDto Decrypt(@RequestParam("message")String messageEncrypted,@RequestParam("privateKey")String privateKey,@RequestParam("N") String N){
//        // Chia nhỏ chuỗi đã mã hóa
//        List<String> splitMessage = rsaService.splitString(messageEncrypted, 218); // Sử dụng số 10 như là kích thước của từng phần. Bạn có thể thay đổi con số này tùy theo nhu cầu của bạn.
//
//        List<String> decryptedStrings = new ArrayList<>();
//        for (String part : splitMessage) {
//            BigInteger convertMessage=rsaService.quyDoiChuSangSO2(part);
//            BigInteger decrypt=rsaService.decrypt(convertMessage,rsaService.quyDoiChuSangSO2(N),rsaService.quyDoiChuSangSO2(privateKey));
//            decryptedStrings.add(rsaService.quySoChuSangChu2(decrypt));
//            System.out.println(decrypt);
//        }
//
//        // Ghép các chuỗi đã giải mã thành một chuỗi dài
//        String decryptedMessage = rsaService.joinStrings(decryptedStrings);
//        RsaDto rsaDto=new RsaDto();
//        rsaDto.setDecrypted(decryptedMessage);
//        return rsaDto;
//    }
@GetMapping("/key")
public RsaDto Key(){
    RSA rsa=new RSA();
    Random rand = new Random();
    int randomNum = rand.nextInt(3) + 62;
    rsa.initialize();
    BigInteger publicKey= rsa.getE();
    BigInteger privateKey= rsa.getD();
    RsaDto rsaDto=new RsaDto();
    rsaDto.setPulicKey(rsaService.quySoChuSangChu(publicKey));
    rsaDto.setPrivateKey(rsaService.quySoChuSangChu(privateKey));
    rsaDto.setN(String.valueOf(rsa.getN()));
    return rsaDto;
}
    @PostMapping("/encrypt")
    public RsaDto Encrypt(@RequestParam("message")String message,@RequestParam("publicKey")String pulicKey,@RequestParam("N") String N){
        BigInteger bigN = new BigInteger(N);
//        BigInteger publickey=rsaService.quySoChuSangChu2(pulicKey);
        BigInteger convertMessage=rsaService.stringToBigInteger(message);
        System.out.println("\n giải mã: "+convertMessage+"--");
        BigInteger cipher=rsaService.encrypt(convertMessage,bigN,rsaService.quyDoiChuSangSO2(pulicKey));
        System.out.println("\n mã hoá: "+cipher+"--");
        RsaDto rsaDto=new RsaDto();
        rsaDto.setN(N);
        rsaDto.setMessage(rsaService.quySoChuSangChu(cipher));
        rsaDto.setPulicKey(pulicKey);
        return rsaDto;
    }
    @PostMapping("/decrypt")
    public RsaDto Decrypt(@RequestParam("message")String messageEncrypted,@RequestParam("privateKey")String privateKey,@RequestParam("N") String N){
        BigInteger bigN = new BigInteger(N);
        List<String> splitMessage = rsaService.splitString(messageEncrypted, 100);

//        List<String> decryptedStrings = new ArrayList<>();
//        for (String part : splitMessage) {
//            BigInteger convertMessage=rsaService.quyDoiChuSangSO2(part);
//            System.out.println("Phần tử: "+convertMessage);
//            BigInteger decrypt=rsaService.decrypt(convertMessage,bigN,rsaService.quyDoiChuSangSO2(privateKey));
//            System.out.println(decrypt);
////            decryptedStrings.add(rsaService.quySoChuSangChu2(decrypt));
//
//        }

        BigInteger convertMessage=rsaService.quyDoiChuSangSO2(messageEncrypted);
        System.out.println("\n mã hoá: "+convertMessage+"--");
        BigInteger decrypt=rsaService.decrypt(convertMessage,bigN,rsaService.quyDoiChuSangSO2(privateKey));
        System.out.println("\n giải mã: "+decrypt);
        RsaDto rsaDto=new RsaDto();
        rsaDto.setDecrypted(rsaService.bigIntegerToString(decrypt));
        return rsaDto;
    }
}
