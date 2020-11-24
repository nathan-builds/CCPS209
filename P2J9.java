package Lab0Idone;

import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author n.hans
 */
public class P2J9 {

    public static void main(String[] args) {
        sumOfTwoDistinctSquares(100);
    }

    public static boolean[] sumOfTwoDistinctSquares(int n) {

        boolean[] answer = new boolean[n];
        int i = 1;
        int j = 2;

        while (i * i + j * j < n) {

            answer[i * i + j * j] = true;
            j++;

            if ((i * i + j * j) >= n) {
                i++;
                j = i + 1;
            }
        }

        return answer;
    }

    public static boolean[] subtractSquare(int n) {

        boolean[] states = new boolean[n];
        states[0] = false; // first cold element
        int sub = 1;

        for (int i = 0; i < n; i++) {
            while (i - sub * sub >= 0) {
                int num = n - (i * i);
                if (!states[num]) {
                    states[i] = true;
                    break;
                }
                sub++;
            }
        }
        return states;

    }

}
