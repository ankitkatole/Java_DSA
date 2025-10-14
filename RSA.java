import java.math.BigInteger;
import java.util.Scanner;

public class RSA {
    public static void main(String[] args) {
        BigInteger p = BigInteger.valueOf(61);
        BigInteger q = BigInteger.valueOf(53);
        BigInteger n = p.multiply(q); // 3233
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = BigInteger.valueOf(17);
        BigInteger d = e.modInverse(phi);

        System.out.println("Public Key(e,n): (" + e + "," + n + ")");
        System.out.println("Private Key(d,n): (" + d + "," + n + ")");

        Scanner sc = new Scanner(System.in);
        System.out.print("Plaintext: ");
        String plainText = sc.nextLine();

        // Encrypt one char at a time
        StringBuilder cipherText = new StringBuilder();
        for (char ch : plainText.toCharArray()) {
            BigInteger pt = BigInteger.valueOf((int) ch);
            BigInteger ct = pt.modPow(e, n);
            cipherText.append(ct).append(" ");
        }
        System.out.println("Cipher Text: " + cipherText);

        // Decrypt
        String[] blocks = cipherText.toString().trim().split("\\s+");
        StringBuilder decrypted = new StringBuilder();
        for (String block : blocks) {
            BigInteger ct = new BigInteger(block);
            BigInteger pt = ct.modPow(d, n);
            decrypted.append((char) pt.intValue());
        }
        System.out.println("Decrypted text: " + decrypted);
    }
}
