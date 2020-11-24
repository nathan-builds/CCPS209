
package Lab12done;

import java.util.Iterator;
import lab11done.Primes;

/**
 *
 * @author n.hans
 */
public class PrimeGens {

    public static void main(String[] args) {
        SafePrimes p = new SafePrimes();
        for (int i = 0; i < 10; i++) {
            System.out.println(p.next());
        }
    }

    public static class TwinPrimes implements Iterator<Integer> {

        private int currentPrimePosition = 0;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            while (true) {
                int currentPrime = Primes.kthPrime(currentPrimePosition);
                if (Primes.isPrime(currentPrime + 2)) {
                    currentPrimePosition++;
                    return currentPrime;
                }
                currentPrimePosition++;

            }
        }

    }

    public static class SafePrimes implements Iterator<Integer> {

        private int currentPrimePosition = 0;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            while (true) {
                int currentPrime = Primes.kthPrime(currentPrimePosition);
                int p = (currentPrime - 1) / 2;
                if (Primes.isPrime(p) && currentPrime != 2) { // edge case on 2
                    currentPrimePosition++;
                    return currentPrime;
                }
                currentPrimePosition++;
            }

        }

    }

    public static class StrongPrimes implements Iterator<Integer> {

        private int currentPrimePosition = 1; // start at 1, first one is 11 so its fine

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            while (true) {
                int currentPrime = Primes.kthPrime(currentPrimePosition);
                int primeBefore = Primes.kthPrime(currentPrimePosition - 1);
                int primeAfter = Primes.kthPrime(currentPrimePosition + 1);
                int average = (primeBefore + primeAfter) / 2;
                if (currentPrime > average) {
                    currentPrimePosition++;
                    return currentPrime;
                }
                currentPrimePosition++;

            }
        }

    }

}
