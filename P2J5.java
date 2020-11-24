package Lab0Edone;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author n.hans
 */
public class P2J5 {

    private static List<BigInteger> fibs = new LinkedList<>();

    public static void main(String[] args) {
        BigInteger i = BigInteger.valueOf(1000000);
        P2J5.sevenZero(1000);
    }

    static {
        fibs.add(BigInteger.ONE);
        fibs.add(BigInteger.ONE);
    }

    public static List<BigInteger> fibonacciSum(BigInteger n) {

        int fibsSize = fibs.size();
        BigInteger lastFib = fibs.get(fibsSize - 1);
        BigInteger secondLastFib = fibs.get(fibsSize - 2);
        List<BigInteger> answer = new LinkedList();
        BigInteger copyN = new BigInteger(n.toString());

        if (n.compareTo(lastFib) > 0) { // means its larger than what we have in the list

            // builds the list of fibs
            while (n.compareTo(lastFib) > 0) {
                fibsSize = fibs.size();
                lastFib = fibs.get(fibsSize - 1);
                secondLastFib = secondLastFib = fibs.get(fibsSize - 2);
                fibs.add(lastFib.add(secondLastFib));

            }
        }

        int fibsIndex = fibs.size() - 1;
        BigInteger fib = fibs.get(fibsIndex);
        // this now looks for the answer now the the fibs list is long enough
        while (true) {
            if (n.compareTo(fib) > 0 || n.compareTo(fib) == 0) {
                answer.add(fib);
                BigInteger sum = BigInteger.valueOf(0);
                for (BigInteger b : answer) {
                    sum = sum.add(b);
                }
                if (sum.equals(copyN)) {
                    return answer;
                } else {
                    n = n.subtract(fib);
                    fibsIndex--;
                    fib = fibs.get(fibsIndex);
                }
            } else {
                fibsIndex--;
                fib = fibs.get(fibsIndex);
            }
        }

    }

    public static BigInteger sevenZero(int n) {
        String val = "7";
        BigInteger number = new BigInteger(Integer.toString(n));

        if (n % 2 != 0 && n % 5 != 0) {
            while (!number.mod(new BigInteger(val)).equals(0)) {
                val = val + "7";
            }
        } else {
            int i = 0;
            while (true) {

                StringBuilder currentValue = new StringBuilder("7");
                String seven = "7";
                i += 1;

                for (int count = 0; count < i; count++) {
                    currentValue.append("0");
                }

                for (int j = 1; j <= i; j++) {
                    BigInteger numToDivide = new BigInteger(currentValue.toString());
                    if (numToDivide.mod(number).intValue()==0) {
                        return new BigInteger(currentValue.toString());
                    } else {
                        currentValue.setCharAt(j, seven.charAt(0));

                    }
                }
            }

        }
        return null;
    }

}
