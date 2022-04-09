package app.novacode.myservice.src.domain.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Generator {



    static public String recoveryCode(long timer) throws NoSuchAlgorithmException {

        MessageDigest MD5 = MessageDigest.getInstance("MD5");

        byte[] messageDigest = MD5.digest(new byte[]{(byte) timer});

        BigInteger number = new BigInteger(1, messageDigest);

        return number.toString(16);

    }
}
