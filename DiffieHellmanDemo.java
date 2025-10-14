import java.util.Scanner;

public class DiffieHellmanDemo {
    // Function to calculate (base^exponent) % modulus
    private static long power(long base, long exponent, long modulus) {
        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result = (result * base) % modulus;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a prime number (P):");
        long P = sc.nextLong();

        System.out.println("Enter a primitive root modulo P (G):");
        long G = sc.nextLong();

        System.out.println("Person 1: Enter private key:");
        long a = sc.nextLong();

        System.out.println("Person 2: Enter private key:");
        long b = sc.nextLong();

        long person1Public = power(G, a, P);
        long person2Public = power(G, b, P);

        System.out.println("Person 1's Public Key (sent to Person 2): " + person1Public);
        System.out.println("Person 2's Public Key (sent to Person 1): " + person2Public);

        long sharedKeyPerson1 = power(person2Public, a, P);
        long sharedKeyPerson2 = power(person1Public, b, P);

        System.out.println("Person 1: Computed Shared Key: " + sharedKeyPerson1);
        System.out.println("Person 2: Computed Shared Key: " + sharedKeyPerson2);

        if (sharedKeyPerson1 == sharedKeyPerson2) {
            System.out.println("Secure Key Exchange Succeeded!");
        } else {
            System.out.println("Key Exchange Failed.");
        }
    }
}
