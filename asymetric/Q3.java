package asymetric;

import util.Hex;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class Q3 {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
        // using these find the plaintext
        BigInteger phi = new BigInteger("8584037913642434144111279062847405921823163865842701785008602377400681495147541519557274092429073976252689387304835782258785521935078205581766754116919200");
        BigInteger q = new BigInteger("87020952829623092932322362936864583897972618059974315662422560067745889600571");
        BigInteger e = new BigInteger("65537");
        BigInteger c = new BigInteger("1817487313698347891034157970684926175211834109573277793102901854482611726141560963120214926234448852417078321539316776648109260519063106558303669880226359");

        // compute for missing variables
        BigInteger p = phi.divide(q.subtract(BigInteger.ONE)).add(BigInteger.ONE);
        BigInteger n = p.multiply(q);
        BigInteger d = e.modInverse(phi);
//        byte[] pt = AsymmetricEngine.decrypt(c, n, d, "RSA/ECB/NoPadding");
        byte[] pt = c.modPow(d, n).toByteArray();
        System.out.println(new String(pt));
//        System.out.println(Base64.getEncoder().encodeToString(pt));
//        System.out.println(Hex.toString(pt));

    }
}
