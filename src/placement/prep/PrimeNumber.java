package placement.prep;

public class PrimeNumber {

    private static boolean isPrime (int n) {
        if (n <= 1) return false;

        int c = 2;
        while (c * c <= n) {
            if (n % c == 0) {
                return false;
            }

            c++;
        }
        return true;
    }

    private static void sieve(int n, boolean[] primes) {
        for (int i = 2; i*i <= n; i++) {
            if (!primes[i]) {
                for (int j = i*2; j <= n; j+=i) {
                    primes[j] = true;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (!primes[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(isPrime(n));

        int num = 40;
        boolean[] primes = new boolean[num+1];
        sieve(num, primes);
    }
}
