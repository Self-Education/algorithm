import java.util.ArrayList;
import java.util.Arrays;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        ArrayList<Integer> primes = new ArrayList<>();
        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
        primes = sieveOfEratosthenes.findPrimes(10);
        System.out.println(Arrays.toString(primes.toArray()));
    }

    /*
     * given a number n, find all primes that is less than n
     */
    public ArrayList<Integer> findPrimes(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        if (n < 2)
            return primes;

        // because all non-primes is divisible by primes, so we flag all numbers that is
        // divisible by primes
        int[] flags = new int[n + 1]; // here 0 means prime
        flags[0] = 1;
        flags[1] = 1;
        int prime = 2;
        while (prime * prime <= n) {
            // flag all numbers that is divisible by i
            flag(flags, prime);
            // get next non-flagged number
            prime = getNext(flags, prime + 1);
            System.out.println(prime);
        }

        for (int j = 1; j <= n; j++) {
            if (flags[j] == 0) {
                primes.add(j);
            }
        }
        return primes;

    }

    void flag(int[] flags, int prime) {
        for (int i = prime * prime; i <= flags.length - 1; i += prime) {
            flags[i] = 1;
        }
    }

    int getNext(int[] flags, int prime) {
        while (flags[prime] != 0 && prime < flags.length - 1) {
            prime++;
        }
        return prime;
    }
}
