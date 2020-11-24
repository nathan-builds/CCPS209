/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab11done;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author n.hans
 */
public class Primes {

    public static LinkedList<Integer> primeCache = new LinkedList();

    public static boolean isPrime(int n) {
        double nDouble = (double) n;
        if (n == 2) { // edge case
            return true;
        }
        if (n == 1) {
            return false;
        }
        for (double num = 2; num < Math.sqrt(nDouble) + 1; num++) {
            if (n % num == 0) {
                return false;
            }
        }
        return true;
    }

    public static int kthPrime(int k) {

        if (k < primeCache.size()) { // if k< primeCache size, we have it in the cache, so just get it
            return primeCache.get(k);
        } else {
            int count = primeCache.size();
            int lastPrimeInCache = 2;

            if (primeCache.size() > 0) {
                lastPrimeInCache = primeCache.get(primeCache.size() - 1) + 1;
            }
            while (count <= k) { // here k is larger than the cache, add more numbers to the cache until we have k in it and return it
                if (Primes.isPrime(lastPrimeInCache)) {

                    primeCache.add(lastPrimeInCache);
                    count++;
                }
                lastPrimeInCache++;
            }

            return (primeCache.get(k));
        }

    }

    public static List<Integer> factorize(int n) {
        LinkedList<Integer> answer = new LinkedList();
        while (n % 2 == 0) {
            answer.add(2);
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                answer.add(i);
                n /= i;
            }
        }
        if (n > 2) {
            answer.add(n);
        }
        return answer;
    }

}
