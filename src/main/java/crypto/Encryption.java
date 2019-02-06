package crypto;

import org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.math.BigInteger;
import java.security.*;

public class Encryption {
    private byte[] cipherText;

    public Encryption(PublicKey pubkey, byte[] data) throws
            NoSuchPaddingException,
            NoSuchAlgorithmException,
            NoSuchProviderException,
            InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException {

        Security.addProvider(new BouncyCastleProvider());
        IESCipher c1 = new org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher.ECIES();

        Cipher cipher = Cipher.getInstance("ECIES","BC");

        cipher.init(Cipher.ENCRYPT_MODE, pubkey);
        this.cipherText = cipher.doFinal(data);

    }

    public byte[] getCipherText() {
        return cipherText;
    }
    /*
    https://ieeexplore.ieee.org/document/6024664
    https://www.codeproject.com/Tips/1071190/Encryption-and-Decryption-of-Data-using-Elliptic-C
    */
}