package symetric;

import util.CryptoTools;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Q1to3CipherAPI {
    public static void main(String[] args) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        Q1();
        Q2();
    }

    private static void Q1() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        // Problem: Decrypt the ciphertext
        byte[] keyBytes = CryptoTools.hexToBytes("9F0DCEDB322F3C6873F9256E01376BA4");
        byte[] ivBytes = CryptoTools.hexToBytes("20FC19123087BF6CAC8D0F1254123004");
        byte[] ct = CryptoTools.hexToBytes("F38ADBA8A7B4CC613578355032205D50");

        byte[] ptBytes = SymmetricEngine.decrypt(ct, keyBytes, ivBytes, "AES/CBC/PKCS5Padding");

        System.out.println(new String(ptBytes));
    }

    private static void Q2() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        // Problem: Decrypt the ciphertext
        byte[] keyBytes = "DO NOT TELL EVE!".getBytes();
        byte[] ivBytes = CryptoTools.hexToBytes("20FC19123087BF6CAC8D0F1254123004");
        byte[] ct = CryptoTools.hexToBytes("3188073EA5DB3F5C05B6307B3595607135F5D4B22F2C3EB710AA31377F78B997");

        byte[] ptBytes = SymmetricEngine.decrypt(ct, keyBytes, ivBytes, "AES/CBC/PKCS5Padding");

        System.out.println(new String(ptBytes));
    }

}
