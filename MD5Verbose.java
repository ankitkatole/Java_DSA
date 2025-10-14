import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MD5Verbose {
    // S specifies the per-round shift amounts
    private static final int[] S = {
        7,12,17,22, 7,12,17,22, 7,12,17,22, 7,12,17,22,
        5,9,14,20, 5,9,14,20, 5,9,14,20, 5,9,14,20,
        4,11,16,23, 4,11,16,23, 4,11,16,23, 4,11,16,23,
        6,10,15,21, 6,10,15,21, 6,10,15,21, 6,10,15,21
    };

    // Use binary integer part of sines of integers (Radians) as constants:
    private static final int[] K = new int[64];
    static {
        for (int i = 0; i < 64; i++) {
            K[i] = (int)(long)(Math.floor(Math.abs(Math.sin(i + 1)) * 4294967296L));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the message to hash: ");
        String input = sc.nextLine();

        System.out.println();
        System.out.println("Original Message : " + input);

        String md5 = md5Verbose(input);

        System.out.println("MD5 Hash         : " + md5);
    }

    public static String md5Verbose(String message) {
        byte[] msgBytes = message.getBytes(StandardCharsets.UTF_8);
        int originalLengthBits = msgBytes.length * 8;

        // Padding
        int numPaddingBytes = ((56 - (msgBytes.length + 1) % 64) + 64) % 64;
        byte[] padding = new byte[numPaddingBytes + 1];
        padding[0] = (byte) 0x80;

        // Combine message + padding + length
        long bitLength = (long) originalLengthBits & 0xffffffffL;
        byte[] lengthBytes = new byte[8];
        for (int i = 0; i < 8; i++) {
            lengthBytes[i] = (byte) ((bitLength >>> (8 * i)) & 0xff);
        }

        byte[] processed = new byte[msgBytes.length + padding.length + lengthBytes.length];
        System.arraycopy(msgBytes, 0, processed, 0, msgBytes.length);
        System.arraycopy(padding, 0, processed, msgBytes.length, padding.length);
        System.arraycopy(lengthBytes, 0, processed, msgBytes.length + padding.length, lengthBytes.length);

        // Initialize variables:
        int A = 0x67452301;
        int B = 0xefcdab89;
        int C = 0x98badcfe;
        int D = 0x10325476;

        // Process 512-bit chunks
        for (int i = 0; i < processed.length / 64; i++) {
            int[] M = new int[16];
            for (int j = 0; j < 16; j++) {
                int index = (i * 64) + (j * 4);
                M[j] = ((processed[index] & 0xff)) |
                       ((processed[index + 1] & 0xff) << 8) |
                       ((processed[index + 2] & 0xff) << 16) |
                       ((processed[index + 3] & 0xff) << 24);
            }

            int a = A;
            int b = B;
            int c = C;
            int d = D;

            for (int j = 0; j < 64; j++) {
                int F, g;
                if (j < 16) {
                    F = (b & c) | ((~b) & d);
                    g = j;
                } else if (j < 32) {
                    F = (d & b) | ((~d) & c);
                    g = (5 * j + 1) % 16;
                } else if (j < 48) {
                    F = b ^ c ^ d;
                    g = (3 * j + 5) % 16;
                } else {
                    F = c ^ (b | (~d));
                    g = (7 * j) % 16;
                }

                int temp = d;
                d = c;
                c = b;
                b = b + Integer.rotateLeft(a + F + K[j] + M[g], S[j]);
                a = temp;

                // Print real values after each round
                if ((j + 1) % 16 == 0) {
                    int round = (j / 16) + 1;
                    System.out.printf("Round %d Operation | A=%08x B=%08x C=%08x D=%08x%n", round, a, b, c, d);
                }
            }

            A += a;
            B += b;
            C += c;
            D += d;
        }

        return String.format("%08x%08x%08x%08x",
                Integer.reverseBytes(A),
                Integer.reverseBytes(B),
                Integer.reverseBytes(C),
                Integer.reverseBytes(D));
    }
}
