import java.util.Scanner;

public class AES128 {
    // AES S-box
    private static final int[] SBOX = new int[]{
        // 0     1     2    3    4     5    6    7    8    9    A    B    C    D    E    F
        0x63, 0x7c, 0x77, 0x7b, 0xf2, 0x6b, 0x6f, 0xc5, 0x30, 0x01, 0x67, 0x2b, 0xfe, 0xd7, 0xab, 0x76,
        0xca, 0x82, 0xc9, 0x7d, 0xfa, 0x59, 0x47, 0xf0, 0xad, 0xd4, 0xa2, 0xaf, 0x9c, 0xa4, 0x72, 0xc0,
        0xb7, 0xfd, 0x93, 0x26, 0x36, 0x3f, 0xf7, 0xcc, 0x34, 0xa5, 0xe5, 0xf1, 0x71, 0xd8, 0x31, 0x15,
        0x04, 0xc7, 0x23, 0xc3, 0x18, 0x96, 0x05, 0x9a, 0x07, 0x12, 0x80, 0xe2, 0xeb, 0x27, 0xb2, 0x75,
        0x09, 0x83, 0x2c, 0x1a, 0x1b, 0x6e, 0x5a, 0xa0, 0x52, 0x3b, 0xd6, 0xb3, 0x29, 0xe3, 0x2f, 0x84,
        0x53, 0xd1, 0x00, 0xed, 0x20, 0xfc, 0xb1, 0x5b, 0x6a, 0xcb, 0xbe, 0x39, 0x4a, 0x4c, 0x58, 0xcf,
        0xd0, 0xef, 0xaa, 0xfb, 0x43, 0x4d, 0x33, 0x85, 0x45, 0xf9, 0x02, 0x7f, 0x50, 0x3c, 0x9f, 0xa8,
        0x51, 0xa3, 0x40, 0x8f, 0x92, 0x9d, 0x38, 0xf5, 0xbc, 0xb6, 0xda, 0x21, 0x10, 0xff, 0xf3, 0xd2,
        0xcd, 0x0c, 0x13, 0xec, 0x5f, 0x97, 0x44, 0x17, 0xc4, 0xa7, 0x7e, 0x3d, 0x64, 0x5d, 0x19, 0x73,
        0x60, 0x81, 0x4f, 0xdc, 0x22, 0x2a, 0x90, 0x88, 0x46, 0xee, 0xb8, 0x14, 0xde, 0x5e, 0x0b, 0xdb,
        0xe0, 0x32, 0x3a, 0x0a, 0x49, 0x06, 0x24, 0x5c, 0xc2, 0xd3, 0xac, 0x62, 0x91, 0x95, 0xe4, 0x79,
        0xe7, 0xc8, 0x37, 0x6d, 0x8d, 0xd5, 0x4e, 0xa9, 0x6c, 0x56, 0xf4, 0xea, 0x65, 0x7a, 0xae, 0x08,
        0xba, 0x78, 0x25, 0x2e, 0x1c, 0xa6, 0xb4, 0xc6, 0xe8, 0xdd, 0x74, 0x1f, 0x4b, 0xbd, 0x8b, 0x8a,
        0x70, 0x3e, 0xb5, 0x66, 0x48, 0x03, 0xf6, 0x0e, 0x61, 0x35, 0x57, 0xb9, 0x86, 0xc1, 0x1d, 0x9e,
        0xe1, 0xf8, 0x98, 0x11, 0x69, 0xd9, 0x8e, 0x94, 0x9b, 0x1e, 0x87, 0xe9, 0xce, 0x55, 0x28, 0xdf,
        0x8c, 0xa1, 0x89, 0x0d, 0xbf, 0xe6, 0x42, 0x68, 0x41, 0x99, 0x2d, 0x0f, 0xb0, 0x54, 0xbb, 0x16
    };

    // Example key for AES-128 (16 bytes)
    private static final byte[] KEY = new byte[]{
        (byte)0x2b, (byte)0x7e, (byte)0x15, (byte)0x16,
        (byte)0x28, (byte)0xae, (byte)0xd2, (byte)0xa6,
        (byte)0xab, (byte)0xf7, (byte)0x5a, (byte)0x30,
        (byte)0x8e, (byte)0x03, (byte)0x2b, (byte)0x17
    };

    private static final int Nb = 4; // block size (4 columns)
    private static final int Nk = 4; // key length (4 words)
    private static final int Nr = 10; // number of rounds

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 16-char plaintext:");
        String input = sc.nextLine();
        byte[] plaintext = new byte[16];
        for (int i = 0; i < 16; i++)
            plaintext[i] = (i < input.length()) ? (byte)input.charAt(i) : 0;

        byte[][] state = new byte[4][4];
        for (int i = 0; i < 16; i++)
            state[i % 4][i / 4] = plaintext[i];

        System.out.println("\nInitial State Matrix:");
        printState(state);

        byte[][] roundKeys = keyExpansion(KEY);

        System.out.println("\nRound 0: Add Round Key");
        addRoundKey(state, roundKeys, 0);
        printState(state);

        for (int round = 1; round < Nr; round++) {
            System.out.println("\nRound " + round + ": SubBytes");
            subBytes(state);
            printState(state);

            System.out.println("Round " + round + ": ShiftRows");
            shiftRows(state);
            printState(state);

            System.out.println("Round " + round + ": MixColumns");
            mixColumns(state);
            printState(state);

            System.out.println("Round " + round + ": Add Round Key");
            addRoundKey(state, roundKeys, round);
            printState(state);
        }

        // Final round
        System.out.println("\nRound 10: SubBytes");
        subBytes(state);
        printState(state);

        System.out.println("Round 10: ShiftRows");
        shiftRows(state);
        printState(state);

        System.out.println("Round 10: Add Round Key");
        addRoundKey(state, roundKeys, Nr);
        printState(state);

        System.out.println("\nEncrypted Output (hex):");
        for (int col = 0; col < 4; col++)
            for (int row = 0; row < 4; row++)
                System.out.printf("%02X", state[row][col]);
        System.out.println();
    }

    // AES SubBytes step
    private static void subBytes(byte[][] state) {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                state[i][j] = (byte)(SBOX[state[i][j] & 0xFF]);
    }

    // AES ShiftRows step
    private static void shiftRows(byte[][] state) {
        for (int i = 1; i < 4; i++) {
            byte[] temp = new byte[4];
            for (int j = 0; j < 4; j++)
                temp[j] = state[i][(j + i) % 4];
            for (int j = 0; j < 4; j++)
                state[i][j] = temp[j];
        }
    }

    // AES MixColumns step (simplified, uses GF(2^8) linear transformation)
    private static void mixColumns(byte[][] s) {
        for (int c = 0; c < 4; c++) {
            byte a0 = s[0][c], a1 = s[1][c], a2 = s[2][c], a3 = s[3][c];
            s[0][c] = (byte)(mult(0x02, a0) ^ mult(0x03, a1) ^ a2 ^ a3);
            s[1][c] = (byte)(a0 ^ mult(0x02, a1) ^ mult(0x03, a2) ^ a3);
            s[2][c] = (byte)(a0 ^ a1 ^ mult(0x02, a2) ^ mult(0x03, a3));
            s[3][c] = (byte)(mult(0x03, a0) ^ a1 ^ a2 ^ mult(0x02, a3));
        }
    }

    // AES finite field multiplication
    private static byte mult(int a, byte b) {
        byte result = 0;
        byte bb = b;
        for (int i = 0; i < 8; i++) {
            if ((a & (1 << i)) != 0) {
                result ^= bb;
            }
            boolean hiBitSet = (bb & 0x80) != 0;
            bb <<= 1;
            if (hiBitSet)
                bb ^= 0x1b;
        }
        return result;
    }

    // AES AddRoundKey step
    private static void addRoundKey(byte[][] state, byte[][] keys, int round) {
        for (int c = 0; c < 4; c++)
            for (int r = 0; r < 4; r++)
                state[r][c] ^= keys[round * 4 + c][r];
    }

    // AES KeyExpansion (simplified, for demo: 11 round keys of 16 bytes each)
    private static byte[][] keyExpansion(byte[] key) {
        int numRounds = Nr + 1;
        byte[][] w = new byte[4 * numRounds][4];
        for (int i = 0; i < Nk; i++)
            for (int j = 0; j < 4; j++)
                w[i][j] = key[i * 4 + j];
        int[] RCON = new int[]{0x01,0x02,0x04,0x08,0x10,0x20,0x40,0x80,0x1B,0x36};

        for (int i = Nk; i < 4 * numRounds; i++) {
            byte[] temp = w[i - 1].clone();
            if (i % Nk == 0) {
                // RotWord + SubWord + RCON
                byte b = temp[0];
                temp[0] = (byte)(SBOX[temp[1] & 0xFF]);
                temp[1] = (byte)(SBOX[temp[2] & 0xFF]);
                temp[2] = (byte)(SBOX[temp[3] & 0xFF]);
                temp[3] = (byte)(SBOX[b & 0xFF]);
                temp[0] ^= RCON[(i / Nk) - 1];
            }
            for (int j = 0; j < 4; j++)
                w[i][j] ^= w[i - Nk][j] ^ temp[j];
        }
        return w;
    }

    // Print 4x4 state matrix
    private static void printState(byte[][] state) {
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++)
                System.out.printf("%02X ", state[r][c]);
            System.out.println();
        }
    }
}
